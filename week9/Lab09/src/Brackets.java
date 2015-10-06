import java.util.*;

public class Brackets
{
	private Stack<Character> stack;
	
	public Brackets()
	{
		stack = new Stack<Character>();
	}
	
	public boolean isBalanced(String aString)
	{
		for (int i = 0; i < aString.length(); i++)
		{
			if (stack.empty())
			{
				stack.push(aString.charAt(i));
			}
			else
			{
				if (stack.peek() == '(' && aString.charAt(i) == ')')
				{
					stack.pop();
					continue;
				}
				else if (stack.peek() == '[' && aString.charAt(i) == ']')
				{
					stack.pop();
					continue;
				}
				else if (stack.peek() == '{' && aString.charAt(i) == '}')
				{
					stack.pop();
					continue;
				}
				else
				{
					stack.push(aString.charAt(i));
				}
			}
		}
		return stack.empty()?true:false;
	}
	
	public static void main(String[] args)
	{
		Brackets brackets = new Brackets();
		String str1 = "(())[([])]";
		System.out.println("\"" + str1 + "\" is" + (brackets.isBalanced(str1)?" ": " not ") + "balanced.");
		String str2 = "[([(])]";
		System.out.println("\"" + str2 + "\" is" + (brackets.isBalanced(str2)?" ": " not ") + "balanced.");
	}

}
