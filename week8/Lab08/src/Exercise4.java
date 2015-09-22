import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise4
{
	private static Scanner scanner;
	
	public static void product()
	{
		System.out.println("Enter number 1:");
		int value1 = scanner.nextInt();
		System.out.println("Enter number 2:");
		int value2 = scanner.nextInt();
		System.out.println("Product is: " + (value1*value2));
	}
	
	public static void main(String args[])
	{
		scanner = new Scanner(System.in);
		System.out.println("Welcome to the calculator.");
		
		while (true)
		{
			int menu = 0;
			System.out.println("1. Compute product");
			System.out.println("2. Quit");
			
			try
			{
				menu = scanner.nextInt();
			}
			catch (InputMismatchException ime)
			{
				System.out.println("Invalid menu input. Please try again.");
				scanner.next();
				continue;
			}
			
			if (menu == 1)
			{
				try
				{
					product();
				}
				catch (InputMismatchException ime)
				{
					System.out.println("Error reading integer value!");
					scanner.next();
					continue;
				}
			}
			else if (menu == 2)
			{
				System.out.println("Goodbye!");
				break;
			}
			else
			{
				System.out.println("Invalid menu input. Please try again.");
				continue;
			}
		}
	}
}
