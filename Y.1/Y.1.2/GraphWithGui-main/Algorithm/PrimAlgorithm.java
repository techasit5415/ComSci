package Algorithm;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import Graph.Edge;
import Graph.Vertex;
import Gui.DrawingPanel;
import Gui.MainGui;

public class PrimAlgorithm {

    private DrawingPanel drawingPanel;
    private int animationDelay;
    private Vertex startVertex;
    private Set<Vertex> visited;

    private boolean edgeSelected = false;
    Set<Edge> globallyVisited = new HashSet<>();

    private Color visitedColor = Color.GREEN;
    private Color defaultColor = Color.BLACK;
    private Color pinkColor = Color.PINK;

    public PrimAlgorithm(DrawingPanel drawingPanel, int animationDelay, Vertex startVertex) {
        this.drawingPanel = drawingPanel;
        this.animationDelay = animationDelay;
        this.startVertex = startVertex;
        this.visited = new HashSet<>();
    }

    public void findMSTWithAnimation() {
        MainGui.sideTextArea.setText("");
        MainGui.sideTextArea.append("Prim's Algorithm\n");
        MainGui.sideTextArea.append("Processing...\n\n");

        List<Edge> mstEdges = primsMST();

        highlightMSTEdges(mstEdges);
    }

    private List<Edge> primsMST() {
        List<Edge> mstEdges = new ArrayList<>();
        visited.add(startVertex);

        PriorityQueue<Edge> potentialEdges = new PriorityQueue<>(Comparator.comparingInt(Edge::getDistance));
        potentialEdges.addAll(startVertex.getEdges());

        while (!potentialEdges.isEmpty()) {
            Edge currentEdge = potentialEdges.poll();

            Vertex nextVertex = currentEdge.getStartVertex().equals(visited.iterator().next())
                    ? currentEdge.getEndVertex()
                    : currentEdge.getStartVertex();

            if (!visited.contains(nextVertex)) {
                mstEdges.add(currentEdge);
                visited.add(nextVertex);
                potentialEdges.addAll(nextVertex.getEdges());
            }
        }

        return mstEdges;
    }

    private void highlightMSTEdges(List<Edge> mstEdges) {

        Map<Vertex, Boolean> visitedMap = new HashMap<>();
        for (Vertex vertex : drawingPanel.getVertices()) {
            visitedMap.put(vertex, false);
        }

        mstEdges.get(0).getStartVertex().setColor(pinkColor);
        Edge firstEdge = mstEdges.get(0);
        for (Edge edge : firstEdge.getStartVertex().getEdges()) {
            edge.setColor(pinkColor);
        }

        drawingPanel.repaint();

        // Timer setup
        Timer timer = new Timer();
        final int[] counter = { 0 };
        edgeSelected = false;

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (counter[0] < mstEdges.size()) {
                    Edge edge = mstEdges.get(counter[0]);

                    // Instant green for distance 0
                    if (counter[0] == 0 && edge.getDistance() == 0) {
                        for (Edge e : mstEdges) {
                            if (e.getDistance() == 0) {
                                e.setColor(visitedColor);
                            }
                        }
                        drawingPanel.repaint();
                        try {
                            Thread.sleep(animationDelay * 2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        MainGui.sideTextArea.append("Processing...\n");
                        MainGui.sideTextArea.append("Found distance 0 edges.\n");

                    } else if (edge.getDistance() > 0) {
                        // Highlight ALL edges from visited vertices:
                        for (Vertex vertex : drawingPanel.getVertices()) {
                            if (visitedMap.get(vertex)) {
                                for (Edge candidate : vertex.getEdges()) {
                                    if (!globallyVisited.contains(candidate)) {
                                        candidate.setColor(pinkColor);
                                    }
                                }
                            }
                        }

                        drawingPanel.repaint();
                        try {
                            Thread.sleep(animationDelay);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        List<Edge> candidates = findEdgesWithSameDistance(mstEdges, counter[0]);

                        candidates.get(0).setVisited(false);

                        Edge selectedEdge = candidates.get(0);

                        for (Edge candidate : candidates) {
                            if (candidate == selectedEdge && !globallyVisited.contains(candidate)) {
                                candidate.setColor(visitedColor);
                                globallyVisited.add(candidate);
                                edgeSelected = true;
                                break;
                            }
                        }

                        if (!visitedMap.get(edge.getStartVertex())) {
                            visitedMap.put(edge.getStartVertex(), true);
                            edge.getStartVertex().setColor(visitedColor);
                        }
                        if (!visitedMap.get(edge.getEndVertex())) {
                            visitedMap.put(edge.getEndVertex(), true);
                            edge.getEndVertex().setColor(visitedColor);
                        }

                        drawingPanel.repaint();

                        try {
                            Thread.sleep(animationDelay);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        MainGui.sideTextArea
                                .append("Selected " + edge.getName() + "(" + selectedEdge.getDistance() + ").\n");
                    }

                    counter[0]++;
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

                    if (edgeSelected) {
                        resetColors(drawingPanel, defaultColor);
                    }
                    MainGui.sideTextArea.append("End of Process\n");
                    MainGui.textArea.setText("");
                    MainGui.textArea.append("Minimum Spanning Tree (MST) found.");
                    printMST(mstEdges);
                    MainGui.setToStandard();
                }
            }
        };

        timer.schedule(task, 0, animationDelay);
    }

    private List<Edge> findEdgesWithSameDistance(List<Edge> mstEdges, int index) {
        List<Edge> candidates = new ArrayList<>();
        int targetDistance = mstEdges.get(index).getDistance();

        for (int i = index; i < mstEdges.size() && mstEdges.get(i).getDistance() == targetDistance; i++) {
            if (!mstEdges.get(i).isVisited()) {
                candidates.add(mstEdges.get(i));
            }
        }
        return candidates;
    }

    private void resetColors(DrawingPanel drawingPanel, Color defaultColor) {
        for (Vertex vertex : drawingPanel.getVertices()) {
            vertex.setColor(defaultColor);
        }
        for (Edge edge : drawingPanel.getEdges()) {
            edge.setColor(defaultColor);
            edge.setVisited(false);
        }
        drawingPanel.repaint();
    }

    private void printMST(List<Edge> mstEdges) {
        System.out.println("Minimum Spanning Tree (MST):");
        for (Edge edge : mstEdges) {
            System.out.println(edge.getStartVertex().getName() + " -> " + edge.getName() + " (" + edge.getDistance()
                    + ") -> " + edge.getEndVertex().getName());
        }
    }

}
