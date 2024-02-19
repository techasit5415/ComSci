import java.util.Scanner;

public class BinomialCoefficient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number (not exceeding 100): ");
        int n = scanner.nextInt();

        if (n <= 100) {
            printBinomialCoefficient(n);
        } else {
            System.out.println("Invalid input. Please enter a number not exceeding 100.");
        }
    }

    private static void printBinomialCoefficient(int n) {
        System.out.print("Binomial Coefficient for (a + b)^" + n + " is: ");
        
        for (int i = 0; i <= n; i++) {
            System.out.print("(" + n + " " + i + ")a^" + (n - i) + "b^" + i);

            if (i < n) {
                System.out.print(" + ");
            }
        }
    }
}