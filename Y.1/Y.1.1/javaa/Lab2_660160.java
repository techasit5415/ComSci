import java.util.Scanner;
public class Lab2_660160 

{
public static void main(String[] args) 
    {
    try (Scanner scanner = new Scanner(System.in)) {
        System.out.print("number A: ");
        int numbera = scanner.nextInt();
        int i ;
   long a=1 ;
        for (i=1; i<=numbera; i++)
        {
            a = a*i;
         
        }
        System.out.println(a);
        scanner.close();
    }    
}
    
}