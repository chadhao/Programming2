
public class NoSubscriptionException extends ServiceException
{
	public NoSubscriptionException(Account errAccount)
	{
		super(errAccount, "No customer subscibes this service.");
	}
}
