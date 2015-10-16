import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;

/**
 * The Class DigitalServiceProvider.
 */
public abstract class DigitalServiceProvider implements PaymentSystem
{
	
	/** The service map. */
	private HashMap<Account, ServiceUsage> serviceMap;
	
	/**
	 * Instantiates a new digital service provider.
	 */
	public DigitalServiceProvider()
	{
		serviceMap = new HashMap<>();
	}
	
	/**
	 * Gets the entry set.
	 *
	 * @return the entry set
	 */
	public ArrayList<Entry<Account, ServiceUsage>> getEntrySet()
	{
		return new ArrayList<>(serviceMap.entrySet());
	}
	
	/* (non-Javadoc)
	 * @see PaymentSystem#calculateBill(Account, ServiceUsage)
	 */
	@Override
	public Bill calculateBill(Account anAccount, ServiceUsage serviceUsage)
	{
		String chargeDescription = serviceUsage + " USAGE:\n";
		double totalAmount = 0;
		int counter = 1;
		ArrayList<Product> products = serviceUsage.getProducts();
		Iterator<Product> it = products.iterator();
		while (it.hasNext())
		{
			Product nextProduct = it.next();
			
			chargeDescription += counter + ") $" + (new DecimalFormat("0.00").format(nextProduct.getpAmount()*nextProduct.getpPrice())) +
					" (" + nextProduct.getpAmount() + " " + nextProduct.getpName() + " @ $" + nextProduct.getpPrice() + " each)\n";
			totalAmount += nextProduct.getpAmount()*nextProduct.getpPrice();
			counter++;
		}
		return new Bill(anAccount, chargeDescription, totalAmount);
	}
	
	/**
	 * Subscribe.
	 *
	 * @param account the account
	 * @param serviceUsage the service usage
	 * @throws CustomerAlreadyExistsException the customer already exists exception
	 */
	public void subscribe(Account account, ServiceUsage serviceUsage) throws CustomerAlreadyExistsException
	{
		if (serviceMap.containsKey(account))
		{
			throw new CustomerAlreadyExistsException(account);
		}
		serviceUsage.setUsageBill(calculateBill(account, serviceUsage));
		serviceMap.put(account, serviceUsage);
	}
	
	/**
	 * Unsubscribe.
	 *
	 * @param account the account
	 * @throws CustomerDoesNotExistException the customer does not exist exception
	 */
	public void unsubscribe(Account account) throws CustomerDoesNotExistException
	{
		if (!serviceMap.containsKey(account))
		{
			throw new CustomerDoesNotExistException(account);
		}
		serviceMap.remove(account);
	}
	
	/**
	 * Gets the usage.
	 *
	 * @param account the account
	 * @return the usage
	 * @throws CustomerDoesNotExistException the customer does not exist exception
	 */
	public ServiceUsage getUsage(Account account) throws CustomerDoesNotExistException
	{
		if (!serviceMap.containsKey(account))
		{
			throw new CustomerDoesNotExistException(account);
		}
		return serviceMap.get(account);
	}
	
	/**
	 * Update usage.
	 *
	 * @param account the account
	 * @param serviceUsage the service usage
	 * @throws CustomerDoesNotExistException the customer does not exist exception
	 * @throws SameServiceException the same service exception
	 */
	public void updateUsage(Account account, ServiceUsage serviceUsage) throws CustomerDoesNotExistException, SameServiceException
	{
		if (!serviceMap.containsKey(account))
		{
			throw new CustomerDoesNotExistException(account);
		}
		Iterator<Product> nowIt = serviceMap.get(account).getProducts().iterator();
		Iterator<Product> newIt = serviceUsage.getProducts().iterator();
		int counter = 0;
		while (nowIt.hasNext())
		{
			Product nowProduct = nowIt.next();
			Product newProduct = newIt.next();
			if (nowProduct.getpAmount() == newProduct.getpAmount())
			{
				counter++;
			}
		}
		if (counter == serviceUsage.getProducts().size())
		{
			throw new SameServiceException(account);
		}
		serviceUsage.setUsageBill(calculateBill(account, serviceUsage));
		serviceMap.replace(account, serviceUsage);
	}
	
	/**
	 * Compare by name.
	 *
	 * @return the comparator
	 */
	private static Comparator<Entry<Account, ServiceUsage>> compareByName()
	{
		return new Comparator<Map.Entry<Account,ServiceUsage>>()
		{
			@Override
			public int compare(Entry<Account, ServiceUsage> o1, Entry<Account, ServiceUsage> o2)
			{
				return o2.getKey().compareTo(o1.getKey());
			}
		};
	}
	
	/**
	 * Compare by usage.
	 *
	 * @return the comparator
	 */
	private static Comparator<Entry<Account, ServiceUsage>> compareByUsage()
	{
		return new Comparator<Map.Entry<Account,ServiceUsage>>()
		{
			@Override
			public int compare(Entry<Account, ServiceUsage> o1, Entry<Account, ServiceUsage> o2)
			{
				return o2.getValue().getUsageBill().compareTo(o1.getValue().getUsageBill());
			}
		};
	}
	
	/**
	 * Customer transcript.
	 *
	 * @param byName the by name
	 * @return the string
	 * @throws NoSubscriptionException the no subscription exception
	 */
	public String customerTranscript(boolean byName) throws NoSubscriptionException
	{
		if (serviceMap.isEmpty())
		{
			throw new NoSubscriptionException(null);
		}
		
		ArrayList<Entry<Account, ServiceUsage>> entryList = new ArrayList<>(serviceMap.entrySet());
		if(byName)
		{
			Collections.sort(entryList, compareByName().reversed());
		}
		else
		{
//			Iterator<Entry<Account, ServiceUsage>> entryIt = entryList.iterator();
//			while (entryIt.hasNext())
//			{
//				Entry<Account, ServiceUsage> nextEntry = entryIt.next();
//				serviceMap.get(nextEntry.getKey()).setUsageBill(calculateBill(nextEntry.getKey(), nextEntry.getValue()));
//			}
			Collections.sort(entryList, compareByUsage());
		}
		
		String transcript = "\n<Customer Transcripts>\n\n";
		Iterator<Entry<Account, ServiceUsage>> it = entryList.iterator();
		while (it.hasNext())
		{
			Entry<Account, ServiceUsage> nextEntry = it.next();
			transcript += "Name: " + nextEntry.getKey().getName() + "\n";
			int counter = 1;
			for (Product p : nextEntry.getValue().getProducts())
			{
				transcript += counter + ") $" + (new DecimalFormat("0.00").format(p.getpPrice()*p.getpAmount())) +
						" (" + p.getpAmount() + " " + p.getpName() + " @ $" + p.getpPrice() + " each)\n";
				counter++;
			}
			transcript += "\n";
		}
		transcript += "Total number of customers: " + entryList.size() + "\n";
		
		return transcript;
	}
}
