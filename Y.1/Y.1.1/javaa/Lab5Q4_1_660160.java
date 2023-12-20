
public class Lab5Q4_1_660160 {
    public static void main(String[] args) {
        String str = "WWWWMMMMWMWMWMWMMMWWWWWM";
        char ww = 'W';
        char mm = 'M';
        int w = 0;
        int m = 0;
        
        
        for (int i = 0; i < str.length(); i++) {
            char charactor = (str.charAt(i));
            
        if (charactor == ww ) 
        {
            w++;
        } 
        else if  (charactor == mm) 
        {
            m++;
        }
        else
        {

        }
    }
    System.out.println("m = "+m);
    System.out.println("w = "+w);
}
}
