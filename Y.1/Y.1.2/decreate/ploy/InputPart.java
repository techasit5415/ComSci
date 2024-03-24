import java.util.Scanner;

public class InputPart {

    public InputPart() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input dimension : ");
        int DMS = sc.nextInt();
        System.out.print("Input powers of Matrix : ");
        int pwr = sc.nextInt();
        

        
        if(pwr <=30){
        System.out.println("Input elements of matrix : ");
        int[][] matrix = new int[DMS][DMS];


        for (int row = 0; row < DMS; row++) {
            for (int col = 0; col < DMS; col++) {
                matrix[row][col] = sc.nextInt();
            }
        }

        PrintArr.PrintMetrix(matrix);
        Matrix m = new Matrix(DMS, matrix);
        int[][] Ans = m.checkPwr(pwr);
        sc.close();

        getsetArr GST = new getsetArr();
        GST.setArr(Ans);
        new PrintArr(GST);
        }else{
            System.out.println("Power over 30 !!!");
        }
    }
}
