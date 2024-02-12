import java.util.Scanner;
public class DM09{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        Binomial x = new Binomial(n);
        x.getBinomial();
    }
}