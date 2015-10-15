
public class CloudProvider extends DigitalServiceProvider
{
	private String name;
	
	public CloudProvider()
	{
		this.name = "Cloud Service Provider";
	}
	
	@Override
	public String toString()
	{
		return name;
	}
}
