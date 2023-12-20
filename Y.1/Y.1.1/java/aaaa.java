import java.util.Scanner;

public class aaaa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int num = 0;

        int numInputsfirst = sc.nextInt(); 

        for (int i = 0; i < numInputsfirst; i++) 
        {
             num = sc.nextInt(); 

             for(int j=0; j<num; j++){
          int intofnum = sc.nextInt(); 
          sum += intofnum;
        }
        System.out.println(sum);
        sum = 0;
        }
        

        
        sc.close();
    }
}
