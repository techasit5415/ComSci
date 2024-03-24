public class Matrix  {
    private int n;
    private int[][] constant;
    private int[][] matrix;

    Matrix(int n, int[][] matrix) {
        this.n = n;
        this.constant = matrix;
        this.matrix = matrix;
    }

    public int[][] checkPwr(int Pwr) {
        int[][] temp = matrix;
        int[][] arr = new int[n][n];
        if (Pwr == 0) {
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (row == col) {
                        arr[row][col] = 1;
                    } else {
                        arr[row][col] = 0;
                    }
                }
            }
            return arr;
        } else if (Pwr == 1) {
            arr = matrix;
            return arr;
        } else {
            for (int i = 1; i < Pwr; i++) {
                arr = getMultiplication(temp);
                temp = arr;
            }
            return arr;
        }

    }

    public int[][] getMultiplication(int[][] arr) {
        int[][] b = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int r = 0; r < n; r++) {
                    b[i][j] += constant[i][r] * arr[r][j];
                }
            }
        }
        return b;
    }
}