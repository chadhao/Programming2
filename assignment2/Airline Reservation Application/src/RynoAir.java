/**
 * This class is extended from abstract class Airline.
 * This class implemented methods to reserve first and economy class seats based on given criteria.
 * 
 * @author      Duan Hao
 */
public class RynoAir extends Airline
{
	public RynoAir()
	{
		setName("RynoAir");
	}
	
	/**
	 * Returns a Seat object which match the SeatType of a specific flight. 
	 * Searching criteria:
	 * 1. Find and reserve a seat in first class that matches the requested seat type
	 * 2. If no such first class seat with the matching type exists, then find and reserve any seat in first class
	 * 3. If there are no seats available in first class then find and reserve a middle seat in economy class, also reserving both the left and right neighboring seats (for extra passenger room)
	 * 4. If there are no seats matching any of these criteria then a reservation cannot be made
	 *
	 * @param  aFlight  a Flight object to search from
	 * @param  seatType  type of seat that user wanted to book
	 * @return  a Seat object or null if none of the searching criteria is met
	 */
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
					Seat seatNow = aFlight.getSeats().getSeat(i+1, (char)('A'+j));
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
	
	/**
	 * Returns a Seat object which match the SeatType of a specific flight. 
	 * Searching criteria:
	 * 1. Find and reserve a seat in economy class that matches the requested seat type
	 * 2. If no such economy class seat with the matching type exists, then find and reserve any seat in economy class
	 * 3. If there are no seats matching any of these criteria then a reservation cannot be made
	 *
	 * @param  aFlight  a Flight object to search from
	 * @param  seatType  type of seat that user wanted to book
	 * @return  a Seat object which representing an economy class seat or null if none of the searching criteria is met
	 */
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
