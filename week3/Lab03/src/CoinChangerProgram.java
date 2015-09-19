import java.util.Scanner;

public class CoinChangerProgram
{

	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		int ten;
		int twenty;
		int fifty;
		int oneDollar;
		int twoDollar;
		
		System.out.println("Welcome to the Coin Changer Machine. Please input your coins:");
		System.out.print("Number of 10c coins: ");
		ten = keyboard.nextInt();
		System.out.print("Number of 20c coins: ");
		twenty = keyboard.nextInt();
		System.out.print("Number of 50c coins: ");
		fifty = keyboard.nextInt();
		System.out.print("Number of $1 coins: ");
		oneDollar = keyboard.nextInt();
		System.out.print("Number of $2 coins: ");
		twoDollar = keyboard.nextInt();
		
		CoinChanger myCoin = new CoinChanger(ten, twenty, fifty, oneDollar, twoDollar);
		
		System.out.println("");
		System.out.println("The total value of the coin collection is: $"+myCoin.findDollars()+"."+myCoin.findChange()+".");
		System.out.println("Please take your receipt!");
	}

}
