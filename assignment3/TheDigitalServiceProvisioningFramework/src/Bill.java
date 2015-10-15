
public class Bill implements Comparable<Bill>
{
	private Account account;
	private String chargeDescription;
	private Double totalAmount;
	
	public Bill(Account account, String chargeDescription, double totalAmount)
	{
		this.account = account;
		this.chargeDescription = chargeDescription;
		this.totalAmount = totalAmount;
	}
	
	@Override
	public String toString()
	{
		return chargeDescription + "TOTAL Amount owing: $" + totalAmount + ".";
	}
	
	@Override
	public int compareTo(Bill o)
	{
		return this.totalAmount.compareTo(o.totalAmount);
	}
}
