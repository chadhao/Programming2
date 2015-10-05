import java.util.*;

public class AlgorithmTest
{
	private static Scanner keyboard = new Scanner(System.in);
	private static Random rand = new Random();
	
	public static void main(String[] args)
	{
		ArrayList<Integer> anArrayList = inputInteger(15);
		System.out.println(anArrayList);
		System.out.println("The max number is " + getMax(anArrayList));
		System.out.println("Number " + whichNumberNotRepeat(anArrayList) + " does not repeat.");
		
		anArrayList.clear();
		for (int i = 0; i < 100; i++)
		{
			if (rand.nextInt(100) > 1)
			{
				anArrayList.add(i+1);
			}
		}
		Collections.shuffle(anArrayList);
		int numOfMissing = whichNumberIsMissing(anArrayList);
		System.out.println(numOfMissing<2?numOfMissing==1?"1 number is missing":"nothing is missing":numOfMissing + " numbers are missing");
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
	
	public static Integer whichNumberIsMissing(ArrayList<Integer> anArrayList)
	{
		int counter = 0;
		int[] isEmpty = new int[100];
		for (int i = 0; i < 100; i++) isEmpty[i] = 0;
		Iterator<Integer> it = anArrayList.iterator();
		while(it.hasNext())
		{
			int next = it.next();
			if (next != 0)
			{
				isEmpty[next-1] = 1;
			}
		}
		for (int a : isEmpty)
		{
			if (a == 0)
			{
				counter++;
			}
		}
		return counter;
	}

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
