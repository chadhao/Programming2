
/**
 * The Class EmailProvider.
 */
public class EmailProvider extends DigitalServiceProvider
{
	
	/** The name. */
	private String name;
	
	/**
	 * Instantiates a new email provider.
	 */
	public EmailProvider()
	{
		this.name = "Email Service Provider";
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
