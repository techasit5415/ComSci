import java.util.*;


public class i_hua_kuy_gutammaipen {
    public static void main(String[] args) {
        demo1();
    }

    public static void demo1() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        // sc.close();
        int[][] c = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                c[i][j] = sc.nextInt();
            }
        }
        
        // int i = 0; i < a - 1; i++
        int d = sc.nextInt();
        


        for (int i = 0; i < a - 1; i++) {
            for (int j = 0; j < a - 1 - i; j++) {
                if (c[j][d] > c[j + 1][d]) {
                    // Swap rows
                    
                        int temp[] = c[j+1];
                        c[j+1] = c[j];
                        c[j] = temp;
                    
                }
            }
        }
        
        
        for (int i[] : c){
            System.out.println(Arrays.toString(i));
            sc.close();
        }
    }
}