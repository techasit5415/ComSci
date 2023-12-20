import java.util.Scanner;
public class ccaadd {
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.close();
        int layer = n;
        int numLines = 4;
        int numSpace;
        int numStars;

        for (int i = 0; i < layer; i++) {
            numSpace = 2*layer - i + 1;
            numStars = (2 * i) - 1;

            for (int j = 0; j < numLines; j++) {
                numStars += 2;

                for (int z = layer - 1; z < numSpace; z++) {
                    System.out.print("  ");
                }

                for (int k = 0; k < numStars; k++) {
                    System.out.print("* ");
                }

                numSpace--;
                System.out.println();
            }
        }
        for (int k = 0; k < layer - 1; k++) {
            for (int a = 0; a < 2*layer +2; a++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 3; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

