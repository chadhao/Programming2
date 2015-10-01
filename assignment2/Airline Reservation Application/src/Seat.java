/**
 * This class defines fields to represent the state of a single seat on a flight.
 * It also provides methods needed for different operations upon a Seat object.
 * 
 * @author      Duan Hao
 */
public class Seat
{
	private SeatPosition position;
	private SeatType type;
	private boolean isFirstClass;
	private boolean isReserved;
	
	public Seat(SeatPosition position, SeatType type, boolean isFirstClass)
	{
		this.position = position;
		this.type = type;
		this.isFirstClass = isFirstClass;
		this.isReserved = false;
	}
	
	@Override
	public String toString()
	{
		return (isFirstClass?type.toString():type.toString().toLowerCase()) + "[" + (isReserved?"X":" ") + "]";
	}
	
	/**
	 * Returns a String to describe the state of a Seat object. 
	 *
	 * @return  the seat type, position, whether the seat is in first class or is reserved
	 */
	public String seatDescription()
	{
		return (isFirstClass?"First":"Economy") + " class " + type.getTypeName() + " seat at: " + position + " is" + (isReserved?" ":" not ") + "reserved.";
	}
	
	/**
	 * Returns a SeatPosition object. 
	 *
	 * @return  a SeatPosition object indicating position of the Seat object in seat map
	 */
	public SeatPosition getPosition()
	{
		return position;
	}
	
	/**
	 * Returns a SeatType object. 
	 *
	 * @return  whether the seat is beside WINDOW, AISLE or in the MIDDLE
	 */
	public SeatType getType()
	{
		return type;
	}
	
	/**
	 * Returns whether the seat has been reserved. 
	 *
	 * @return  <code>true</code> means the seat is reserved, <code>false</code> means this seat can be booked
	 */
	public boolean isReserved()
	{
		return isReserved;
	}
	
	/**
	 * This method is used to reserve the seat.
	 */
	public void reserveSeat()
	{
		this.isReserved = true;
	}
}
