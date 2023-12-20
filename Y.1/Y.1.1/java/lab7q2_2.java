import java.util.Scanner;

public class lab7q2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tempStrings = sc.nextLine().split(" ");
        int result = check(tempStrings[0], tempStrings[1]);
        System.out.println(result);
        sc.close();
        
        
    }
    
    static int check(String input, String substring) {
        int subLength = substring.length();
        int inputLength = input.length();
        
        
        for (int i = 0; i <= inputLength - subLength; i++) {
            boolean matchFound = true;
            for (int j = 0; j < subLength; j++) {
                if (input.charAt(i + j) != substring.charAt(j)) {
                    matchFound = false;
                    break;
                }
                
            }
            if (matchFound == true) {
                return i;
            }
            
        }
        
        return -1;
    }
}
