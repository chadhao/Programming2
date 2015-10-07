
public class Account implements Comparable<Account>
{
	private Integer ID;
	private String name;
	private String phone;
	
	public Account(Integer ID, String name, String phone)
	{
		this.ID = ID;
		this.name = name;
		this.phone = phone;
	}
	
	@Override
	public String toString()
	{
		return "Account [ID:" + ID + ", Name:" + name + ", Phone:" + phone + "]";
	}
	
	@Override
	public int compareTo(Account o)
	{
		return this.name.compareTo(o.name);
	}

	public Integer getID()
	{
		return ID;
	}

	public String getName()
	{
		return name;
	}

	public String getPhone()
	{
		return phone;
	}
	
	
}
