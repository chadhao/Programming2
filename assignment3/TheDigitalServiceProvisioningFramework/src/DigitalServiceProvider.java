import java.util.*;
import java.util.Map.Entry;

public abstract class DigitalServiceProvider implements PaymentSystem
{
	private HashMap<Account, ServiceUsage> serviceMap;
	
	public DigitalServiceProvider()
	{
		serviceMap = new HashMap<>();
	}
	
	public ArrayList<Account> getKeySet()
	{
		return new ArrayList<>(serviceMap.keySet());
	}
	
	public ServiceUsage getService(Account account)
	{
		return serviceMap.get(account);
	}
	
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
			chargeDescription += counter + ") $" + (nextProduct.getpAmount()*nextProduct.getpPrice()) +
					" (" + nextProduct.getpAmount() + " " + nextProduct.getpName() + " @ $" + nextProduct.getpPrice() + " each)\n";
			totalAmount += nextProduct.getpAmount()*nextProduct.getpPrice();
			counter++;
		}
		return new Bill(anAccount, chargeDescription, totalAmount);
	}
	
	protected void subscribe(Account account, ServiceUsage serviceUsage) throws CustomerAlreadyExistsException
	{
		if (serviceMap.containsKey(account))
		{
			throw new CustomerAlreadyExistsException(account);
		}
		serviceUsage.setUsageBill(calculateBill(account, serviceUsage));
		serviceMap.put(account, serviceUsage);
	}
	
	protected void unsubscribe(Account account) throws CustomerDoesNotExistException
	{
		if (!serviceMap.containsKey(account))
		{
			throw new CustomerDoesNotExistException(account);
		}
		serviceMap.remove(account);
	}
	
	protected ServiceUsage getUsage(Account account) throws CustomerDoesNotExistException
	{
		if (!serviceMap.containsKey(account))
		{
			throw new CustomerDoesNotExistException(account);
		}
		return serviceMap.get(account);
	}
	
	protected void updateUsage(Account account, ServiceUsage serviceUsage) throws CustomerDoesNotExistException, SameServiceException
	{
		if (!serviceMap.containsKey(account))
		{
			throw new CustomerDoesNotExistException(account);
		}
		Iterator<Product> nowIt = serviceMap.get(account).getProducts().iterator();
		Iterator<Product> newIt = serviceUsage.getProducts().iterator();
		while (nowIt.hasNext())
		{
			Product nowProduct = nowIt.next();
			Product newProduct = newIt.next();
			if (nowProduct.getpAmount() == newProduct.getpAmount())
			{
				throw new SameServiceException(account);
			}
		}
		serviceUsage.setUsageBill(calculateBill(account, serviceUsage));
		serviceMap.replace(account, serviceUsage);
	}
	
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
			Collections.sort(entryList, compareByUsage());
		}
		
		String transcript = "<Customer Transcripts>\n\n";
		Iterator<Entry<Account, ServiceUsage>> it = entryList.iterator();
		while (it.hasNext())
		{
			Entry<Account, ServiceUsage> nextEntry = it.next();
			transcript += "Name: " + nextEntry.getKey().getName() + "\n";
			int counter = 1;
			for (Product p : nextEntry.getValue().getProducts())
			{
				transcript += counter + ") $" + (p.getpPrice()*p.getpAmount()) +
						" (" + p.getpAmount() + " " + p.getpName() + " @ $" + p.getpPrice() + " each)\n";
				counter++;
			}
			transcript += "\n";
		}
		transcript += "Total number of customers: " + entryList.size() + "\n";
		
		return transcript;
	}
}
