import java.util.Scanner;

public class aa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int first = sc.nextInt();

        System.out.print("Enter second number: ");
        int second = sc.nextInt();

        sc.close();

        int gcd = calculator(first, second);
        System.out.println("GCD(" + first + "," + second + ") = " + gcd);
    }

    public static int calculator(int a, int b) {
        while (b != 0) {
            System.out.println("gcd(" + a + "," + b + ")");
            int temp = b;
            b = a % b;
            a = temp;
        }
        System.out.println("gcd(" + a + "," + b + ")");
        return a;
    }
}
