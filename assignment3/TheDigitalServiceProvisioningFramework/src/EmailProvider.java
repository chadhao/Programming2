
public class EmailProvider extends DigitalServiceProvider
{
	private String name;
	
	public EmailProvider()
	{
		this.name = "Email Service Provider";
	}
	
	@Override
	public String toString()
	{
		return name;
	}
}
