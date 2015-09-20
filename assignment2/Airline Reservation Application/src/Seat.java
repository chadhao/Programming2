
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
	
	public String seatDescription()
	{
		return (isFirstClass?"First":"Economy") + " class " + type.getTypeName() + " seat at: " + position + " is" + (isReserved?" ":" not ") + "reserved.";
	}
	
	public SeatPosition getPosition()
	{
		return position;
	}
	
	public SeatType getType()
	{
		return type;
	}
	
	public boolean isReserved()
	{
		return isReserved;
	}
	
	public boolean isFirstClass()
	{
		return isFirstClass;
	}
}
