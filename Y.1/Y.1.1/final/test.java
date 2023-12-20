import java.util.Scanner;
public class test {
    public static void main(String[] args) {
        checkword();
        clock();
    }
    static void checkword(){
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        String[] parts = word.split("at|dot|AT|DOT");
        String[] parts1 = parts[0].split("@");
        String parts11=parts1[0]+"at";
        String changeword = parts11 + "@"+ parts[1] + "." + parts[2];
        System.out.println("Original string: " + word);
        System.out.println("Modified string: " + changeword);
        System.out.println(parts11);
        sc.close();

    }
    static void clock(){
        
    }
}
