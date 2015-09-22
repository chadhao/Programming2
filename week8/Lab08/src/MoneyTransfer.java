
public class MoneyTransfer
{
	private CustomerAccount to;
	private CustomerAccount from;
	private double amount;
	private long timeStamp;
	
	public MoneyTransfer(CustomerAccount to, CustomerAccount from, double amount) throws MoneyTransferException
	{
		if (to.getName() == from.getName())
		{
			MoneyTransferException mte = new MoneyTransferException("Customer accounts cannot be identical!");
			mte.setTimeStamp(System.currentTimeMillis());
			throw mte;
		}
		else
		{
			setTo(to);
			setFrom(from);
			setAmount(amount);
			this.timeStamp = System.currentTimeMillis();
		}
		
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

	public void setTo(CustomerAccount to) throws MoneyTransferException
	{
		if (to == null)
		{
			MoneyTransferException mte = new MoneyTransferException("Customer account cannot be null!");
			mte.setTimeStamp(System.currentTimeMillis());
			throw mte;
		}
		else
		{
			this.to = to;
		}
	}

	public CustomerAccount getFrom()
	{
		return from;
	}

	public void setFrom(CustomerAccount from) throws MoneyTransferException
	{
		if (from == null)
		{
			MoneyTransferException mte = new MoneyTransferException("Customer account cannot be null!");
			mte.setTimeStamp(System.currentTimeMillis());
			throw mte;
		}
		else
		{
			this.from = from;
		}
	}

	public double getAmount()
	{
		return amount;
	}

	public void setAmount(double amount) throws MoneyTransferException
	{
		if (amount <= 0)
		{
			MoneyTransferException mte =  new MoneyTransferException("Amount must be positive!");
			mte.setTimeStamp(System.currentTimeMillis());
			throw mte;
		}
		else
		{
			this.amount = amount;
		}
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
