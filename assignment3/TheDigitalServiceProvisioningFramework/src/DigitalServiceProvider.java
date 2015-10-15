import java.util.*;
import java.util.Map.Entry;

public abstract class DigitalServiceProvider implements PaymentSystem
{
	private String providerName;
	private HashMap<Account, ServiceUsage> serviceMap;
	
	public DigitalServiceProvider(String providerName)
	{
		this.providerName = providerName;
		serviceMap = new HashMap<>();
	}
	
	public String getProviderName()
	{
		return providerName;
	}
	
	protected void subscribe(Account account, ServiceUsage serviceUsage) throws CustomerAlreadyExistsException
	{
		if (serviceMap.containsKey(account))
		{
			throw new CustomerAlreadyExistsException(account);
		}
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
		String transcript = "";
		ArrayList<Entry<Account, ServiceUsage>> entryList = new ArrayList<>(serviceMap.entrySet());
		if(byName)
		{
			Collections.sort(entryList, compareByName());
		}
		else
		{
			Collections.sort(entryList, compareByUsage());
		}
		return transcript;
	}
}
