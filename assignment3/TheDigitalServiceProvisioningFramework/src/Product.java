
/**
 * The Class Product.
 */
public class Product
{
	
	/** The p name. */
	private String pName;
	
	/** The p price. */
	private double pPrice;
	
	/** The p amount. */
	private int pAmount;
	
	/**
	 * Instantiates a new product.
	 *
	 * @param pName the name
	 * @param pPrice the price
	 */
	public Product(String pName, double pPrice)
	{
		this.pName = pName;
		this.pPrice = pPrice;
		this.pAmount = 0;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return pAmount + " " + pName + " @ $" + pPrice + " each";
	}
	
	/**
	 * Gets the p name.
	 *
	 * @return the p name
	 */
	public String getpName()
	{
		return pName;
	}
	
	/**
	 * Gets the p price.
	 *
	 * @return the p price
	 */
	public double getpPrice()
	{
		return pPrice;
	}
	
	/**
	 * Gets the p amount.
	 *
	 * @return the p amount
	 */
	public int getpAmount()
	{
		return pAmount;
	}
	
	/**
	 * Sets the p amount.
	 *
	 * @param pAmount the new p amount
	 */
	public void setpAmount(int pAmount)
	{
		this.pAmount = pAmount;
	}
}
