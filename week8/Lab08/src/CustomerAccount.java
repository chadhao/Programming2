
public class CustomerAccount
{
	private String name;
	
	public CustomerAccount(String name) throws IllegalArgumentException
	{
		setName(name);
	}
	
	@Override
	public String toString()
	{
		return "CustomerAccount [name=" + name + "]";
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name) throws IllegalArgumentException
	{
		if (name == null || name == "")
		{
			throw new IllegalArgumentException();
		}
		else
		{
			this.name = name;
		}
	}
}
