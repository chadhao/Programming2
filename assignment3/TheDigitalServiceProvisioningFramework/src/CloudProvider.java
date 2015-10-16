
/**
 * The Class CloudProvider.
 */
public class CloudProvider extends DigitalServiceProvider
{
	
	/** The name. */
	private String name;
	
	/**
	 * Instantiates a new cloud provider.
	 */
	public CloudProvider()
	{
		this.name = "Cloud Service Provider";
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
