import java.util.Scanner;
public class aaa

{
public static void main (String[] args)
{
    Scanner scanner = new Scanner(System.in);

    int coin10,coin5,coin1=0;

		System.out.print("enter price:");
		int change = scanner.nextInt();
		
		
		coin10 = change / 10 ;
		coin1 = change % 10 ;
		coin5 = coin1 / 5 ;
		coin1 = coin1 % 5 ;
		System.out.printf("change\ncoin10 = %d \ncoin5 = %d \ncoin1 = %d" ,coin10,coin5,coin1);
		
		
        scanner.close();
}
}