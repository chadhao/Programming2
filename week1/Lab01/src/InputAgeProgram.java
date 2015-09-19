import java.util.Scanner;

public class InputAgeProgram {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How old are you?");
		int age = keyboard.nextInt();
		System.out.println("You are: " + age + " years old");
		if (age > 30)
		{
			System.out.println("You're old!");
		}
	}

}
