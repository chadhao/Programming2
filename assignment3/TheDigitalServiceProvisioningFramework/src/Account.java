
public class Account implements Comparable<Account>
{
	private Integer ID;
	private String name;
	private String contact;
	
	public Account(Integer ID, String name, String contact)
	{
		this.ID = ID;
		this.name = name;
		this.contact = contact;
	}
	
	@Override
	public String toString()
	{
		return "Customer name: " + name + ". Account number: " + ID + "\nContact details: " + contact + "\ns";
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

	public String getContact()
	{
		return contact;
	}
	
}
