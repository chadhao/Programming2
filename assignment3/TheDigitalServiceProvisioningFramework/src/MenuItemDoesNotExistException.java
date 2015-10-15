
public class MenuItemDoesNotExistException extends ServiceException
{
	public MenuItemDoesNotExistException()
	{
		super(null, "The item selected does not exist in menu!");
	}
}
