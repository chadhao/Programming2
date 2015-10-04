import java.util.*;

public class ArrayListTest
{
	private static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		System.out.println("\n<main method starts>\n");
		ArrayList<Integer> myArray = new ArrayList<Integer>();
		inputInteger(myArray);
		
		System.out.println("Number of integers: " + myArray.size());
		
		System.out.println(myArray);
		
		System.out.println(myArray.size()<3?"The 3rd number does not exist!":("The 3rd number is " + myArray.get(2)));
		
		myArray.add(10);
		System.out.println("After adding 10 to the end of the list: " + myArray);
		
		if (myArray.size()>3)
		{
			myArray.subList(3, myArray.size()>6?7:myArray.size()).clear();
		}
		System.out.println("After removing from 3 to 6(inclusive): " + myArray);
		
		int sum = 0;
		Iterator<Integer> it = myArray.iterator();
		while(it.hasNext())
			sum += it.next();
		System.out.println("The sum of this list is " + sum);
		System.out.println("\n<main method ends>\n");
	}
	
	public static void inputInteger(ArrayList<Integer> anArrayList)
	{
		System.out.println("\n<method inputInteger starts>\n");
		while(true)
		{
			System.out.print("Please enter an integer: ");
			int aNum;
			try
			{
				aNum = keyboard.nextInt();
			}
			catch (InputMismatchException ime)
			{
				System.out.println("Invalid input! Try again.");
				keyboard.next();
				continue;
			}
			if (aNum == 0)
			{
				break;
			}
			anArrayList.add(aNum);
		}
		System.out.println("\n<method inputInteger ends>\n");
	}

}
