
public class AirlineReservationApplication
{

	public static void main(String[] args)
	{
		Seat aSeat = new Seat(new SeatPosition(10, 'K'), SeatType.A, true);
		System.out.println(aSeat.seatDescription());
	}

}
