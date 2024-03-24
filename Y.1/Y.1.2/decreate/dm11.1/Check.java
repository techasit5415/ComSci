public class Check {
    Check() {}

    public boolean checkNumber(String str) {
        boolean pass = true;
        String[] a = str.split(" ");
        for(int i = 0; i < a.length; i++) {
            if(i % 2 == 0) {
                if(a[i].equals("+") || a[i].equals("-") || 
                a[i].equals("*") || a[i].equals("/")) {
                    pass = false;
                    break;
                }
            }
            else if(i % 2 != 0) {
                if(!a[i].equals("+") && !a[i].equals("-") && 
                !a[i].equals("*") && !a[i].equals("/")) {
                    pass = false;
                    break;
                }
            }
        }
        if(a.length < 3) {
            pass = false;
        }
        return pass;
    }

}
