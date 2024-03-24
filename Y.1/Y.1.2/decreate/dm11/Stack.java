import java.util.ArrayList;

public class Stack extends PosFix implements PushPop {
    ArrayList<Integer> ans = new ArrayList<>();
    Stack(String[] arrPosfix) {
        super(arrPosfix);
    }

    public void solutStack() {
        System.out.println("+------------------------+");
        for(int i = 0; i < arrPF.length; i++) {
            if(arrPF[i].equals("+")) {
                int num1 = ans.get(ans.size() - 1);
                int num2 = ans.get(ans.size() - 2);
                int b = ans.get(ans.size() - 2) + ans.get(ans.size() - 1);
                getPopAndOperation(i, b, num1, num2);
            }
            else if(arrPF[i].equals("-")) {
                int num1 = ans.get(ans.size() - 1);
                int num2 = ans.get(ans.size() - 2);
                int b = ans.get(ans.size() - 2) - ans.get(ans.size() - 1);
                getPopAndOperation(i, b, num1, num2);
            }
            else if(arrPF[i].equals("*")) {
                int num1 = ans.get(ans.size() - 1);
                int num2 = ans.get(ans.size() - 2);
                int b = ans.get(ans.size() - 2) * ans.get(ans.size() - 1);
                getPopAndOperation(i, b, num1, num2);
            }
            else if(arrPF[i].equals("/")) {
                int num1 = ans.get(ans.size() - 1);
                int num2 = ans.get(ans.size() - 2);
                int b = ans.get(ans.size() - 2) / ans.get(ans.size() - 1);
                getPopAndOperation(i, b, num1, num2);
            }
            else {
                ans.add(Integer.parseInt(arrPF[i]));
                getPush(i);
            }
        }
    }

    public void getPopAndOperation(int a, int b, int num1, int num2) {
        System.out.println("Next (" + (a + 1) +")" + " --> " + arrPF[a]);
        System.out.println("Pop  :  " + ans.get(ans.size() - 1) + " , " + ans.get(ans.size() - 2));
        ans.remove(ans.size() - 1);
        ans.remove(ans.size() - 1);
        System.out.println("--> " + ans);
        System.out.println("Operation : " + num2 + " " + arrPF[a] + " " + num1 + " = " + b);
        System.out.println("Push : " + b);
        ans.add(b);
        System.out.println("--> " + ans);
        System.out.println("+------------------------+");
    }

    public void getPush(int a) {
        System.out.println("Next (" + (a + 1) +")" + " --> " + arrPF[a]);
        System.out.println("Push :  " + arrPF[a]);
        System.out.println("--> " + ans);
        System.out.println("+------------------------+");
    }

    @Override
    public String toString() {
        return "Output Stack : " + ans.get(0);
    }
}