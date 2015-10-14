
public class CustomerAlreadyExistsException extends ServiceException
{
	public CustomerAlreadyExistsException(Account errAccount)
	{
		super(errAccount, "Customer record already exists!");
	}
}
