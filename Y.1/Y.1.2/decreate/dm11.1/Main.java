import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean pass = false;
        String str = "";
        String[] arr;
        Check ch = new Check();
        Scanner sc = new Scanner(System.in);
        while(pass == false) {
            System.out.print("Input Infix : ");
            str = sc.nextLine();
            pass = ch.checkNumber(str);
            if(pass == false) {
                System.out.println("Wrong! Input again. Noob >:D ");
            }
        }
        arr = str.split(" ");
        Process p = new Process(arr);
        p.changeToPosfix();
        System.out.println(p);
        Stack s = new Stack(p.getArrPosfix());
        s.solutionStack();
        System.out.println(s);
        sc.close();
    }
}

// 3 * 4 + 6
// 5 + 2 - 4 * 2 / 10 + 100 - 100 / 15
// 7 + 7 + 8 * 4 / 2 + 5