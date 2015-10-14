
public class Bill
{
	private Account account;
	private String chargeDescription;
	private double totalAmount;
	
	public Bill(Account account, String chargeDescription, double totalAmount)
	{
		this.account = account;
		this.chargeDescription = chargeDescription;
		this.totalAmount = totalAmount;
	}
	
	@Override
	public String toString()
	{
		return account + chargeDescription + "TOTAL Amount owing: $" + totalAmount + ".";
	}
}
