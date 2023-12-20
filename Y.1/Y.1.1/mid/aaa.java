import java.util.*;
public class aaa {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int number = sc.nextInt();
        sc.close();
        int sum = 0;
        while(number>=10){
            sum = 0;
            while(number>0){
                 
                int digi = number%10;
                sum+=digi;
                number/=10;
            }
            number=sum;
        }

        System.out.println(sum);
    }
}
