
/**
 * The Class CustomerAlreadyExistsException.
 */
public class CustomerAlreadyExistsException extends ServiceException
{
	
	/**
	 * Instantiates a new customer already exists exception.
	 *
	 * @param errAccount the err account
	 */
	public CustomerAlreadyExistsException(Account errAccount)
	{
		super(errAccount, "Customer record already exists!");
	}
}
