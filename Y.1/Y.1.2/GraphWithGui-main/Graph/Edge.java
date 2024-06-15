package Graph;
import java.awt.Color;
import java.awt.Graphics;

public class Edge {
    private Vertex startVertex;
    private Vertex endVertex;
    private int distance;

    private boolean visited;

    private String name;

    private Color color;

    public Edge(Vertex startVertex, Vertex endVertex) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.distance = (int) (Math.random() * 10) + 1;
        this.name = "";
        this.color = Color.BLACK;
        this.visited = false;
    }

    public Vertex getNeighbor(Vertex vertex) {
        if (vertex.equals(startVertex)) {
            return endVertex;
        } else if (vertex.equals(endVertex)) {
            return startVertex;
        } else {
            return null;
        }
    }

    public boolean connects(Vertex vertex) {
        return startVertex.equals(vertex) || endVertex.equals(vertex);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(startVertex.getX(), startVertex.getY(), endVertex.getX(), endVertex.getY());

        int midX = ((startVertex.getX() + endVertex.getX()) / 2) - 10;
        int midY = ((startVertex.getY() + endVertex.getY()) / 2) + 10;

        String label = getName() + "(" + getDistance() + ")";
        g.drawString(label, midX, midY);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public Vertex getEndVertex() {
        return endVertex;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex getOtherVertex(Vertex vertex) {
        if (vertex.equals(startVertex)) {
            return endVertex;
        } else if (vertex.equals(endVertex)) {
            return startVertex;
        } else {
            return null;
        }
    }

}
