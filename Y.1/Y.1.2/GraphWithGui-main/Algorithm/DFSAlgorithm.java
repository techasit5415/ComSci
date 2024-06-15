package Algorithm;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.SwingUtilities;

import Graph.Edge;
import Graph.Vertex;
import Gui.DrawingPanel;
import Gui.MainGui;

public class DFSAlgorithm {
    private DrawingPanel drawingPanel;
    private int animationDelay;

    private boolean isConnected;
    private Vertex startVertex;

    
    private Color visitedColor = Color.GREEN;
    private Color defaultColor = Color.BLACK;
    private Color pinkColor = Color.PINK;

    boolean[] visited;

    public DFSAlgorithm(DrawingPanel drawingPanel, Vertex startVertex, int animationDelay) {
        this.drawingPanel = drawingPanel;
        this.startVertex = startVertex;
        this.animationDelay = animationDelay;
        this.visited = new boolean[drawingPanel.getVertices().size()];
    }

    public void printConnectivityStatusWithAnimation() {
        MainGui.textArea.setText("");
        MainGui.textArea.append("DFS Algorithm started.");

        MainGui.sideTextArea.setText("");
        MainGui.sideTextArea.append("DFS Algorithm\n");
        MainGui.sideTextArea.append("In The Processing\n\n");
        isConnected = isConnectedWithAnimation(drawingPanel.getVertices());
    }

    private boolean isConnectedWithAnimation(ArrayList<Vertex> vertices) {
        Stack<Vertex> stack = new Stack<>();

        visited[vertices.indexOf(startVertex)] = true;
        stack.push(startVertex);
        startVertexAnimation(startVertex, pinkColor);
        processNextVertex(stack, visited, pinkColor, visitedColor, vertices.size());

        return true;
    }

    private void processNextVertex(Stack<Vertex> stack, boolean[] visited, Color colorInStack, Color colorVisited,
            int totalVertices) {
        if (stack.isEmpty()) {

            for (Vertex vertex : drawingPanel.getVertices()) {
                vertex.setColor(defaultColor);
            }
            for (Edge edge : drawingPanel.getEdges()) {
                edge.setColor(defaultColor);
            }
            drawingPanel.repaint();
            MainGui.sideTextArea.append("\nEnd The Process");
            checkConnectivity();
            return;
        }

        Vertex currentVertex = stack.pop();
        int currentVertexIndex = drawingPanel.getVertices().indexOf(currentVertex);
        if (currentVertexIndex != -1) {
            MainGui.sideTextArea.append(currentVertex.getName() + " visited\n" );
            startVertexAnimation(currentVertex, colorVisited);

            for (Edge edge : currentVertex.getEdges()) {
                int startIndex = drawingPanel.getVertices().indexOf(edge.getStartVertex());
                int endIndex = drawingPanel.getVertices().indexOf(edge.getEndVertex());

                boolean startVisited = startIndex != -1 && visited[startIndex];
                boolean endVisited = endIndex != -1 && visited[endIndex];

                if (startVisited && endVisited) {
                    edge.setColor(visitedColor);
                } else if (startVisited || endVisited) {
                    edge.setColor(colorInStack);
                } else {
                    edge.setColor(defaultColor);
                }

                Vertex neighbor = edge.getNeighbor(currentVertex);
                int neighborIndex = drawingPanel.getVertices().indexOf(neighbor);

                if (neighborIndex != -1 && !visited[neighborIndex]) {
                    visited[neighborIndex] = true;
                    stack.push(neighbor);
                    startVertexAnimation(neighbor, colorInStack);
                    MainGui.sideTextArea.append("  Added " + neighbor.getName() + " to the stack.\n");
                }
            }
        }

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(() -> {
                    processNextVertex(stack, visited, colorInStack, colorVisited, totalVertices);
                });
            }
        }, animationDelay);
    }

    private void startVertexAnimation(Vertex vertex, Color targetColor) {
        vertex.setColor(targetColor);
        drawingPanel.repaint();
    }

    private void checkConnectivity() {
        isConnected = true;
        for (int i = 0; i < drawingPanel.getVertices().size(); i++) {
            if (!visited[i]) {
                isConnected = false;
                break;
            }
        }

        if (isConnected) {
            MainGui.textArea.setText("");
            MainGui.textArea.append("The graph is connected");
        } else {
            MainGui.textArea.setText("");
            MainGui.textArea.append("The graph is not connected");
        }

        MainGui.textArea.append(" with " + drawingPanel.getVertices().size() + " vertices");
        MainGui.textArea.append(" and all " + drawingPanel.getEdges().size() + " edges");

        MainGui.setToStandard();
    }
}
