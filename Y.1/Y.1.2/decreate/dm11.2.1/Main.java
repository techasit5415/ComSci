import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean same = false;
        int row = 0;
        int col = 0;
        while(same == false) {
            System.out.print("Input Number Row Matrix : ");
            row = sc.nextInt();
            System.out.print("Input Number Column Matrix : ");
            col = sc.nextInt();
            if(row == col) {
                same = true;
            }
            else {
                System.out.println("Input again or get loose. You are Noob!!! LOL >:D");
            }
        }
        System.out.println("Input Matrix (You still are noob >;O) -> ");
        long [][] matrix = new long [row][col];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.print("Input Number Round (>:/) : ");
        int round = sc.nextInt();
        Calculation cm = new Calculation(matrix);
        cm.round(round);
        for(int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(cm.getMatrix()[i]));
        }
        sc.close();
    }
}

// 1 1
// 1 1