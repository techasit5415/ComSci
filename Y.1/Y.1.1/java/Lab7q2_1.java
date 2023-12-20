import java.util.Scanner;

public class Lab7q2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tempStrings = sc.nextLine().split(" ");
        boolean result = check(tempStrings[0], tempStrings[1]);
        System.out.println(result);
        sc.close();
        
    }
    
    static boolean check(String input, String substring) {
        int subLength = substring.length();
        int inputLength = input.length();
        int c = 0;
        int d = 0;
        
        for (int a = 0; a < subLength; a++) {
            for (int b = 0; b < inputLength; b++) {
                if (substring.charAt(a) == input.charAt(b)) {
                        d++;
                    if (d==1) {
                        c++;
                        b=0;
                        d=0;
                        break;
                        
                    } 
                    
                    
                }
                d=0;
                
            }

        }        
        
        if (c != subLength){
            return false;
        }
        else{
            return true;
        }
        
    }
}
