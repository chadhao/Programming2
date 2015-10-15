
public class Account implements Comparable<Account>
{
	private Integer ID;
	private String name;
	private String contact;
	private static int nowID = 0;
	
	public Account(String name, String contact)
	{
		this.ID = nextID();
		this.name = name.toUpperCase();
		this.contact = contact.toUpperCase();
	}
	
	@Override
	public String toString()
	{
		return "Customer name: " + name + ". Account number: " + ID + "\nContact details: " + contact + "\n";
	}
	
	@Override
	public int compareTo(Account o)
	{
		return this.name.compareTo(o.name);
	}

	private int nextID()
	{
		return ++nowID;
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
