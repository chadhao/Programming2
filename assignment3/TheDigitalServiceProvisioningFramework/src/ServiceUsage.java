import java.util.ArrayList;

/**
 * The Class ServiceUsage.
 */
public abstract class ServiceUsage implements Comparable<ServiceUsage>
{
	
	/** The service name. */
	private String serviceName;
	
	/** The products. */
	private ArrayList<Product> products;
	
	/** The usage bill. */
	private Bill usageBill;
	
	/**
	 * Instantiates a new service usage.
	 *
	 * @param serviceName the service name
	 */
	public ServiceUsage(String serviceName)
	{
		this.serviceName = serviceName.toUpperCase();
		this.products = null;
		this.usageBill = null;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return serviceName;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ServiceUsage o)
	{
		return this.usageBill.compareTo(o.usageBill);
	}
	
	/**
	 * Gets the products.
	 *
	 * @return the products
	 */
	public ArrayList<Product> getProducts()
	{
		return products;
	}
	
	/**
	 * Gets the usage bill.
	 *
	 * @return the usage bill
	 */
	public Bill getUsageBill()
	{
		return usageBill;
	}
	
	/**
	 * Sets the products.
	 *
	 * @param products the new products
	 */
	protected void setProducts(ArrayList<Product> products)
	{
		this.products = products;
	}
	
	/**
	 * Sets the usage bill.
	 *
	 * @param usageBill the new usage bill
	 */
	public void setUsageBill(Bill usageBill)
	{
		this.usageBill = usageBill;
	}
	
	/**
	 * Sets the product amount.
	 *
	 * @param index the index
	 * @param amount the amount
	 */
	public void setProductAmount(int index, int amount)
	{
		products.get(index).setpAmount(amount);
	}
}
