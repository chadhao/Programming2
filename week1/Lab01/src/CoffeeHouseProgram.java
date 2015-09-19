import java.util.Scanner;

public class CoffeeHouseProgram {

	public static void main(String[] args) {
		System.out.println("-----------------------------------------------------");
		System.out.println("                     SMALL      MEDIUM     LARGE");
		System.out.println("-----------------------------------------------------");
		System.out.println("1. Long Black        $1.10      $1.38      $1.93");
		System.out.println("2. Short Black       $2.20      $2.75      $3.85");
		System.out.println("3. Cappuccino        $3.30      $4.13      $5.78");
		System.out.println("4. Latte             $4.40      $5.50      $7.70");
		System.out.println("-----------------------------------------------------");
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter a number 1 - 4");
		int menuItem = keyboard.nextInt();
		System.out.println("Please enter the size S, M or L");
		char size = keyboard.next().charAt(0);
		float smallCost = 1.1f * menuItem;
		float mediumCost = 1.25f * smallCost;
		float largeCost = 1.75f * smallCost;
		float cost;
		if (size == 's' || size == 'S')
		{
			cost = smallCost;
		}
		else if (size == 'm' || size == 'M')
		{
			cost = mediumCost;
		}
		else
		{
			cost = largeCost;
		}
		float payment = 0.0f;
		while (payment < cost)
		{
			System.out.println(String.format("The cost is: $%.2f", cost));
			System.out.println("Please input payment $:");
			payment = keyboard.nextFloat();
		}
		System.out.println(String.format("Your change is: $%.2f", payment - cost));
	}

}
