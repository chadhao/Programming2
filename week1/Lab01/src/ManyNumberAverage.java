import java.util.Scanner;

public class ManyNumberAverage {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int n = 0;
		System.out.println("How many numbers would you like to input? ");
		n = keyboard.nextInt();
		int[] num = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++)
		{
			System.out.println("Enter number: " + (i + 1));
			num[i] = keyboard.nextInt();
			sum += num[i];
		}
		double average = ((double) sum) / n;
		System.out.println("The average of the numbers input is " + average);
	}

}
