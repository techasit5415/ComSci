import java.util.*;
public class aaaaaaaaaaaaa {
    public static void main(String[] args) {
        
    
    Scanner sc = new Scanner(System.in);
    System.out.print("How many number: ");
    int num = sc.nextInt();
        int total=0;
    for(int i=0; i<num; i++){
        System.out.print("please enter "+(i+1)+" number here: ");
        int sum=sc.nextInt();
        if(sum>0)
        {
            total+=sum;
        }
        else{
            continue;
        }

    }
    System.out.println("The total is "+total);
    }

}
