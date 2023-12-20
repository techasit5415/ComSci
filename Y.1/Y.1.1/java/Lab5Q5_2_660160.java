public class Lab5Q5_2_660160{
    public static void main (String[] args){
        int n=4;
        int count=1;
        for (int roll = 0; roll < n; roll++)
        {
            for (int line = 0; line < count ; line++)
            {
            System.out.print((n-line)+" " );
            
            }
            System.out.println();
            count++;
        }
        
    }
}