import  java.util.Scanner;
public class Lab5Q5_3_660160 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1;
        sc.close();

        for (int roll = 0; roll < n; roll++) {
            for (int space = n - roll - 1; space > 0; space--) {
                System.out.print(" ");
            }
            
            for (int line = 0; line < count; line++) {
                System.out.print("P");
            }
            
            System.out.println();
            count += 2;
        }
    }
}
