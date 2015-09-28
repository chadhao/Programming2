
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

	public String getFlightNum()
	{
		return flightNum;
	}
	
	public String getStartCity()
	{
		return startCity;
	}
	
	public String getDestinationCity()
	{
		return destinationCity;
	}
	
	public String getDepartureTime()
	{
		return departureTime;
	}
	
	public SeatMap getSeats()
	{
		return seats;
	}
}
