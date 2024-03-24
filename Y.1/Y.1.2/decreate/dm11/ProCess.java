public class ProCess extends PosFix {
    ProCess(String[] arr) {
        super(arr);
    }
    public void ToPosfix(){
    String Temp;
    for(int i = 1; i < arrPF.length; i += 2) {
        if(arrPF[i].equals("*") || arrPF[i].equals("/")) {
            Temp = arrPF[i];
            arrPF[i] = arrPF[i + 1];
            arrPF[i + 1] = Temp;
        }
    }
    for(int j = 1; j < arrPF.length; j += 2) {
        if(arrPF[j].equals("+") || arrPF[j].equals("-")) {
            if(j != arrPF.length - 2) {
                int n = checkPosition(j);
                // System.out.println(j + " " + n);
                swapPosition(j, n);
            }
            else {
                Temp = arrPF[j];
                arrPF[j] = arrPF[j + 1];
                arrPF[j + 1] = Temp;
            }
        }
    }
}
public int checkPosition(int num) {
    int idx = 0;
    if(arrPF[num + 3].equals("*") || arrPF[num + 3].equals("/")) {
        idx = num + 3;
        for(int n = num + 5; n < arrPF.length; n += 2) {
            if(arrPF[n - 1].equals("+") || arrPF[n - 1].equals("-")) {
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
    String tmp = arrPF[start];
    for(int i = start ; i < finish; i++) {
        arrPF[i] = arrPF[i + 1];
    }
    arrPF[finish] = tmp;
}

@Override
public String toString() {
    String str = "";
    for(int i = 0; i < arrPF.length; i++) {
        str += arrPF[i] + " ";
    }
    return "Output Posfix : " + str;
}
}
