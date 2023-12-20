import java.util.Scanner;
public class calculatormoney

{
public static void main (String[] args)
{
    Scanner scanner = new Scanner(System.in);

    int change,remain,coin10,coin5=0;

		System.out.print("enter price:");
		int price = scanner.nextInt();
		System.out.print("enter money input");
		int money = scanner.nextInt();
		/*printf("%d %d" ,price ,money); test*/
		if( price < money)
		{
		change = money - price;
		coin10 = change / 10 ;
		remain = change % 10 ;
		coin5 = remain / 5 ;
		remain = remain % 5 ;
		System.out.printf("change\ncoin10 = %d \ncoin5 = %d \ncoin1 = %d" ,coin10,coin5,remain);
		}
		else
		System.out.print("not enough");
        scanner.close();
}
}