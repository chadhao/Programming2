import java.util.*;

/**
 * The Class DigitalServiceProviderSelectionApp.
 */
public class DigitalServiceProviderSelectionApp
{
	
	/** The providers. */
	private static ArrayList<DigitalServiceProvider> providers;
	
	/** The keyboard. */
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
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws MenuItemDoesNotExistException the menu item does not exist exception
	 */
	public static void main(String[] args) throws MenuItemDoesNotExistException
	{
		System.out.println("Welcome to Digital Service Provider Selection App!");
		
		while (true)
		{
			int providerSelected = 0;
			int providerServiceSelected = 0;
			int transcriptByName = 0;
			int accountService = 0;
			Account account;
			ServiceUsage service;
			
			//Select provider
			System.out.println("\n<Service Providers>");
			System.out.println("0. Exit");
			for (int i = 0; i < providers.size(); i++)
			{
				System.out.println((i+1) + ". " + providers.get(i));
			}
			System.out.print("Please select from menu: ");
			try
			{
				providerSelected = keyboard.nextInt();
				if (providerSelected < 0 || providerSelected > providers.size())
				{
					throw new MenuItemDoesNotExistException();
				}
				if (providerSelected == 0)
				{
					System.out.println("Thans for using! Bye!");
					break;
				}
			}
			catch (InputMismatchException ime)
			{
				System.out.println("\n<Error Message>\nInvalid input! Going back to main menu...");
				keyboard.next();
				continue;
			}
			catch (MenuItemDoesNotExistException midnee)
			{
				System.out.println(midnee);
				System.out.println("Going back to main menu...");
				continue;
			}
			
			//select provider service
			System.out.println("\n<" + providers.get(providerSelected-1) + ">");
			System.out.println("1. New customer");
			System.out.println("2. Existing customers");
			System.out.println("3. Print customer transcript");
			System.out.print("Please select from menu: ");
			try
			{
				providerServiceSelected = keyboard.nextInt();
				if (providerServiceSelected < 1 || providerServiceSelected > 3)
				{
					throw new MenuItemDoesNotExistException();
				}
			}
			catch (InputMismatchException ime)
			{
				System.out.println("\n<Error Message>\nInvalid input! Going back to main menu...");
				keyboard.next();
				continue;
			}
			catch (MenuItemDoesNotExistException midnee)
			{
				System.out.println(midnee);
				System.out.println("Going back to main menu...");
				continue;
			}
			if (providerServiceSelected == 1)
			{
				account = createNewAccount();
				if (providerSelected == 1)
				{
					service = new CloudUsage();
				}
				else if (providerSelected == 2)
				{
					service = new DatabaseUsage();
				}
				else if (providerSelected == 3)
				{
					service = new EmailUsage();
				}
				else
				{
					service = new SecurityUsage();
				}
				setProductsAmount(service.getProducts());
				try
				{
					providers.get(providerSelected-1).subscribe(account, service);
					System.out.println("You successfully subscribed " + service + " @ " + providers.get(providerSelected-1) + "!");
					continue;
				}
				catch (CustomerAlreadyExistsException caee)
				{
					System.out.println(caee);
					System.out.println("Going back to main menu...");
					continue;
				}
			}
			else if (providerServiceSelected == 3)
			{
				System.out.println("\n<Customer Transcripts>");
				System.out.println("1. Print by name");
				System.out.println("2. Print by usage");
				System.out.print("Please select from menu: ");
				try
				{
					transcriptByName = keyboard.nextInt();
					if (transcriptByName < 1 || transcriptByName > 2)
					{
						throw new MenuItemDoesNotExistException();
					}
					System.out.println(providers.get(providerSelected-1).customerTranscript(transcriptByName==1?true:false));
				}
				catch (InputMismatchException ime)
				{
					System.out.println("\n<Error Message>\nInvalid input! Going back to main menu...");
					keyboard.next();
					continue;
				}
				catch (MenuItemDoesNotExistException midnee)
				{
					System.out.println(midnee);
					System.out.println("Going back to main menu...");
					continue;
				}
				catch (NoSubscriptionException nse)
				{
					System.out.println(nse);
					System.out.println("Going back to main menu...");
					continue;
				}
			}
			else
			{
				account = selectExistingAccount(providers.get(providerSelected-1));
				if (account == null)
				{
					System.out.println("\n<Error Message>\nThere is no customer record! Going back to main menu...");
					continue;
				}
				System.out.println("\n<Account Services>");
				System.out.println("1. Service usage info");
				System.out.println("2. Unsubscribe service");
				System.out.println("3. Update subscription");
				System.out.print("Please select from menu: ");
				try
				{
					accountService = keyboard.nextInt();
					if (accountService < 1 || accountService > 3)
					{
						throw new MenuItemDoesNotExistException();
					}
					if (accountService == 1)
					{
						System.out.println("\n\n<Service Usage Info>");
						System.out.println(providers.get(providerSelected-1).getUsage(account).getUsageBill());
						continue;
					}
					else if (accountService == 2)
					{
						providers.get(providerSelected-1).unsubscribe(account);
						System.out.println("You successfully unsubscribed this service!");
						continue;
					}
					else
					{
						System.out.println("\n\n<Usage Now>");
						System.out.println(providers.get(providerSelected-1).getUsage(account).getUsageBill().getChargeDescription());
						if (providers.get(providerSelected-1).getUsage(account) instanceof CloudUsage)
						{
							service = new CloudUsage();
						}
						else if (providers.get(providerSelected-1).getUsage(account) instanceof DatabaseUsage)
						{
							service = new DatabaseUsage();
						}
						else if (providers.get(providerSelected-1).getUsage(account) instanceof EmailUsage)
						{
							service = new EmailUsage();
						}
						else
						{
							service = new SecurityUsage();
						}
						setProductsAmount(service.getProducts());
						providers.get(providerSelected-1).updateUsage(account, service);
						System.out.println("You successfully updated " + providers.get(providerSelected-1).getUsage(account) + " @ " + providers.get(providerSelected-1) + "!");
					}
				}
				catch (InputMismatchException ime)
				{
					System.out.println("\n<Error Message>\nInvalid input! Going back to main menu...");
					keyboard.next();
					continue;
				}
				catch (MenuItemDoesNotExistException midnee)
				{
					System.out.println(midnee);
					System.out.println("Going back to main menu...");
					continue;
				}
				catch (CustomerDoesNotExistException cdnee)
				{
					System.out.println(cdnee);
					System.out.println("Going back to main menu...");
					continue;
				}
				catch (SameServiceException sse)
				{
					System.out.println(sse);
					System.out.println("Going back to main menu...");
					continue;
				}
			}
		}
		
	}
	
