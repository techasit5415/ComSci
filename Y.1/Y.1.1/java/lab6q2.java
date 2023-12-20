import java.util.Scanner;
public class lab6q2 {
    public static void main(String[] aStrings)
    {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        String [] token = input.split(" ");
        int numgroup = 0;
        for (int i=0; i<token.length-1; i++)
        {
            if(token[i].charAt(1) == token[i+1].charAt(1))
            {
                numgroup++;
            }
        }
        System.out.println(numgroup);
    }
}