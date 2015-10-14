
public class Product
{
	private String pName;
	private double pPrice;
	private int pAmount;
	
	public Product(String pName, double pPrice)
	{
		this.pName = pName;
		this.pPrice = pPrice;
		this.pAmount = 0;
	}
	
	@Override
	public String toString()
	{
		return pAmount + " " + pName + " @ $" + pPrice + " each";
	}
	
	public String getpName()
	{
		return pName;
	}
	
	public double getpPrice()
	{
		return pPrice;
	}
	
	public int getpAmount()
	{
		return pAmount;
	}
	
	public void setpAmount(int pAmount)
	{
		this.pAmount = pAmount;
	}
}
