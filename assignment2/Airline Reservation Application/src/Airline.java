
public abstract class Airline
{
	private String name;
	
	@Override
	public String toString()
	{
		return name + " Airline";
	}

	protected void setName(String name)
	{
		this.name = name;
	}
	
	protected abstract Seat reserveFirstClass(Flight aFlight, SeatType seatType);
	
	protected abstract Seat reserveEconomy(Flight aFlight, SeatType seatType);
}
