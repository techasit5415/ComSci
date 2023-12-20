import java.util.Scanner;

  public class lab6q3 {
      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          String input = sc.nextLine();
          sc.close();
          String[] inputArray = input.split("");
          String[] resultArray = new String[inputArray.length * 2];
          int resultIndex = 0;

          for (int i = 0; i < inputArray.length ; i++) {
              if (inputArray[i].equals("M") && inputArray[i + 1].equals("I")) {
                  resultArray[resultIndex++] = "CSP";
                  i++;
              } else {
                  resultArray[resultIndex++] = inputArray[i];
              }
          }
          
          for (int j = 0; j < resultIndex; j++) {
              System.out.print(resultArray[j]);
          }
      }
  }