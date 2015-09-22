
public class MoneyTransferTester
{

	public static void main(String[] args)
	{
		CustomerAccount to = new CustomerAccount("Bob");
		CustomerAccount from = new CustomerAccount("Alice");
		
		try
		{
			new MoneyTransfer(from, to, 100.00);
		}
		catch (MoneyTransferException mte)
		{
			System.err.println(mte);
		}
		
		try
		{
			new MoneyTransfer(from, to, -99.00);
		}
		catch (MoneyTransferException mte)
		{
			System.err.println(mte);
		}
		
		try
		{
			new MoneyTransfer(from, from, 100.00);
		}
		catch (MoneyTransferException mte)
		{
			System.err.println(mte);
		}
		
		try
		{
			new MoneyTransfer(from, null, 100.00);
		}
		catch (MoneyTransferException mte)
		{
			System.err.println(mte);
		}
	}

}
