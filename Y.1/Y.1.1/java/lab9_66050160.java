import java.util.Arrays;
public class lab9_66050160 {
    public static void main(String[] args) {
scenario_1();
scenario_2();
scenario_3();
    }   





    static void scenario_1(){
         int [][]map1 = { { 0, 1, 9, 1, 0, 0, 2, 9, 4, 2, 1, 0, 0}, 
                             { 1, 3, 3, 3, 1, 1, 2, 9, 9, 9, 1, 0, 0}, 
                             { 2, 9, 9, 3, 9, 3, 2, 3, 4, 4, 2, 1, 0}, 
                             { 3, 9, 4, 4, 9, 9, 2, 2, 9, 5, 9, 2, 0}, 
                             { 2, 9, 2, 2, 9, 9, 2, 2, 9, 9, 9, 3, 0}, 
                             { 1, 1, 1, 1, 2, 2, 2, 3, 5, 6, 9, 2, 0}, 
                             { 0, 0, 0, 0, 0, 0, 2, 9, 9, 9, 2, 1, 0}, 
                             { 0, 0, 0, 0, 0, 0, 2, 9, 9, 3, 1, 0, 0} };

        int aa = let_s_count(map1);
        System.out.println("count = "+aa);
        }


        static int let_s_count(int [][] map) {
            int count=0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if (map[i][j] == 9){
                    count++;
                }
            }
        }
        return count;
        }
        
        
        


    static void scenario_2(){
            int[][] a = {{1,2,3},{4,5,6}};
            int[][] d = transpose(a);
            for(int [] row : d){
                System.out.println(Arrays.toString(row));}        
        }


        static int[][] transpose(int[][]b){
            int [][] c = new int [b.length+1][b.length];
            for(int i=0; i<b.length; i++){
                for(int j=0; j<b[i].length; j++){
                    c[j][i] =b[i][j];
                }
            }
            return c;
        }



        


        static void scenario_3(){
            int[]team_id = {22,11,33};
            int[]points1 = {88,77,99};
            by_points(team_id,points1);
        }

        
        static void by_points(int[] teams, int[] points) {
            int[][] s = new int[teams.length][2];
        
        
            for (int i = 0; i < points.length - 1; i++) {
                for (int j = 0; j < points.length - i - 1; j++) {
                    if (points[j] > points[j + 1]) {
                    
                        int tempTeam = teams[j];
                        teams[j] = teams[j + 1];
                        teams[j + 1] = tempTeam;
        
                        int tempPoints = points[j];
                        points[j] = points[j + 1];
                        points[j + 1] = tempPoints;
                    }
                }
            }
            for (int i = 0; i < teams.length; i++) {
                s[i][0] = teams[i];
                s[i][1] = points[i];
            }
        
    
            for (int[] row : s) {
                System.out.println(Arrays.toString(row));
            }
        }
            
        
}