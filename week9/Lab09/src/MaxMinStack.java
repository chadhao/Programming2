import java.util.Stack;

public class MaxMinStack
{
	Stack<Integer> stack;
	Stack<Integer> max;
	Stack<Integer> min;
	
	public MaxMinStack()
	{
		stack = new Stack<Integer>();
		max = new Stack<Integer>();
		min = new Stack<Integer>();
	}
	
	public void push(Integer anInteger)
	{
		if (stack.empty())
		{
			max.push(anInteger);
			min.push(anInteger);
		}
		else
		{
			if (anInteger > max.peek())
			{
				max.push(anInteger);
			}
			else if (anInteger < min.peek())
			{
				min.push(anInteger);
			}
		}
		stack.push(anInteger);
	}
	
	public void pop()
	{
		if (stack.peek() == max.peek())
		{
			max.pop();
		}
		if (stack.peek() == min.peek())
		{
			min.pop();
		}
		stack.pop();
	}
	
	public Integer getMax()
	{
		return max.empty()?null:max.peek();
	}
	
	public Integer getMin()
	{
		return max.empty()?null:min.peek();
	}
	
	public Integer peek()
	{
		return stack.peek();
	}
	
	public static void main(String args[])
	{
		MaxMinStack aStack = new MaxMinStack();
		aStack.push(8);
		aStack.push(1);
		aStack.push(9);
		aStack.push(5);
		aStack.push(0);
		aStack.push(3);
		aStack.pop();
		aStack.pop();
		System.out.println("Max: " + aStack.getMax());
		System.out.println("Min: " + aStack.getMin());
		System.out.println("Top of stack: " + aStack.peek());
	}
}
