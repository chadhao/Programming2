
public class Exercise1
{
	static boolean CAUSE_EXCEPTION = false;
	
	public static void main(String[] args)
	{
		try
		{
			System.out.println("Try block executed:");
			if (CAUSE_EXCEPTION)
			{
				throw new Exception("This is an exception!");
			}
			System.out.println("End of the try block!");
		}
		catch (Exception e)
		{
			System.err.println("Catch Block executed on :" + e);
		}
		finally
		{
			System.out.println("Finally Block is executed");
		}
	}
}
