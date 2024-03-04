import java.util.ArrayList;
import java.util.HashSet;

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
        HashSet<String> visitedEdges = new HashSet<>();
        
        for (int i = 1; i <= way.length-2; i += 2) {
            String currentEdge = way[i] + way[i+1];
            if (visitedEdges.contains(currentEdge)) {
                rpEdge = true;
                return;
            } else {
                visitedEdges.add(currentEdge);
            }
        }
        rpEdge = false;
    }
    
      
      
    

    public void checkRpVertex(int idx) {
        if (way.length >= 2) {
            
              if (!rpVertex) {
                //rpVertex = true; 
                if (way[0].equals(way[way.length - 1])&& rpEdge==false) {
                    // rpVertex = false; 
                    sameSEFL = true;


                    String firstNode = way[0];
                    boolean allNodesEqual = true;
                    for (int i = 1; i < way.length; i++) {
                                    // If any node is not equal to the first node, then it's not a repeated vertex
                                    if (!way[i].equals(firstNode)) {
                                        allNodesEqual = false;
                                        break; // Exit the loop since we found a non-repeated vertex
                                    }
                                }
                        
                                // If all nodes are equal to the first node, set rpVertex to false
                                if (allNodesEqual) {
                                    rpVertex = false;
        }}}}
    }


    // public void checkRpVertex(int idx) {
    //     if (way.length >= 2) {
    //         boolean allNodesEqual = true;
    //         String firstNode = way[0];
    
    //         // Loop through all nodes in the way (except the first one)
    //         for (int i = 1; i < way.length; i++) {
    //             // If any node is not equal to the first node, then it's not a repeated vertex
    //             if (!way[i].equals(firstNode)) {
    //                 allNodesEqual = false;
    //                 break; // Exit the loop since we found a non-repeated vertex
    //             }
    //         }
    
    //         // If all nodes are equal to the first node, set rpVertex to false
    //         if (allNodesEqual) {
    //             rpVertex = false; // Set rpVertex to false since all nodes are the same
    //             sameSE = true; // Set sameSE to true since the path is a cycle
    //         }
    //     }
    // }
    


    


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
