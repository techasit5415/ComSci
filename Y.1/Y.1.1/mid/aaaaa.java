import java.util.*;
public class aaaaa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int number= sc.nextInt();
        sc.close();
        for(int row=number; row>0; row--){
            for(int space=0; space<number-row; space++){
                System.out.print("1 ");
            }
            for(int col=0; col<(row*2)-1; col++){
        System.out.print("0 ");
            }
            System.out.println();
            
    }
    /*for(int row=1; row<number; row++){
            for(int space=0; space<number-row-1; space++){
                System.out.print("1 ");
            }
            for(int col=0; col<(row*2)+1; col++){
        System.out.print("0 ");
            }
            System.out.println();
        }*/

        
}
}
