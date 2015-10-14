
public class SameServiceException extends ServiceException
{
	public SameServiceException(Account errAccount)
	{
		super(errAccount, "The service is same as before!");
	}
}
