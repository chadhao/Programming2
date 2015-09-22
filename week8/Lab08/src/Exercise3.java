import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise3
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
	
	public static void main(String[] args)
	{
		scanner = new Scanner(System.in);
		System.out.println("Welcome to the calculator.");
		try
		{
			product();
		}
		catch (InputMismatchException ime)
		{
			System.err.println(ime);
			scanner.next();
		}
	}
}
