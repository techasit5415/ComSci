public class Lab5Q5_1_660160{
public static void main(String[] args) {
        int n = 10;

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {

                if ((j == i) || (j == ((n-i)+1))) {
                    System.out.print(" ");
                } else {
                    System.out.print("x");
                }
                
            }
            System.out.println();
        }
    }
}