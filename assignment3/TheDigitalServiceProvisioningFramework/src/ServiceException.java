
public class ServiceException extends Exception
{
	private Account errAccount;
	private String errDescription;
	private long errTime;
	
	public ServiceException(Account errAccount, String errDescription)
	{
		this.errAccount = errAccount;
		this.errDescription = errDescription;
		this.errTime = System.currentTimeMillis();
	}
		
}
