import java.util.Date;

public class ServiceException extends Exception
{
	private Account errAccount;
	private String errDescription;
	private Date errTime;
	
	public ServiceException(Account errAccount, String errDescription)
	{
		this.errAccount = errAccount;
		this.errDescription = errDescription;
		this.errTime = new Date(System.currentTimeMillis());
	}
	
}
