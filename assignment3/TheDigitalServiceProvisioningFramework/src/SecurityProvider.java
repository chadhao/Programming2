
/**
 * The Class SecurityProvider.
 */
public class SecurityProvider extends DigitalServiceProvider
{
	
	/** The name. */
	private String name;
	
	/**
	 * Instantiates a new security provider.
	 */
	public SecurityProvider()
	{
		this.name = "Security Service Provider";
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
