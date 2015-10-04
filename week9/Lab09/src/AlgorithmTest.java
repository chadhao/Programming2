import java.util.*;

public class AlgorithmTest
{
	private static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		ArrayList<Integer> anArrayList = inputInteger(20);
		System.out.println(anArrayList);
		System.out.println("The max number is " + getMax(anArrayList));
		System.out.println("Number " + whichNumberNotRepeat(anArrayList) + " does not repeat.");
	}
	
	public static ArrayList<Integer> inputInteger(int n)
	{
		ArrayList<Integer> anArrayList = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++)
		{
			System.out.print("Enter number " + (i+1) + ": ");
			int aNum;
			try
			{
				aNum = keyboard.nextInt();
			}
			catch (InputMismatchException ime)
			{
				System.out.println("Invalid input! Try again!");
				keyboard.next();
				i--;
				continue;
			}
			anArrayList.add(aNum);
		}
		
		return anArrayList;
	}
	
	public static int getMax(ArrayList<Integer> anArrayList)
	{
		return Collections.max(anArrayList);
	}
	
//	Don't quite understand the requirement of this question.
//	public static Integer whichNumberIsMissing(ArrayList<Integer> anArrayList)
//	{
//		
//	}

	public static Integer whichNumberNotRepeat(ArrayList<Integer> anArrayList)
	{
		Integer anInteger = null;
		Iterator<Integer> it = anArrayList.iterator();
		while (it.hasNext())
		{
			if (Collections.frequency(anArrayList, anInteger = it.next()) == 1)
			{
				break;
			}
		}
		return anInteger;
	}
}
