import java.util.*;

public class DigitalServiceProviderSelectionApp
{
	private static ArrayList<DigitalServiceProvider> providers;
	private static ArrayList<Account> accounts;
	
	static
	{
		
	}
	
	public static void main(String[] args)
	{
		CloudProvider cloudProvider = new CloudProvider();
		Account chad = new Account("Chad", "12A Saffron Street, Birkdale");
		Account rick = new Account("Rick", "WT303, Auckland University of Technology");
		try
		{
			cloudProvider.subscribe(chad, new CloudUsage());
			//System.out.println(cloudProvider.getUsage(chad).getUsageBill());
			System.out.println(cloudProvider.customerTranscript(true));
		}
		catch (ServiceException se)
		{
			
		}
		
	}
	
	public static void setAllAccounts()
	{
		
	}
	
	public static void setProductsAmount(ArrayList<Product> products)
	{
		Iterator<Product> it = products.iterator();
		while (it.hasNext())
		{
			
		}
	}
}
