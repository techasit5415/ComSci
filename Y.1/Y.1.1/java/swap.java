import java.util.Scanner;

public class swap {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String swapstr = "";
        for(int i = str.length() - 1; i >= 0; i--){
            swapstr += str.charAt(i);
        }
        System.out.println(swapstr);

        sc.close(); 
    }
}
