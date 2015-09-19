import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Random rand = new Random();
		int n = rand.nextInt(100) + 1;
		int num;
		while (true)
		{
			System.out.println("Please guess the secret number between 1 - 100:");
			num = keyboard.nextInt();
			if (num > n)
			{
				System.out.println("Your guess was too high!");
			}
			else if (num < n)
			{
				System.out.println("Your guess was too low!");
			}
			else
			{
				break;
			}
		}
		System.out.println("That is correct!");
	}

}
