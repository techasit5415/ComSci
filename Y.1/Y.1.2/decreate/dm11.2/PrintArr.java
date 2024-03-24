import java.util.Arrays;

public class PrintArr extends getsetArr {

    public PrintArr(getsetArr GST) {
        System.out.println("+---------Result---------+");
        for (int[] row : GST.getArr()) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("+------------------------+");
    }
    public static void PrintMetrix(int[][]matrix){
        System.out.println("+------------------------+");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("+------------------------+");
    }
}
