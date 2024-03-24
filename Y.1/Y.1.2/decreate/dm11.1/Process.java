public class Process extends Posfix {

    Process(String[] arr) {
        super(arr);
    }

    public void changeToPosfix() {
        String tmp;
        for(int i = 1; i < arrPosfix.length; i += 2) {
            if(arrPosfix[i].equals("*") || arrPosfix[i].equals("/")) {
                tmp = arrPosfix[i];
                arrPosfix[i] = arrPosfix[i + 1];
                arrPosfix[i + 1] = tmp;
            }
        }
        for(int j = 1; j < arrPosfix.length; j += 2) {
            if(arrPosfix[j].equals("+") || arrPosfix[j].equals("-")) {
                if(j != arrPosfix.length - 2) {
                    int n = checkPosition(j);
                    // System.out.println(j + " " + n);
                    swapPosition(j, n);
                }
                else {
                    tmp = arrPosfix[j];
                    arrPosfix[j] = arrPosfix[j + 1];
                    arrPosfix[j + 1] = tmp;
                }
            }
        }
    }

    public int checkPosition(int num) {
        int idx = 0;
        if(arrPosfix[num + 3].equals("*") || arrPosfix[num + 3].equals("/")) {
            idx = num + 3;
            for(int n = num + 5; n < arrPosfix.length; n += 2) {
                if(arrPosfix[n - 1].equals("+") || arrPosfix[n - 1].equals("-")) {
                    break;
                }
                idx += 2;
            }
        }
        else {
            idx = num + 1;
        }
        return idx;
    }

    public void swapPosition(int start, int finish) {
        String tmp = arrPosfix[start];
        for(int i = start ; i < finish; i++) {
            arrPosfix[i] = arrPosfix[i + 1];
        }
        arrPosfix[finish] = tmp;
    }

    @Override
    public String toString() {
        String str = "";
        for(int i = 0; i < arrPosfix.length; i++) {
            str += arrPosfix[i] + " ";
        }
        return "Output Posfix : " + str;
    }
}
