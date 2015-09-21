
public class SimpleJet extends Airline
{
	public SimpleJet()
	{
		setName("SimpleJet");
	}
	
	public Seat reserveFirstClass(Flight aFlight, SeatType seatType)
	{
		Seat aSeat = null;
		if (aFlight.getSeats().queryAvailableFirstClassSeat(seatType) != null)
		{
			aSeat = aFlight.getSeats().queryAvailableFirstClassSeat(seatType);
			aSeat.reserveSeat();
		}
		else
		{
			
		}
	}
	
	public Seat reserveEconomy(Flight aFlight, SeatType seatType)
	{
		
	}
}
