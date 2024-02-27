import java.util.ArrayList;

class FindWay {
    String[] vertex;
    String[] edge;
    String[][] graphs;
    String[] way;
    ArrayList<String> repeatedNumVertex = new ArrayList<>();
    ArrayList<String> repeatedNumEdge = new ArrayList<>();
    boolean rpVertex = false;
    boolean rpEdge = false;
    boolean sameSE = false;
    boolean ctEdge = false;
    boolean sameSEFL = false;

    FindWay(String[] vt, String[] eg, String[][] gph, String[] wy) {
        vertex = vt;
        edge = eg;
        graphs = gph;
        way = wy;
    }

    public boolean getRpVertex() {
        return rpVertex;
    }

    public boolean getsameSEFL() {
        return sameSEFL;
    }

    public boolean getRpEdge() {
        return rpEdge;
    }

    public boolean getSameSE() {
        return sameSE;
    }

    public boolean getCTEdge() {
        return ctEdge;
    }

    public void processWay() {
        for (int a = 0; a <= way.length - 3; a += 2) {
            for (int b = 0; b < graphs.length; b++) {
                if (way[a + 1].equals(graphs[b][1])
                        && (way[a + 2].equals(graphs[b][2]) || way[a + 2].equals(graphs[b][0]))) {
                    checkRpEdge(b);
                    checkRpVertex(b);
                }
            }
        }
        checkSE();
        checkCTEdge();

    }

    public void checkRpEdge(int idx) {
        for (int i = 0; i < idx; i++) {
            if (graphs[idx][1].equals(graphs[i][1])) {
                rpEdge = true;
                return;
            }
        }
        rpEdge = false;
    }
    
    
    


    public void checkRpVertex(int idx) {
        if (way.length >= 2) {
            if (way[0].equals(way[way.length - 1])) {
                rpVertex = false; 
                sameSEFL = true;
            } else if (!rpVertex) {
                rpVertex = true; 
            }
        }
    }

    public void checkSE() {
        if (way[0].equals(way[way.length - 1])) {
            sameSE = true;
        }
    }

    public void checkCTEdge() {
        if (way.length > 1 && !rpEdge && sameSE) {
            ctEdge = true;
        }
    }

    @Override
    public String toString() {
        return "rpEdge : " + rpEdge + "|  |" + "rpVertex : " + rpVertex + "|  |" + "sameSE : " + sameSE + "|  |"
                + "ctEdge : " + ctEdge + "| | sSeLF : " + sameSEFL;
    }
}
