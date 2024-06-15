package Gui;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

import Algorithm.BFSAlgorithm;
import Algorithm.DFSAlgorithm;
import Algorithm.DijkstraAlgorithm;
import Algorithm.PrimAlgorithm;
import ControlState.AlgorithmType;
import ControlState.AnimationState;
import Graph.Edge;
import Graph.Vertex;

public class DrawingPanel extends JPanel {
    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;
    private Vertex selectedVertex;

    private int vertexCounter = 1;
    private int edgeCounter = 1;

    private BFSAlgorithm bfsAlgorithm;
    private DFSAlgorithm dfsAlgorithm;
    private PrimAlgorithm primAlgorithm;
    private DijkstraAlgorithm dijkstraAlgorithm;

    public DrawingPanel() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
        setupPanel();

        requestFocus();
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

    }

    private void setupPanel() {
        setPreferredSize(new Dimension(700, 700));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleMouseClick(e);
                repaint();
            }
        });
    }

    private void handleMouseClick(MouseEvent e) {
        if(vertices.isEmpty()){
            MainGui.setAnimationState(AnimationState.END);
        } else{
            MainGui.setAnimationState(AnimationState.IDLE);
        }
        if ((MainGui.getAnimationState() == AnimationState.IDLE || MainGui.getAnimationState() == AnimationState.WAITING) && MainGui.getAlgorithmType() != AlgorithmType.NONE) {
            Vertex clickedVertex = findVertex(e.getPoint());
            if (clickedVertex != null) {
                handleStartVertexSelection(clickedVertex);
            } else {
                System.out.println("Please select a valid vertex.");
            }
        } else {
            if (SwingUtilities.isRightMouseButton(e)) {
                Vertex clickedVertex = findVertex(e.getPoint());
                if (clickedVertex != null) {
                    showVertexPopupMenu(e.getX(), e.getY(), clickedVertex);
                } else {
                    Edge clickedEdge = findEdge(e.getPoint());
                    if (clickedEdge != null) {
                        showEdgePopupMenu(e.getX(), e.getY(), clickedEdge);
                    }
                }
            } else {
                Vertex clickedVertex = findVertex(e.getPoint());
                if (clickedVertex != null) {
                    handleVertexClick(clickedVertex);
                } else {
                    handleEmptySpaceClick(e);
                }
            }
        }

    }

    private Edge findEdge(Point point) {
        double tolerance = 5;

        for (Edge edge : edges) {
            int x1 = edge.getStartVertex().getX();
            int y1 = edge.getStartVertex().getY();
            int x2 = edge.getEndVertex().getX();
            int y2 = edge.getEndVertex().getY();

            double distance = distancePointToLineSegment(point.x, point.y, x1, y1, x2, y2);

            if (distance <= tolerance) {
                return edge;
            }
        }
        return null;
    }

    private double distancePointToLineSegment(int px, int py, int x1, int y1, int x2, int y2) {
        double lineLengthSquared = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);

        if (lineLengthSquared == 0.0) {
            return Math.sqrt(Math.pow(px - x1, 2) + Math.pow(py - y1, 2));
        }

        double t = ((px - x1) * (x2 - x1) + (py - y1) * (y2 - y1)) / lineLengthSquared;
        t = Math.max(0, Math.min(1, t));

        double projX = x1 + t * (x2 - x1);
        double projY = y1 + t * (y2 - y1);

        return Math.sqrt(Math.pow(px - projX, 2) + Math.pow(py - projY, 2));
    }

    private void handleStartVertexSelection(Vertex clickedVertex) {

        if (selectedVertex != null && !selectedVertex.equals(clickedVertex)
                && MainGui.getAnimationState() == AnimationState.IDLE) {
            addEdgeBetweenVertices(selectedVertex, clickedVertex);
            selectedVertex.setSelected(false);
            selectedVertex = null;
        }

        if (MainGui.getAnimationState() != AnimationState.RUNNING && MainGui.getAlgorithmType() == AlgorithmType.NONE) {
            clickedVertex.setSelected(true);
        }

        selectedVertex = clickedVertex;

        if (MainGui.getAnimationState() == AnimationState.WAITING && MainGui.getAlgorithmType() == AlgorithmType.BFS) {
            MainGui.setAnimationState(AnimationState.RUNNING);
            bfsAlgorithm = new BFSAlgorithm(this, selectedVertex, MainGui.getSilderValue());
            bfsAlgorithm.printConnectivityStatusWithAnimation();
            MainGui.textArea.setText("");
            MainGui.textArea.append("BFS Algorithm started from vertex: " + selectedVertex.getName());
        } else if (MainGui.getAnimationState() == AnimationState.WAITING
                && MainGui.getAlgorithmType() == AlgorithmType.DFS) {
            MainGui.setAnimationState(AnimationState.RUNNING);
            dfsAlgorithm = new DFSAlgorithm(this, selectedVertex, MainGui.getSilderValue());
            dfsAlgorithm.printConnectivityStatusWithAnimation();
            MainGui.textArea.setText("");
            MainGui.textArea.append("DFS Algorithm started from vertex: " + selectedVertex.getName());
        } else if (MainGui.getAnimationState() == AnimationState.WAITING
                && MainGui.getAlgorithmType() == AlgorithmType.PRIM) {
            MainGui.setAnimationState(AnimationState.RUNNING);
            primAlgorithm = new PrimAlgorithm(this, MainGui.getSilderValue(), selectedVertex);
            primAlgorithm.findMSTWithAnimation();
            MainGui.textArea.setText("");
            MainGui.textArea.append("Prim's Algorithm started from vertex: " + selectedVertex.getName());
        } else if (MainGui.getAnimationState() == AnimationState.WAITING
                && MainGui.getAlgorithmType() == AlgorithmType.DIJKSTRA) {
            MainGui.setAnimationState(AnimationState.RUNNING);
            dijkstraAlgorithm = new DijkstraAlgorithm(this, MainGui.getSilderValue(), selectedVertex);
            dijkstraAlgorithm.findShortestPathsWithAnimation();
            MainGui.textArea.setText("");
            MainGui.textArea.append("Dijkstra's Algorithm started from vertex: " + selectedVertex.getName());
        }

    }

    private void showVertexPopupMenu(int x, int y, Vertex clickedVertex) {
        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem deleteMenuItem = new JMenuItem("Delete Vertex");
        deleteMenuItem.addActionListener(e -> {
            deleteVertex(clickedVertex);
            repaint();
        });
        popupMenu.add(deleteMenuItem);

        JMenuItem renameMenuItem = new JMenuItem("Rename Vertex");
        renameMenuItem.addActionListener(e -> {
            String newName = JOptionPane.showInputDialog("Enter new name for the Vertex:");
            if (newName != null && !newName.isEmpty()) {
                clickedVertex.setName(newName);
                repaint();
            }
        });
        popupMenu.add(renameMenuItem);

        popupMenu.show(this, x, y);
    }

    private void showEdgePopupMenu(int x, int y, Edge clickedEdge) {
        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem setDistanceMenuItem = new JMenuItem("Set Distance");
        setDistanceMenuItem.addActionListener(e -> {
            String newDistanceString = JOptionPane.showInputDialog("Enter new distance for the edge:");
            if (newDistanceString != null) {
                try {
                    int newDistance = Integer.parseInt(newDistanceString);
                    clickedEdge.setDistance(newDistance);
                    repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid distance input. Please enter a number.");
                }
            }
        });

        popupMenu.add(setDistanceMenuItem);

        JMenuItem renameMenuItem = new JMenuItem("Rename Edge");
        renameMenuItem.addActionListener(e -> {
            String newName = JOptionPane.showInputDialog("Enter new name for the Edge:");
            if (newName != null && !newName.isEmpty()) {
                clickedEdge.setName(newName);
                repaint();
            }
        });
        popupMenu.add(renameMenuItem);

        popupMenu.show(this, x, y);
    }

    private void deleteVertex(Vertex vertex) {
        int vertexIndex = vertices.indexOf(vertex);
        if (vertexIndex != -1) {
            vertices.remove(vertexIndex);

            edges.removeIf(edge -> edge.connects(vertex));
        }
    }

    private void handleVertexClick(Vertex clickedVertex) {
        if (selectedVertex != null && !selectedVertex.equals(clickedVertex)) {

            addEdgeBetweenVertices(selectedVertex, clickedVertex);
            selectedVertex.setSelected(false);
            selectedVertex = null;
        }
        clickedVertex.setSelected(true);
        selectedVertex = clickedVertex;
    }

    private void addEdgeBetweenVertices(Vertex startVertex, Vertex endVertex) {
        if (MainGui.getAnimationState() != AnimationState.RUNNING) {
            Edge newEdge = new Edge(startVertex, endVertex);
            newEdge.setName("E" + edgeCounter++);
            edges.add(newEdge);
            startVertex.addEdge(newEdge);
            endVertex.addEdge(newEdge);
        }

    }

    private void handleEmptySpaceClick(MouseEvent e) {
        if (selectedVertex != null) {

            selectedVertex.setSelected(false);
            selectedVertex = null;
        } else {
            addVertexIfNotOverlapping(e.getPoint());
        }
    }

    private void addVertexIfNotOverlapping(Point point) {
        if (!isOverlapping(point) && MainGui.getAnimationState() != AnimationState.RUNNING) {
            MainGui.setAnimationState(AnimationState.IDLE);
            Vertex newVertex = new Vertex(point.x, point.y);
            newVertex.setName("V" + vertexCounter++);
            vertices.add(newVertex);
        }
    }

    private boolean isOverlapping(Point point) {
        for (Vertex vertex : vertices) {
            if (vertex.contains(point)) {
                return true;
            }
        }
        return false;
    }

    private Vertex findVertex(Point point) {
        for (Vertex vertex : vertices) {
            if (vertex.contains(point)) {
                return vertex;
            }
        }
        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Edge edge : edges) {
            g.setColor(edge.getColor());
            edge.draw(g);
        }
        for (Vertex vertex : vertices) {
            g.setColor(vertex.getColor());
            vertex.draw(g);
        }
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void reset() {
        MainGui.textArea.setText("Click anywhere on this empty space to create a vertex.");
        MainGui.sideTextArea.setText("");

        vertices.clear();
        edges.clear();
        repaint();
    }

    public ArrayList<Vertex> getVerticesReference() {
        return vertices;
    }

}