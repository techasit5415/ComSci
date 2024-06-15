package Algorithm;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import Graph.Edge;
import Graph.Vertex;
import Gui.DrawingPanel;
import Gui.MainGui;

public class KruskalAlgorithm {

    private DrawingPanel drawingPanel;
    private int animationDelay;
    Set<Edge> globallyVisited = new HashSet<>();

    boolean edgeSelected;

    private Color visitedColor = Color.GREEN;
    private Color defaultColor = Color.BLACK;
    private Color pinkColor = Color.PINK;

    public KruskalAlgorithm(DrawingPanel drawingPanel, int animationDelay) {
        this.drawingPanel = drawingPanel;
        this.animationDelay = animationDelay;
    }

    public void findMSTWithAnimation() {
        MainGui.sideTextArea.setText("");
        MainGui.sideTextArea.append("Kruskal's Algorithm\n");
        MainGui.sideTextArea.append("Processing...\n");

        List<Edge> mstEdges = kruskalMST();

        highlightMSTEdges(mstEdges);

    }

    private List<Edge> kruskalMST() {
        ArrayList<Edge> allEdges = new ArrayList<>(drawingPanel.getEdges());
        List<Edge> mstEdges = new ArrayList<>();

        Collections.sort(allEdges, Comparator.comparingInt(Edge::getDistance));

        UnionFind unionFind = new UnionFind(drawingPanel.getVertices().size());

        for (Edge edge : allEdges) {
            int root1 = unionFind.find(drawingPanel.getVertices().indexOf(edge.getStartVertex()));
            int root2 = unionFind.find(drawingPanel.getVertices().indexOf(edge.getEndVertex()));

            if (root1 != root2) {
                mstEdges.add(edge);
                unionFind.union(root1, root2);
            }
        }

        return mstEdges;
    }

    private void highlightMSTEdges(List<Edge> mstEdges) {

        Map<Vertex, Boolean> visited = new HashMap<>();
        for (Vertex vertex : drawingPanel.getVertices()) {
            visited.put(vertex, false);
        }

        Timer timer = new Timer();
        final int[] counter = { 0 };

        edgeSelected = false;

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (counter[0] < mstEdges.size()) {
                    Edge edge = mstEdges.get(counter[0]);

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

                        MainGui.sideTextArea.append("Processing...\n\n");
                        MainGui.sideTextArea.append("Found distance 0 edges, highlighting in green.\n");

                    } else if (edge.getDistance() > 0) {
                        List<Edge> candidates = findEdgesWithSameDistance(mstEdges, counter[0]);

                        candidates.get(0).setVisited(false);

                        for (Edge candidate : candidates) {
                            candidate.setColor(pinkColor);
                        }

                        drawingPanel.repaint();

                        try {
                            Thread.sleep(animationDelay);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        MainGui.sideTextArea.append(
                                " Found " + candidates.size() + " edges (" + edge.getDistance() + ").\n");

                        Edge selectedEdge = candidates.get(0);

                        for (Edge candidate : candidates) {
                            if (candidate == selectedEdge && !globallyVisited.contains(candidate)) {
                                candidate.setColor(visitedColor);
                                globallyVisited.add(candidate);
                                edgeSelected = true;
                                break;
                            }
                        }

                        if (!visited.get(edge.getStartVertex())) {
                            visited.put(edge.getStartVertex(), true);
                            edge.getStartVertex().setColor(visitedColor);
                        }
                        if (!visited.get(edge.getEndVertex())) {
                            visited.put(edge.getEndVertex(), true);
                            edge.getEndVertex().setColor(visitedColor);
                        }

                        drawingPanel.repaint();
                        try {
                            Thread.sleep(animationDelay);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        MainGui.sideTextArea
                                .append("Selected " + selectedEdge.getName() + "(" + selectedEdge.getDistance() + ")\n");
                    }
                    counter[0]++;
                } else {
                    try {
                        Thread.sleep(animationDelay * 2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    timer.cancel();
                    if (edgeSelected) {
                        resetColors(drawingPanel, defaultColor);
                    }
                    MainGui.sideTextArea.append("\n");
                    printMST(mstEdges);
                    MainGui.sideTextArea.append("\nEnd of Process\n");
                    MainGui.textArea.setText("");
                    MainGui.textArea.append("Minimum Spanning Tree (MST) found.");
                    
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
        MainGui.sideTextArea.append("Minimum Spanning Tree:\n");
        for (Edge edge : mstEdges) {
            MainGui.sideTextArea.append(edge.getStartVertex().getName() + " -> " + edge.getName() + "(" + edge.getDistance()
                    + ") -> " + edge.getEndVertex().getName()+ "\n") ;
        }
    }

}
