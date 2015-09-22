
public class MoneyTransfer
{
	private CustomerAccount to;
	private CustomerAccount from;
	private double amount;
	private long timeStamp;
	
	public MoneyTransfer(CustomerAccount to, CustomerAccount from, double amount)
	{
		this.to = to;
		this.from = from;
		this.amount = amount;
		this.timeStamp = System.currentTimeMillis();
	}

	@Override
	public String toString()
	{
		return "MoneyTransfer [to=" + to + ", from=" + from + ", amount=" + amount + ", timeStamp=" + timeStamp + "]";
	}

	public CustomerAccount getTo()
	{
		return to;
	}

	public void setTo(CustomerAccount to)
	{
		this.to = to;
	}

	public CustomerAccount getFrom()
	{
		return from;
	}

	public void setFrom(CustomerAccount from)
	{
		this.from = from;
	}

	public double getAmount()
	{
		return amount;
	}

	public void setAmount(double amount)
	{
		this.amount = amount;
	}

	public long getTimeStamp()
	{
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp)
	{
		this.timeStamp = timeStamp;
	}
	
}
