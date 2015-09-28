
public class Flight
{
	private String flightNum;
	private String startCity;
	private String destinationCity;
	private String aircraftModel;
	private int departureHour;
	private int departureMin;
	private SeatMap seats;
	
	public Flight(String flightNum, String startCity, String destinationCity, String aircraftModel, int departureHour, int departureMin, SeatMap seats)
	{
		this.flightNum = flightNum.toUpperCase();
		this.startCity = startCity;
		this.destinationCity = destinationCity;
		this.aircraftModel = aircraftModel;
		this.departureHour = (departureHour>=0&&departureHour<=24)?departureHour:0;
		this.departureMin = (departureMin>=0&&departureMin<=24)?departureMin:0;
		this.seats = seats;
	}
	
	@Override
	public String toString()
	{
		return "[" + flightNum + "]\nFrom: " + startCity + "\nTo: " + destinationCity + "\nDeparture Time: " + departureHour + ":" + departureMin + "\n";
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
	
	public String getAircraftModel()
	{
		return aircraftModel;
	}
	
	public String getDepartureTime()
	{
		return departureHour + ":" + departureMin;
	}
	
	public SeatMap getSeats()
	{
		return seats;
	}
}
