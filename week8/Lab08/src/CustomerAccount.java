
public class CustomerAccount
{
	private String name;
	
	public CustomerAccount(String name) throws CustomerAccountNameCannotBeNull
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

	public void setName(String name) throws CustomerAccountNameCannotBeNull
	{
		if (name == null || name == "")
		{
			throw new CustomerAccountNameCannotBeNull();
		}
		else
		{
			this.name = name;
		}
	}
}
