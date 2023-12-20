import java.util.*;

public class aaaaaaaaaaaa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int num = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        System.out.print("Enter the character: ");
        String a = sc.nextLine();

        for (int i=1; i<num; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(a);
            }
            System.out.println();
        }
    }
}
