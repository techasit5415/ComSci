import java.util.Scanner;

public class lab7q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(factorial(sc.nextInt()));
        sc.close();
    }
    
    static int factorial(int n){
        int ans = 1;
        for(int i = n ; i > 0; i--){
            ans *= i;
        }
        return ans;
    }
}
