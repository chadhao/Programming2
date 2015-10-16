
/**
 * The Class CustomerDoesNotExistException.
 */
public class CustomerDoesNotExistException extends ServiceException
{
	
	/**
	 * Instantiates a new customer does not exist exception.
	 *
	 * @param errAccount the err account
	 */
	public CustomerDoesNotExistException(Account errAccount)
	{
		super(errAccount, "Customer record does not exist!");
	}
}
