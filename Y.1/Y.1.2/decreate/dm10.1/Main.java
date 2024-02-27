import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String [] vertex = {"v1", "v2", "v3", "v4", "v5", "v6"};
        String [] edge = {"e1", "e2", "e3", "e4", "e5", "e6", "e7"};
        String [][] graghs = {{"v1","e1","v2"},
                              {"v1","e2","v2"},
                              {"v2","e3","v3"},
                              {"v3","e4","v3"},
                              {"v3","e5","v4"},
                              {"v3","e6","v5"},
                              {"v3","e7","v6"},
                              {"v2","e8","v6"},
                              {"v5","e9","v6"},
                              {"v4","e10","v5"}};
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Way : ");
        String w = sc.nextLine();
        String [] way = w.split(" ");
        FindWay fw = new FindWay(vertex, edge, graghs, way);
        fw.checkWay();
        CheckType ct = new CheckType(fw.getRepeatedVertex(), fw.getRepeatedEdge(), fw.getSameStsrtEnd(), fw.getCaontainEdge1());
        ct.checkType();
        System.out.println(fw);
        System.out.println(ct);
        sc.close();
    }
}
// v1 e1 v2 e2 v1 e1 v2