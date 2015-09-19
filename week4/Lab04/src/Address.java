
public class Address
{
	private int streetNumber;
	private String streetName;
	private String suburb;
	private String city;
	private String postCode;
	
	public Address(int streetNumber, String streetName, String sburb, String city, String postCode)
	{
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.suburb = sburb;
		this.city = city;
		this.postCode = postCode;
	}
	
	public Address()
	{
		this.streetNumber = 0;
		this.streetName = "UNKNOWN";
		this.suburb = "UNKNOWN";
		this.city = "UNKNOWN";
		this.postCode = "UNKNOWN";
	}
}
