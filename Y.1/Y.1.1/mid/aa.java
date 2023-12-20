import java.util.*;
class aa{
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int x = sc.nextInt();
        sc.close();
        
        for(int row=1; row<x+1; row++){

            for(int space=0; space<x-row; space++ ){
                System.out.print(" ");
            }
            for(int col=0; col<(row*2)-1; col++){
                
                System.out.print("*");
            }
            System.out.println();
            
        }
        
    }
}
