package Algorithm;
import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.SwingUtilities;

import Graph.Edge;
import Graph.Vertex;
import Gui.DrawingPanel;
import Gui.MainGui;

public class BFSAlgorithm {
    private DrawingPanel drawingPanel;
    private int animationDelay;

    private boolean isConnected;
    private boolean[] visited;
    
    private Color visitedColor = Color.GREEN;
    private Color defaultColor = Color.BLACK;
    private Color pinkColor = Color.PINK;

    private Vertex startVertex;

    public BFSAlgorithm(DrawingPanel drawingPanel, Vertex startVertex, int animationDelay) {
        this.drawingPanel = drawingPanel;
        this.startVertex = startVertex;
        this.animationDelay = animationDelay;
        this.visited = new boolean[drawingPanel.getVertices().size()]; // Initialize visited array
    }

    public void printConnectivityStatusWithAnimation() {
        MainGui.textArea.setText("");
        MainGui.textArea.append("DFS Algorithm started.");

        MainGui.sideTextArea.setText("");
        MainGui.sideTextArea.append("BFS Algorithm\n");
        MainGui.sideTextArea.append("Processing...\n\n");
    
        isConnectedWithAnimation(drawingPanel.getVertices());
    }
    

    private boolean isConnectedWithAnimation(ArrayList<Vertex> vertices) {
        Queue<Vertex> queue = new LinkedList<>();
    
        visited[vertices.indexOf(startVertex)] = true;
        queue.add(startVertex);
        startVertexAnimation(startVertex, pinkColor);
        processNextVertex(queue, pinkColor, visitedColor, vertices.size());

        return true;
    }
    
    private void processNextVertex(Queue<Vertex> queue, Color colorInQueue, Color colorVisited,
            int totalVertices) {
        if (queue.isEmpty()) {
            // Reset colors at the end
            for (Vertex vertex : drawingPanel.getVertices()) {
                vertex.setColor(defaultColor);
            }
            for (Edge edge : drawingPanel.getEdges()) {
                edge.setColor(defaultColor);
            }
            drawingPanel.repaint();
            MainGui.sideTextArea.append("\nEnd the Process");

            checkConnectivity();
            return;
        }
    
        Vertex currentVertex = queue.poll();
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
                    edge.setColor(pinkColor);
                } else {
                    edge.setColor(defaultColor);
                }
            }
    
            for (Edge edge : currentVertex.getEdges()) {
                Vertex neighbor = edge.getNeighbor(currentVertex);
                int neighborIndex = drawingPanel.getVertices().indexOf(neighbor);

                if (neighborIndex != -1 && !visited[neighborIndex]) {
                    visited[neighborIndex] = true;
                    queue.add(neighbor);
                    startVertexAnimation(neighbor, colorInQueue);
                    MainGui.sideTextArea.append("  Added " + neighbor.getName() + " to the queue.\n");
    
                    edge.setColor(pinkColor);
    
                    int neighborVertexIndex = drawingPanel.getVertices().indexOf(neighbor);
                    if (neighborVertexIndex != -1) {
                        visited[neighborVertexIndex] = true;
                    }
                }
            }
        }
    
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(() -> {
                    processNextVertex(queue, colorInQueue, colorVisited, totalVertices);
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
