
/**
 * This class defines fields to represent state of a flight.
 * And provides methods to access and mutate them.
 * 
 * @author Duan Hao
 *
 */
public class Flight
{
	private String flightNum;
	private String startCity;
	private String destinationCity;
	private String departureTime;
	private SeatMap seats;
	
	public Flight(String flightNum, String startCity, String destinationCity, String departureTime, SeatMap seats)
	{
		this.flightNum = flightNum.toUpperCase();
		this.startCity = startCity;
		this.destinationCity = destinationCity;
		this.departureTime = departureTime;
		this.seats = seats;
	}
	
	@Override
	public String toString()
	{
		return "Flight Number: " + flightNum + "\nFrom " + startCity + " To " + destinationCity + "\nScheduled Departure Time: " + departureTime + "\nAircraft Model: " + seats.getAircraftModel();
	}

	/**
	 * @return flight number of this flight
	 */
	public String getFlightNum()
	{
		return flightNum;
	}
	
	/**
	 * @return start city of this flight
	 */
	public String getStartCity()
	{
		return startCity;
	}
	
	/**
	 * @return a SeatMap object representing all seats on this flight
	 */
	public SeatMap getSeats()
	{
		return seats;
	}
}
