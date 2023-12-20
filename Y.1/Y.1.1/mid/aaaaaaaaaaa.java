import java.util.*;
public class aaaaaaaaaaa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i=0;
        int sum=0;
        while(i !=100){
            System.out.print("Enter a two-digit number: ");
             i = sc.nextInt();
             if(i>9 && i<100){
                sum+=i;
             }
             else if ( i!=100){
                System.out.println("Please enter only two-digit number!");
             }
             else{
                
             }
        }
        System.out.println("Total sum of two-digit numbers is "+sum);
    }
}
