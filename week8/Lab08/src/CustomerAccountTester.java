
public class CustomerAccountTester
{

	public static void main(String[] args)
	{
		try
		{
			CustomerAccount c1 = new CustomerAccount("Herr Mustermann");
			c1.setName(null);
		}
		catch (CustomerAccountNameCannotBeNull cancbne)
		{
			System.err.println(cancbne);
		}
	}

}
