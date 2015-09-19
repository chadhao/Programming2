import java.util.Scanner;

public class ThreeNumberSum {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter three numbers");
		int num1 = keyboard.nextInt();
		int num2 = keyboard.nextInt();
		int num3 = keyboard.nextInt();
		System.out.println("The sum is: " + (num1 + num2 + num3));
	}

}
