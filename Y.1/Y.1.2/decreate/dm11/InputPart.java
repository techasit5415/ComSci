import java.util.Scanner;

public class InputPart {
    private String str = "";
    private boolean passornot=false;
    private String [] StrArr;
    Checkpart chk = new Checkpart();
    


    public InputPart() {
        Scanner sc = new Scanner(System.in);
        while (passornot ==false) {
            System.out.print("Input Infix : ");
            str = sc.nextLine();
            passornot = chk.CheckOperator(str);
            
            if(passornot == false) {
                System.out.println("Wrong! Input plz Input again. ");
            }
        }
        sc.close();
        StrArr = str.split(" ");
        ProCess PC = new ProCess(StrArr);
        PC.ToPosfix();
        System.out.println(PC);
        Stack S = new Stack(PC.getArrPF());
        S.solutStack();
        System.out.println(S);
        sc.close();
    }
}
