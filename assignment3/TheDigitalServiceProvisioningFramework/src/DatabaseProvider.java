
public class DatabaseProvider extends DigitalServiceProvider
{
	private String name;
	
	public DatabaseProvider()
	{
		this.name = "Database Service Provider";
	}
	
	@Override
	public String toString()
	{
		return name;
	}
}
