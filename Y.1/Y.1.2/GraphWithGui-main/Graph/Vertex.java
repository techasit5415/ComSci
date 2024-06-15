package Graph;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Vertex {
    private int x;
    private int y;
    private static final int DIAMETER = 20;
    private boolean selected;
    private ArrayList<Edge> edges;
    private String name;

    private int distance;
    private Vertex previous;

    private Color color = Color.BLACK;

    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
        this.selected = false;
        this.edges = new ArrayList<>();
        this.name = "";
        this.distance = 0;
    }

    public void draw(Graphics g) {
        g.setColor(selected ? Color.RED : color);
        g.fillOval(x - DIAMETER / 2, y - DIAMETER / 2, DIAMETER, DIAMETER);
        g.setColor(Color.BLACK);
        g.drawString(name, x - DIAMETER / 2 - 10, y - DIAMETER / 2 - 10);
    }

    public boolean contains(Point point) {
        double distance = Math.sqrt(Math.pow(point.getX() - x, 2) + Math.pow(point.getY() - y, 2));
        return distance <= DIAMETER * 0.8;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Vertex getAdjVertex() {
        if (previous != null) {
            return previous;
        } else {
            for (Edge edge : edges) {
                if (!edge.isVisited()) {
                    Vertex otherVertex = edge.getOtherVertex(this);
                    if (otherVertex != null) {
                        return otherVertex;
                    }
                }
            }
            return null;
        }
    }
    
    
    public Vertex getPrevious() {
        return previous;
    }

    public void setPrevious(Vertex previous) {
        this.previous = previous;
    }
    
    

}