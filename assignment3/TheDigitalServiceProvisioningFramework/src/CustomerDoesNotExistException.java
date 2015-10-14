
public class CustomerDoesNotExistException extends ServiceException
{
	public CustomerDoesNotExistException(Account errAccount)
	{
		super(errAccount, "Customer record does not exist!");
	}
}
