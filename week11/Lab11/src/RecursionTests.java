import java.math.BigInteger;

public class RecursionTests
{

	public static void main(String[] args)
	{
		System.out.println(factorial(10));
		System.out.println(fib(8));
		int[] fibArray = fibSubSequence(8, 12);
		if (fibArray != null)
		{
			for (int num : fibArray)
			{
				System.out.print(num + " ");
			}
		}
		System.out.println();
		System.out.println(aFunc(3, 7));
	}
	
	public static int factorial(int n)
	{
		if (n == 1 || n == 2)
		{
			return 1;
		}
		else if (n <= 0)
		{
			return 0;
		}
		return n*factorial(n-1);
	}
	
	public static int fib(int n)
	{
		if (n == 1 || n == 2)
		{
			return 1;
		}
		return fib(n-1) + fib(n-2);
	}
	
	public static int[] fibSubSequence(int i, int j)
	{
		if (i > j)
		{
			return null;
		}
		int[] fibArray = new int[j-i+1];
		int k = 0;
		for (;i <= j; i++)
		{
			fibArray[k] = fib(i);
			k++;
		}
		return fibArray;
	}
	
	public static int aFunc(int x, int y)
	{
		if (x < 0 || y < 0)
		{
			return 0;
		}
		else if (x == 0)
		{
			return y+1;
		}
		else if (y == 0 && x > 0)
		{
			return aFunc(x-1, 1);
		}
		else
		{
			return aFunc(x-1, aFunc(x, y-1));
		}
	}
}
