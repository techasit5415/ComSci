import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Way : ");
        String OriginalWay = sc.nextLine();
        sc.close();
        
        String [] way = OriginalWay.split(" ");
        
        String[] vertices = GraphData.getVertices();
        String[] edges = GraphData.getEdges();
        String[][] graphs = GraphData.getGraphs();
        
        FindWay fW = new FindWay(vertices, edges, graphs, way);
        fW.processWay();
        CheckType CT = new CheckType(fW.getRpVertex(), fW.getRpEdge(), fW.getSameSE(), fW.getCTEdge(),fW.getsameSEFL());
        CT.checkType();
        
        System.out.println(fW);
        System.out.println(CT);
        
    }
}