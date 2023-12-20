import java.util.Scanner;

public class lab7q2_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tempStrings = sc.nextLine().split(" ");
        int result = check(tempStrings[0], tempStrings[1]);
        int result1 = check1(tempStrings[0], tempStrings[2]);
        boolean realcheckResult = containsAndBefore(result, result1);
        System.out.println(realcheckResult);
        sc.close();
    }
    
    static int check(String input, String substring) {
        int subLength = substring.length();
        int inputLength = input.length();
        int i = 0;

        for (i = 0; i <= inputLength - subLength; i++) {
            boolean matchFound = true;
            for (int j = 0; j < subLength; j++) {
                if (input.charAt(i + j) != substring.charAt(j)) {
                    matchFound = false;
                    break;
                }
            }
            if (matchFound) {
                break; 
            }
        }
        
        return i; 
    }

    static int check1(String input, String substring) {
        int subLength = substring.length();
        int inputLength = input.length();
        int k = 0;

        for (k = 0; k <= inputLength - subLength; k++) {
            boolean matchFound = true;
            for (int j = 0; j < subLength; j++) {
                if (input.charAt(k + j) != substring.charAt(j)) {
                    matchFound = false;
                    break;
                }
            }
            if (matchFound) {
                break; 
            }
        }
        
        return k; 
    }

    static boolean containsAndBefore(int i, int k) {
        return i < k;
    }
}
