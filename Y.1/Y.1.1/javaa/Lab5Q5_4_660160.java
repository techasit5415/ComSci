import java.util.Scanner;
public class Lab5Q5_4_660160 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = 4;
        int layer =sc.nextInt();
        int count = 1;
        int numspeace = 0;
        int numStars=1;
        
        sc.close();


                //leaves
{
        for (int i = 0; i < layer; i++) {   // layer 

        {
        for (int roll = 0; roll < n; roll++) { // roll
            
            for (int space = (layer+2)-numspeace ; space > 0; space--) {// speace in line
                System.out.print(" ");
                }
            
            for (int line = 0; line < count; line++) {
                
                System.out.print("*");
                }
            
            System.out.println();
            count += 2;
            numspeace++;

            }
            
            numStars++;
            count = (2*numStars)-1;
        }
        numspeace=(numStars-1);
    }
    
    }

                //leaves



                //trunk
    {
    for(int trunklayer=0; trunklayer<3; trunklayer++)
    {
        for (int trunk = (layer+1) ; trunk > 0; trunk--) {// speace in line
                System.out.print(" ");
        }
        
        for (int line = 0; line < 3; line++) {
                
                System.out.print("*");
                }
                System.out.println();
    }
}
                //trunk
        
}
    
}
