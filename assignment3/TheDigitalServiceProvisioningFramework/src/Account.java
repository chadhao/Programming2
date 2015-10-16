
/**
 * The Class Account.
 */
public class Account implements Comparable<Account>
{
	
	/** The id. */
	private Integer ID;
	
	/** The name. */
	private String name;
	
	/** The contact. */
	private String contact;
	
	/** The nowID keeps track of the latest generated ID. */
	private static int nowID = 0;
	
	/**
	 * Instantiates a new account.
	 *
	 * @param name the name
	 * @param contact the contact
	 */
	public Account(String name, String contact)
	{
		this.ID = nextID();
		this.name = name.toUpperCase();
		this.contact = contact.toUpperCase();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Customer name: " + name + ". Account number: " + ID + "\nContact details: " + contact + "\n";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Account o)
	{
		return this.name.compareTo(o.name);
	}

	/**
	 * Next id.
	 *
	 * @return the latest auto generated ID number
	 */
	private int nextID()
	{
		return ++nowID;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getID()
	{
		return ID;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Gets the contact.
	 *
	 * @return the contact
	 */
	public String getContact()
	{
		return contact;
	}
	
}
