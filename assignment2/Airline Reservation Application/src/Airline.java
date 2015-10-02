/**
 * This class is used as a super class which defined two abstract method for sub classes to reserve first class and economy seats.
 * 
 * @author      Duan Hao
 */
public abstract class Airline
{
	private String name;
	
	@Override
	public String toString()
	{
		return name + " Airline";
	}
	
	/**
	 * Set name of an airline.
	 *
	 * @param  name  name of the airline
	 */
	protected void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * This abstract method is used for reserving First Class seats.
	 * 
	 * @param aFlight a Flight object to search from
	 * @param seatType type of seat that user wanted to book
	 * @return a Seat object or null
	 */
	protected abstract Seat reserveFirstClass(Flight aFlight, SeatType seatType);
	
	/**
	 * This abstract method is used for reserving Economy seats.
	 * 
	 * @param aFlight a Flight object to search from
	 * @param seatType type of seat that user wanted to book
	 * @return a Seat object or null
	 */
	protected abstract Seat reserveEconomy(Flight aFlight, SeatType seatType);
}
