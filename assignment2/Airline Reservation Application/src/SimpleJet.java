
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
			if (aFlight.getSeats().queryAvailableEconomySeat(SeatType.M) != null && aFlight.getSeats().queryAvailableEconomySeat(SeatType.M).getType() == SeatType.M)
			{
				if (aFlight.getSeats().getLeft(aFlight.getSeats().queryAvailableEconomySeat(SeatType.M)) != null)
				{
					aSeat = aFlight.getSeats().queryAvailableEconomySeat(SeatType.M);
					aSeat.reserveSeat();
					aFlight.getSeats().getLeft(aSeat).reserveSeat();
				}
				else if (aFlight.getSeats().getRight(aFlight.getSeats().queryAvailableEconomySeat(SeatType.M)) != null)
				{
					aSeat = aFlight.getSeats().queryAvailableEconomySeat(SeatType.M);
					aSeat.reserveSeat();
					aFlight.getSeats().getRight(aSeat).reserveSeat();
				}
			}
		}
		return aSeat;
	}
	
	public Seat reserveEconomy(Flight aFlight, SeatType seatType)
	{
		
	}
}
