import java.util.ArrayList;

public abstract class ServiceUsage implements Comparable<ServiceUsage>
{
	private String serviceName;
	private ArrayList<Product> products;
	private Bill usageBill;
	
	public ServiceUsage(String serviceName, ArrayList<Product> products)
	{
		this.serviceName = serviceName;
		this.products = products;
		this.usageBill = null;
	}
	
	@Override
	public String toString()
	{
		return serviceName;
	}
	
	@Override
	public int compareTo(ServiceUsage o)
	{
		return this.usageBill.compareTo(o.usageBill);
	}
	
	public String getServiceName()
	{
		return serviceName;
	}
	
	public ArrayList<Product> getProducts()
	{
		return products;
	}
	
	public Bill getUsageBill()
	{
		return usageBill;
	}
	
	public void setUsageBill(Bill usageBill)
	{
		this.usageBill = usageBill;
	}
}
