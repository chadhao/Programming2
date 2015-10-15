import java.util.*;

public class DigitalServiceProviderSelectionApp
{
	private static ArrayList<DigitalServiceProvider> providers;
	private static HashSet<Account> accounts;
	private static Scanner keyboard;
	
	static
	{
		keyboard = new Scanner(System.in);
		providers = new ArrayList<>();
		providers.add(new CloudProvider());
		providers.add(new DatabaseProvider());
		providers.add(new EmailProvider());
		providers.add(new SecurityProvider());
	}
	
	public static void main(String[] args)
	{
		CloudProvider cloudProvider = new CloudProvider();
		Account chad = new Account("Chad", "12A Saffron Street, Birkdale");
		Account rick = new Account("Rick", "WT303, Auckland University of Technology");
		try
		{
			cloudProvider.subscribe(chad, new CloudUsage());
			cloudProvider.getService(chad).setProductAmount(0, 12);
			cloudProvider.getService(chad).setProductAmount(1, 24);
			
			cloudProvider.subscribe(rick, new CloudUsage());
			cloudProvider.getService(rick).setProductAmount(0, 4);
			cloudProvider.getService(rick).setProductAmount(1, 83);
			System.out.println(cloudProvider.customerTranscript(true));
		}
		catch (ServiceException se)
		{
			
		}
		
	}
	
	public static void setAllAccounts()
	{
		Iterator<DigitalServiceProvider> it = providers.iterator();
		while (it.hasNext())
		{
			accounts.addAll(it.next().getKeySet());
		}
	}
	
	public static void setProductsAmount(ArrayList<Product> products)
	{
		System.out.println("Please enter amount of the products");
		Iterator<Product> it = products.iterator();
		while (it.hasNext())
		{
			Product aProduct = it.next();
			while (true)
			{
				System.out.print("<" + aProduct.getpName() + " @ $" + aProduct.getpPrice() + ">: ");
				int amount;
				try
				{
					amount = keyboard.nextInt();
					aProduct.setpAmount(amount);
					break;
				}
				catch (InputMismatchException ime)
				{
					System.out.println("Invalid input! Please try again!");
					keyboard.next();
					continue;
				}
			}
		}
	}
}
