
public class AirlineReservationApplication
{

	public static void main(String[] args)
	{
		SeatMap seats = new AirBusSeatMap();
		System.out.println(seats.getLeft(seats.getSeat(5, 'D')).seatDescription());
		
	}

}
