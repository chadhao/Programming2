
/**
 * The Class MenuItemDoesNotExistException.
 */
public class MenuItemDoesNotExistException extends ServiceException
{
	
	/**
	 * Instantiates a new menu item does not exist exception.
	 */
	public MenuItemDoesNotExistException()
	{
		super(null, "The item selected does not exist in menu!");
	}
}