	/**
	 * Creates the new account.
	 *
	 * @return the account
	 */
	public static Account createNewAccount()
	{
		String name;
		String contact;
		keyboard.nextLine();
		System.out.println("\n<Create Account>");
		System.out.print("Name: ");
		name = keyboard.nextLine();
		System.out.print("Address: ");
		contact = keyboard.nextLine();
		return new Account(name, contact);
	}
	
	/**
	 * Select existing account.
	 *
	 * @param provider the provider
	 * @return the account
	 */
	public static Account selectExistingAccount(DigitalServiceProvider provider)
	{
		Account selectedAccount = null;
		while (true)
		{
			if (provider.getEntrySet().isEmpty())
			{
				break;
			}
			int menu = 0;
			System.out.println("\n<Select Account>");
			for (int i = 0; i < provider.getEntrySet().size(); i++)
			{
				System.out.println((i+1) + ". [Name]" + provider.getEntrySet().get(i).getKey().getName() + " [Contact]" + provider.getEntrySet().get(i).getKey().getContact());
			}
			System.out.print("Please select from menu: ");
			try
			{
				menu = keyboard.nextInt();
				if (menu < 1 || menu > provider.getEntrySet().size())
				{
					throw new MenuItemDoesNotExistException();
				}
				selectedAccount = provider.getEntrySet().get(menu-1).getKey();
			}
			catch (InputMismatchException ime)
			{
				System.out.println("\n<Error Message>\nInvalid input! Please try again!");
				keyboard.next();
				continue;
			}
			catch (MenuItemDoesNotExistException midnee)
			{
				System.out.println(midnee);
				System.out.println("Please try again!");
				continue;
			}
			break;
		}
		return selectedAccount;
	}
	
	
	/**
	 * Sets the products amount.
	 *
	 * @param products the new products amount
	 */
	public static void setProductsAmount(ArrayList<Product> products)
	{
		System.out.println("\n<Service Amount>");
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
					System.out.println("\n<Error Message>\nInvalid input! Please try again!");
					keyboard.next();
					continue;
				}
			}
		}
	}
}
