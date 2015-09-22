
public class Exercise2
{
	public static void main(String[] args)
	{
		for (int i = 0; i < 10; i++)
		{
			try
			{
				throw new Exception("exception caught!");
			}
			catch (Exception e)
			{
				System.err.println((i+1) + ". " + e);
			}
		}
	}
}
