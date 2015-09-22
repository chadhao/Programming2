
public class MoneyTransferException extends IllegalArgumentException
{
	private long timeStamp;
	
	public MoneyTransferException()
	{
		super();
	}

	public MoneyTransferException(String message)
	{
		super(message);
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
