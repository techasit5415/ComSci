// import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        InputSizeMatrix();

    }

    private static void InputSizeMatrix() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Input DimensionX : ");
        int DimensionX = sc.nextInt();
        System.out.print("Input DimensionY : ");
        int DimensionY = sc.nextInt();
        int[][] DMatrix = new int[DimensionX][DimensionY];
        boolean check = CheckDimension(DimensionX, DimensionY);
        if (check == true) {
            DMatrix = InputMatrix(DimensionX, DimensionY);
        } else {
            System.out.println("Error");
        }
    sc.close();
    }

    private static boolean CheckDimension(int x, int y) {
        if (x != y) {
            return false;
        }
        return true;
    }

    private static int[][] InputMatrix(int DimensionX, int DimensionY) {
        Scanner sc = new Scanner(System.in);
        int Matrix[][] = new int[DimensionX][DimensionY];
        System.out.print("Insert Number :");
        for (int i = 0; i < DimensionX; i++) {
            for (int j = 0; j < DimensionY; j++) {
                Matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();
        return Matrix;
    }

}