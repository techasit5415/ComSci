public class GraphData {
    public static String[] vertices;
    public static String[] edges;
    public static String[][] graphs;
    
    static String [] vertex = {"v1", "v2", "v3", "v4", "v5", "v6"};
    static String [] edge = {"e1", "e2", "e3", "e4", "e5", "e6", "e7"};
    static String [][] graphsData = {{"v1","e1","v2"},
                          {"v1","e2","v2"},
                          {"v2","e3","v3"},
                          {"v3","e4","v3"},
                          {"v3","e5","v4"},
                          {"v3","e6","v5"},
                          {"v3","e7","v6"},
                          {"v2","e8","v6"},
                          {"v5","e9","v6"},
                          {"v4","e10","v5"}};
                          
    public static  String[] getVertices() {
        return vertex;
    }
    public static String[] getEdges() {
        return edge;
    }
    public static String[][] getGraphs() {
        return graphsData;
    }
}
