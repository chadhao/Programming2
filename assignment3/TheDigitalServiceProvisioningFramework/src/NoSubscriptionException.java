
/**
 * The Class NoSubscriptionException.
 */
public class NoSubscriptionException extends ServiceException
{
	
	/**
	 * Instantiates a new no subscription exception.
	 *
	 * @param errAccount the err account
	 */
	public NoSubscriptionException(Account errAccount)
	{
		super(errAccount, "No customer subscibes this service.");
	}
}
