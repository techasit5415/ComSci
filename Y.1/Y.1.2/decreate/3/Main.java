import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number of rows: ");
        int numRows = scanner.nextInt();
        if (numRows<101){
            PascalTriangle triangle = new PascalTriangle(numRows);
            triangle.pTriangle();
        }
        else{
            System.out.println("more than 100");
        }
        scanner.close();

        
    }
}

class PascalTriangle {
    private int numRows;

    public PascalTriangle(int numRows) {
        this.numRows = numRows;
    }

    public void pTriangle() {
        for (int i = 0; i < numRows; i++) {
            pSpaces(numRows - i);
            int c = 1;
            for (int j = 0; j <= i; j++) {
                if (j != 0) {
                    c = c * (i - j + 1) / j;
                }
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    private void pSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }
}
