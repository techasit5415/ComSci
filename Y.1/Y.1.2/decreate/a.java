import java.util.Scanner;
public class a{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The dividend : ");
        int num = sc.nextInt();
        int printsc =num;
        System.out.print("Enter The divisor : ");
        int divi = sc.nextInt();
        sc.close();
        int i;
        for( i=0; num>divi; i++){
            
            num-=divi;
            
        }

        System.out.println(printsc+" = "+"("+divi+" * "+i+") + "+num);
        
    }
    
}