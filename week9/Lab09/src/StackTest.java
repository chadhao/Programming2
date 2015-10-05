import java.util.*;

public class StackTest
{
	private static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		Stack<Integer> stack = new Stack<Integer>();
		
		pushOntoStack(stack);
		
	}
	
	public static void pushOntoStack(Stack<Integer> stack)
	{
		while(true)
		{
			int aNum;
			System.out.print("Enter an integer: ");
			try
			{
				aNum = keyboard.nextInt();
			}
			catch (InputMismatchException ime)
			{
				if (keyboard.next().equals("quit"))
				{
					System.out.println("<finish input>");
					break;
				}
				else
				{
					System.out.println("Invalid input! Try Again!");
					continue;
				}
			}
			stack.push(aNum);
		}
		while(!stack.empty())
		{
			System.out.print(stack.pop() + " ");
		}
	}

}
