
public class SecurityProvider extends DigitalServiceProvider
{
	private String name;
	
	public SecurityProvider()
	{
		this.name = "Security Service Provider";
	}
	
	@Override
	public String toString()
	{
		return name;
	}
}
