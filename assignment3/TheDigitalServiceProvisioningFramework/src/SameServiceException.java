
/**
 * The Class SameServiceException.
 */
public class SameServiceException extends ServiceException
{
	
	/**
	 * Instantiates a new same service exception.
	 *
	 * @param errAccount the err account
	 */
	public SameServiceException(Account errAccount)
	{
		super(errAccount, "The service is same as before!");
	}
}
