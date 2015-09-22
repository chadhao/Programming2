
public class MoneyTransferException extends IllegalArgumentException
{
	private long timeStamp;
	
	public MoneyTransferException()
	{
		super();
		this.timeStamp = System.currentTimeMillis();
	}

	public MoneyTransferException(String message)
	{
		super(message);
		this.timeStamp = System.currentTimeMillis();
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
