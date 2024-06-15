package Algorithm;
import java.awt.Color;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import Graph.Edge;
import Graph.Vertex;
import Gui.DrawingPanel;
import Gui.MainGui;

public class DijkstraAlgorithm {
    private DrawingPanel drawingPanel;
    private int animationDelay;
    private Vertex startVertex;
    private Set<Edge> globallyVisited;

    private Color visitedColor = Color.GREEN;
    private Color defaultColor = Color.BLACK;
    private Color pinkColor = Color.PINK;

    private Set<Edge> mstEdges;


    public DijkstraAlgorithm(DrawingPanel drawingPanel, int animationDelay, Vertex startVertex) {
        this.drawingPanel = drawingPanel;
        this.animationDelay = animationDelay;
        this.startVertex = startVertex;
        this.globallyVisited = new HashSet<>();
        this.mstEdges = new HashSet<>();
    }

    public void findShortestPathsWithAnimation() {
        MainGui.sideTextArea.setText("");
        MainGui.sideTextArea.append("Dijkstra's Algorithm\n");
        MainGui.sideTextArea.append("Processing...\n\n");

        initializeDistances();
        highlightShortestPathEdges();
    }

    private void initializeDistances() {
        for (Vertex vertex : drawingPanel.getVertices()) {
            vertex.setDistance(Integer.MAX_VALUE);
            vertex.setPrevious(null);
        }
        startVertex.setDistance(0);
    }

    private void highlightShortestPathEdges() {
        Map<Vertex, Boolean> visitedMap = new HashMap<>();
        for (Vertex vertex : drawingPanel.getVertices()) {
            visitedMap.put(vertex, false);
        }

        startVertex.setColor(visitedColor);
        drawingPanel.repaint();

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Vertex nextVertex = findNextVertex(visitedMap);

                if (nextVertex != null) {
                    visitedMap.put(nextVertex, true);

                    Edge selectedEdge = null;
                    Vertex previous = nextVertex.getPrevious();
                    if (previous != null) {
                        for (Edge edge : nextVertex.getEdges()) {
                            if (edge.getOtherVertex(previous) == nextVertex) {
                                selectedEdge = edge;
                                break;
                            }
                        }
                    }

                    if (selectedEdge != null) {
                        selectedEdge.setColor(visitedColor);
                        selectedEdge.getStartVertex().setColor(visitedColor);
                        selectedEdge.getEndVertex().setColor(visitedColor);
                        globallyVisited.add(selectedEdge);

                        MainGui.sideTextArea.append("Selected " + selectedEdge.getName() + "(" +
                                Math.max((Integer) selectedEdge.getStartVertex().getDistance(),
                                        (Integer) selectedEdge.getEndVertex().getDistance())
                                +
                                ")\n");
                    }

                    drawingPanel.repaint();
                    try {
                        Thread.sleep(animationDelay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    for (Edge edge : drawingPanel.getEdges()) {
                        if (edge.getColor().equals(pinkColor)) {
                            edge.setColor(defaultColor);
                        }
                    }
                      drawingPanel.repaint(); 
                      
                      try {
                        Thread.sleep(animationDelay * 2);
                      } catch (InterruptedException e) {
                        e.printStackTrace();
                      }

                    timer.cancel();
                    printShortestPath();
                    resetColors();
                    
                    MainGui.setToStandard();

                    MainGui.sideTextArea.append("End of Process\n");
                    MainGui.textArea.setText("");
                    MainGui.textArea.append("Minimum Spanning Tree (MST) found.");
                }
            }
        };
        timer.schedule(task, 0, animationDelay);
    }

    private Vertex findNextVertex(Map<Vertex, Boolean> visitedMap) {
        PriorityQueue<Vertex> unvisited = new PriorityQueue<>(Comparator.comparingInt(Vertex::getDistance));

        unvisited.addAll(drawingPanel.getVertices());

        while (!unvisited.isEmpty()) {
            Vertex currentVertex = unvisited.poll();

            Boolean visited = visitedMap.get(currentVertex);
            if (visited != null ? visited : false) {
                continue;
            }

            for (Edge edge : currentVertex.getEdges()) {
                Vertex neighbor = edge.getOtherVertex(currentVertex);
                
                if (neighbor != null && !visitedMap.get(neighbor)) {
                    int newDistance = currentVertex.getDistance() + edge.getDistance();
                    if (newDistance < neighbor.getDistance()) {
                        neighbor.setDistance(newDistance);
                        neighbor.setPrevious(currentVertex);

                        if (!mstEdges.contains(edge)) {
                            mstEdges.add(edge);
                        }
                        
                        edge.setColor(pinkColor);
                        MainGui.sideTextArea.append(" " + edge.getName() + " in Priority Queue \n");
                        drawingPanel.repaint();
                        try {
                            Thread.sleep(animationDelay);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            visitedMap.put(currentVertex, true); 
            MainGui.sideTextArea.append(currentVertex.getName() + " visited \n");
            return currentVertex;
        }
        return null;
    }

    public void resetColors() {
        for (Vertex vertex : drawingPanel.getVertices()) {
            vertex.setColor(defaultColor);
            vertex.setPrevious(null); 
            vertex.setDistance(Integer.MAX_VALUE);
        }

        startVertex.setDistance(0);

        for (Edge edge : drawingPanel.getEdges()) {
            edge.setColor(defaultColor);
            edge.setVisited(false);
        }

        globallyVisited.clear();
        drawingPanel.repaint();
    }

    private void printShortestPath() {
        StringBuilder sb = new StringBuilder();
        String[] paths = new String[mstEdges.size() + 1];
        
        Vertex previousVertex = startVertex;
        int totalDistance = 0;
        int i = 0;
        for (Edge edge : mstEdges) {
            paths[i++] = previousVertex.getName() + " -> " + edge.getName();
            previousVertex = edge.getEndVertex();
            totalDistance += edge.getDistance();
        }
        paths[i] = previousVertex.getName();
        
        for (i = 0; i < paths.length - 1; i++) {
            sb.append(paths[i]).append(" -> ");
        }
        sb.append(paths[i]).append("\n");
        
        MainGui.sideTextArea.append("\n Total distance: " + totalDistance  + "\n");
        System.out.println(sb.toString());
    }
    
    
    
    
    
    
    
    
    
    
    
}
