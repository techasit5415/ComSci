import java.util.ArrayList;

public class FindWay {
    String[] vertex;
    String[] edge;
    String[][] graphs;
    String[] way;
    ArrayList<String> repeatedNumVertex = new ArrayList<>();
    ArrayList<String> repeatedNumEdge = new ArrayList<>();
    boolean repeatedVertex = false;
    boolean repeatedEdge = false;
    boolean sameStartEnd = false;
    boolean containEdge1 = false;
    CheckType t = new CheckType(sameStartEnd, repeatedVertex, repeatedEdge, containEdge1);
    Type type;

    FindWay(String[] v, String[] e, String[][] g, String[] w) {
        vertex = v;
        edge = e;
        graphs = g;
        way = w;
    }

    public boolean getRepeatedVertex() {
        return repeatedVertex;
    }
    public boolean getRepeatedEdge() {
        return repeatedEdge;
    }
    public boolean getSameStsrtEnd() {
        return sameStartEnd;
    }
    public boolean getCaontainEdge1() {
        return containEdge1;
    }

    public void checkWay() {
        repeatedNumEdge.add("-");
        repeatedNumVertex.add(way[0]);
        for(int a = 0; a <= way.length - 3; a += 2) {
            for(int b = 0; b < graphs.length; b++) {
                if(way[a + 1].equals(graphs[b][1]) && way[a + 2].equals(graphs[b][2])) {
                    checkRepeatedEdge(b);
                    checkRepeatedVetex(b);
                }
                else if(way[a + 1].equals(graphs[b][1]) && way[a + 2].equals(graphs[b][0])) {
                    checkRepeatedEdge(b);
                    checkRepeatedVetex(b);
                }
            }
        }
        checkStartEnd();
        checkContainEdge1();
    }
    public void checkRepeatedEdge(int idx) {
        for(int a = 0; a < repeatedNumEdge.size(); a++) {
            if(graphs[idx][1].equals(repeatedNumEdge.get(a))) {
                repeatedEdge = true;
                break;
            }
            else {
                repeatedNumEdge.add(graphs[idx][1]);
            }
        }
        System.out.println(repeatedNumEdge);
    }
    public void checkRepeatedVetex(int idx) {
        for(int a = 0; a < repeatedNumVertex.size(); a++) {
            if(graphs[idx][0].equals(repeatedNumVertex.get(a)) || graphs[idx][2].equals(repeatedNumVertex.get(a))) {
                repeatedVertex = true;
                break;
            }
            else {
                repeatedNumVertex.add(graphs[idx][0]);
                repeatedNumVertex.add(graphs[idx][2]);
            }
        }
        System.out.println(repeatedNumVertex);
    }
    public void checkStartEnd() {
        if(way[0].equals(way[way.length - 1])) {
            sameStartEnd = true;
        }
    }
    public void checkContainEdge1() {
        if(repeatedEdge == false && sameStartEnd == true) {
            containEdge1 = true;
        }
    }
    @Override
    public String toString() {
        return repeatedEdge + " " + repeatedVertex + " " + sameStartEnd + " " + containEdge1;
    }
}
