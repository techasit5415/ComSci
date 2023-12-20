import java.util.ArrayList;
import java.util.Arrays;

public class maiyaktam {
    public static void main(String[] args) {
        int [][] matrix = {

                            {0, 1, 1, 1},
                            {1, 0, 1, 1},
                            {1, 1, 0, 1},
                            {1, 1, 1, 0} 
        };

        System.out.println(triangular_matrix(matrix));

    }
    static boolean triangular_matrix (int [][] matrix) {

        if (matrix.length != matrix[0].length) {
            throw new ArithmeticException("Matrix should be The Perfect Square");
        }

        boolean result = false;
        for (int [] index : matrix) {
            System.out.println(Arrays.toString(index));
        }

    
        // loop-add lower triangular matrix
        ArrayList<Integer> lower_list = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < row; col++) {
                lower_list.add(matrix[row][col]);
            }
        }
        System.out.println(lower_list);

        // lower-triangular or not?
        int check_lower = 0;
        for (int iter = 0; iter < lower_list.size(); iter++ ) {
            if (lower_list.get(iter) == 0) {
                check_lower++;
            }
        }
        if (check_lower == lower_list.size()) {
            result = true;
        }


        // loop-add upper triangular matrix
        ArrayList<Integer> upper_list = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = row + 1; col < matrix[0].length; col++) {
                upper_list.add(matrix[row][col]);
            }
        }
        System.out.println(upper_list);

        // upper-triangular or not?
        int check_upper = 0;
        for (int iter = 0; iter < lower_list.size(); iter++ ) {
            if (lower_list.get(iter) == 0) {
                check_upper++;
            }
        }
        if (check_upper == lower_list.size()) {
            result = true;
        }

        return result;
    }
}
