import java.util.Date;

/**
 * The Class ServiceException.
 */
public class ServiceException extends Exception
{
	
	/** The err account. */
	private Account errAccount;
	
	/** The err description. */
	private String errDescription;
	
	/** The err time. */
	private Date errTime;
	
	/**
	 * Instantiates a new service exception.
	 *
	 * @param errAccount the err account
	 * @param errDescription the err description
	 */
	public ServiceException(Account errAccount, String errDescription)
	{
		this.errAccount = errAccount;
		this.errDescription = errDescription;
		this.errTime = new Date(System.currentTimeMillis());
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString()
	{
		return "\n<Error Message>\nError time: " + errTime + "\nError account: " + errAccount + "\nError Description: " + errDescription;
	}
}
