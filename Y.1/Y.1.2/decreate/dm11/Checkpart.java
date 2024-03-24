public class Checkpart {
    public Checkpart(){}

    public boolean CheckOperator(String str){
        boolean ChkPass = true;
        String[] StrArr = str.split(" ");
        
        for(int i = 0;i<StrArr.length;i++){
            if(i % 2 == 0) {
                if(StrArr[i].equals("+") || StrArr[i].equals("-") || 
                StrArr[i].equals("*") || StrArr[i].equals("/")) {
                    ChkPass = false;
                    break;
                }
            }
            else if(i % 2 != 0) {
                if(!StrArr[i].equals("+") && !StrArr[i].equals("-") && 
                !StrArr[i].equals("*") && !StrArr[i].equals("/")) {
                    ChkPass = false;
                    break;
                }
            } 
        }

        if(StrArr.length < 3) {
            ChkPass = false;
        }

        return ChkPass;


    }
}
