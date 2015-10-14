import java.util.ArrayList;

public abstract class ServiceUsage implements Comparable<ServiceUsage>
{
	private String serviceName;
	private ArrayList<Product> products;
	
	public ServiceUsage(String serviceName)
	{
		this.serviceName = serviceName;
		this.products = new ArrayList<>();
	}
	
	@Override
	public int compareTo(ServiceUsage o)
	{
		return this.serviceName.compareTo(o.serviceName);
	}
	
	public String getServiceName()
	{
		return serviceName;
	}
	
	protected void addProduct(String pName, double pPrice)
	{
		products.add(new Product(pName, pPrice));
	}
	
	public int getProductSize()
	{
		return products.size();
	}
	
	public Product getProduct(int index)
	{
		return products.get(index);
	}
	
	protected class Product
	{
		private String pName;
		private double pPrice;
		
		public Product(String pName, double pPrice)
		{
			this.pName = pName;
			this.pPrice = pPrice;
		}
		
		public String getpName()
		{
			return pName;
		}
		
		public double getpPrice()
		{
			return pPrice;
		}
	}
}
