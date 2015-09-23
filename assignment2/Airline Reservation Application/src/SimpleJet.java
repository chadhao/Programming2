
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
			for (int i = aFlight.getSeats().getNumOfFirstClass(); i < aFlight.getSeats().getNumOfRows(); i++)
			{
				for (int j = 0; j < aFlight.getSeats().getNumOfColumns(); i++)
				{
					Seat seatNow = aFlight.getSeats().getSeat(i+1, (char)(Character.valueOf('A')+j));
					if (!seatNow.isReserved() && seatNow.getType() == SeatType.W)
					{
						if (j == 0 && !aFlight.getSeats().getRight(seatNow).isReserved())
						{
							aSeat = seatNow;
							aSeat.reserveSeat();
							aFlight.getSeats().getRight(seatNow).reserveSeat();
							break;
						}
						else if (j == aFlight.getSeats().getNumOfColumns()-1 && !aFlight.getSeats().getLeft(seatNow).isReserved())
						{
							aSeat = seatNow;
							aSeat.reserveSeat();
							aFlight.getSeats().getLeft(seatNow).reserveSeat();
							break;
						}
					}
					else if (!seatNow.isReserved() && seatNow.getType() == SeatType.M)
					{
						if (!aFlight.getSeats().getLeft(seatNow).isReserved())
						{
							aSeat = seatNow;
							aSeat.reserveSeat();
							aFlight.getSeats().getLeft(seatNow).reserveSeat();
							break;
						}
						else if (!aFlight.getSeats().getRight(seatNow).isReserved())
						{
							aSeat = seatNow;
							aSeat.reserveSeat();
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
