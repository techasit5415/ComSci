 import java.util.Scanner;
public class Lab4Q2_660160 {
    public static void main (String[] args)
    {
        int sum=0;
        Scanner scanner = new Scanner(System.in);
        System.out.print(" frist price: ");
        int first = scanner.nextInt();

        System.out.print("second price: ");
        int second = scanner.nextInt();

        System.out.print("third price: ");
        int third = scanner.nextInt();

        if( (first > second) && (second > third))
        sum = first + second;
        if ((first < second) && (second < third))
        sum = second + third;
        if ((first < second) && (second > third))
        sum = second + first;
         if ((first < second) && (second > third))
         sum = second + third;
        if ((first > second) && (second < third))
        sum = first + third;
        if((first < second) && (second > third))
        sum = first + second;
        System.out.println("price: " + sum);
        scanner.close();
    }
    
}
