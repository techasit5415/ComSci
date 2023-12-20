import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("********************************************************");
        System.out.println("*                 multiply = '*'                       *");
        System.out.println("*                 divide = '/'                         *");
        System.out.println("*                 plus = '+'                           *");
        System.out.println("*                 minus = '-'                          *");
        System.out.println("*                 Exponent = '^'                       *");
        System.out.println("********************************************************");

        boolean exit = false;

        while (!exit) {
            System.out.print("* number A: ");
            int numberA = scanner.nextInt();
            scanner.nextLine();

            System.out.print("* operator: ");
            String operator = scanner.nextLine();

            if (operator.equals("exit")) {
                exit = true;
                continue;
            }

            System.out.print("* number B: ");
            int numberB = scanner.nextInt();
            scanner.nextLine();

            double result = 0;

            if (operator.equals("*")) {
                result = numberA * numberB;
            } else if (operator.equals("/")) {
                result = numberA / numberB;
            } else if (operator.equals("+")) {
                result = numberA + numberB;
            } else if (operator.equals("-")) {
                result = numberA - numberB;
            } else if (operator.equals("^")) {
                result = Math.pow(numberA, numberB);
            }

            System.out.println("* Result: " + result );
            System.out.println("********************************************************");
        }

        scanner.close();
        System.out.println("Exiting the calculator. Goodbye!");
        
    }
}
