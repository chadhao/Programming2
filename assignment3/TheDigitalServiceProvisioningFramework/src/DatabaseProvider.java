
/**
 * The Class DatabaseProvider.
 */
public class DatabaseProvider extends DigitalServiceProvider
{
	
	/** The name. */
	private String name;
	
	/**
	 * Instantiates a new database provider.
	 */
	public DatabaseProvider()
	{
		this.name = "Database Service Provider";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return name;
	}
}
