import java.util.*;
public class aaaaaaaa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        for(int i=0; i<n; i++){
            for(int j=0; j<i+1; j++){
                if(i!=j){
                    System.out.print("S");
                }
                else{
                    System.out.print("X");
                }
            }
            System.out.println("");
        }

        for(int i = n-1; i>0; i--){
            for(int j=1; j<i+1; j++){
                if(i!=j){
                    System.out.print("S");
                }
                else{
                    System.out.print("X");
                }
            }
            System.out.println("");
        }
    }
}
