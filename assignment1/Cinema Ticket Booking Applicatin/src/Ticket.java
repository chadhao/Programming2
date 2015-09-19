
public class Ticket
{
	private Customer customer;
	private Film film;
	
	public Ticket(Customer customer, Film film)
	{
		this.customer = customer;
		this.film = film;
	}
	
	public String toString()
	{
		return "Your ticket is ready to be collected!\n" +
				"------------------------------------------------------------\n" +
				"FILM TICKET for: " + film + "\n" +
				customer + "\n" +
				"TOTAL COST: $" + String.format("%.2f", cost()) + "\n" +
				"------------------------------------------------------------\n";
	}
	
	public double cost()
	{
		final double ADULT_PRICE = 10;
		final double CHILDREN_PRICE = 7;
		double price = 0;
		if (this.customer.getAge() >= 18)
		{
			if (this.customer.getStudent() && this.customer.getAge() <= 25)
			{
				price = ADULT_PRICE * 0.85;
			}
			else if (this.customer.getStudent())
			{
				price = ADULT_PRICE * 0.9;
			}
			else if (!this.customer.getStudent() && this.customer.getAge() > 64)
			{
				price = ADULT_PRICE * 0.93;
			}
			else
			{
				price = ADULT_PRICE;
			}
		}
		else
		{
			price = (this.customer.getStudent() && this.customer.getAge() >= 10)?CHILDREN_PRICE * 0.85:CHILDREN_PRICE;
		}
		return price;
	}
	
	public Customer getCustomer()
	{
		return customer;
	}
	
	public Film getFilm()
	{
		return film;
	}
}
