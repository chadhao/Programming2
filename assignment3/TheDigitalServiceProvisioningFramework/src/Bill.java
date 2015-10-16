import java.text.DecimalFormat;

/**
 * The Class Bill.
 */
public class Bill implements Comparable<Bill>
{
	
	/** The account. */
	private Account account;
	
	/** The charge description. */
	private String chargeDescription;
	
	/** The total amount. */
	private Double totalAmount;
	
	/**
	 * Instantiates a new bill.
	 *
	 * @param account the account
	 * @param chargeDescription the charge description
	 * @param totalAmount the total amount
	 */
	public Bill(Account account, String chargeDescription, double totalAmount)
	{
		this.account = account;
		this.chargeDescription = chargeDescription;
		this.totalAmount = totalAmount;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return account + chargeDescription + "TOTAL Amount owing: $" + new DecimalFormat("0.00").format(totalAmount) + ".";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Bill o)
	{
		return this.totalAmount.compareTo(o.totalAmount);
	}
	
	/**
	 * Gets the charge description.
	 *
	 * @return the charge description
	 */
	public String getChargeDescription()
	{
		return chargeDescription;
	}
}
