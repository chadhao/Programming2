
public class RynoAir extends Airline
{
	public RynoAir()
	{
		setName("RynoAir");
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
			for (int i = aFlight.getSeats().getNumOfFirstClass(); i < aFlight.getSeats().getNumOfRows(); i++)
			{
				for (int j = 0; j < aFlight.getSeats().getNumOfColumns(); j++)
				{
					Seat seatNow = aFlight.getSeats().getSeat(i+1, (char)(Character.valueOf('A')+j));
					if (!seatNow.isReserved() && seatNow.getType() == SeatType.M)
					{
						if (!aFlight.getSeats().getLeft(seatNow).isReserved() && !aFlight.getSeats().getRight(seatNow).isReserved())
						{
							aSeat = seatNow;
							aSeat.reserveSeat();
							aFlight.getSeats().getLeft(seatNow).reserveSeat();
							aFlight.getSeats().getRight(seatNow).reserveSeat();
							break;
						}
					}
				}
				if (aSeat != null)
				{
					break;
				}
			}
		}
		return aSeat;
	}
	
	public Seat reserveEconomy(Flight aFlight, SeatType seatType)
	{
		Seat aSeat = null;
		if (aFlight.getSeats().queryAvailableEconomySeat(seatType) != null)
		{
			aSeat = aFlight.getSeats().queryAvailableEconomySeat(seatType);
			aSeat.reserveSeat();
		}
		return aSeat;
	}
}
