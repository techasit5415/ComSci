import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();
    int[][] arr = new int[m][n];
    q1(arr, sc);
  }

  static void q1(int[][] data, Scanner sc) {
    int row = data.length;
    int col = data[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        int num = sc.nextInt() + 10;
        if (num > 255) {
          data[i][j] = 255;
        } else {
          data[i][j] = num;
        }
      }
      System.out.println(Arrays.toString(data[i]));
    }
  }
}
