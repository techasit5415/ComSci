public class Lab5Q4_2_660160{
    public static void main (String[] args)
    {
       // String s1 = "I am happy";
        String s2 = "xyz";

        String lower1 = s2.toLowerCase();
        int count = s2.length();

        int b = 0;


        for (int i=0; i<count; i++){
            char a = lower1.charAt(i);

            if (a == 'a'|| a == 'e'|| a == 'i'|| a == 'o'|| a == 'u' )
            {
            System.out.println("i "+i);
            break;
            }
            b++;
            
            }
            if (b == count)
            {
                System.out.println("-1");
                
            }
            }

                

}
