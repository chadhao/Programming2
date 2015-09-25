import java.util.Random;

public class AirlineReservationApplication
{
	
	public static void main(String[] args)
	{
		SeatMap seats = new BoeingSeatMap();
		Flight aFlight = new Flight("CZ306", "GUANGZHOU", "AUCKLAND", 0, 10, seats);
		System.out.println(aFlight.getSeats());
		fillFirstClass(aFlight.getSeats());
		System.out.println(aFlight.getSeats());
		
		Airline ra = new SimpleJet();
		
		System.out.println(ra.reserveEconomy(aFlight, SeatType.W));
		System.out.println(ra.reserveFirstClass(aFlight, SeatType.W));
		
		System.out.println(aFlight.getSeats());
	}
	
	public static void randomFillSeats(SeatMap seats)
	{
		Random rand = new Random();
		for (int i = 0; i < 50; i++)
		{
			
			seats.getSeat(rand.nextInt(seats.getNumOfRows())+1, (char)(Character.valueOf('A')+rand.nextInt(seats.getNumOfColumns()))).reserveSeat();
		}
	}
	
	public static void fillFirstClass(SeatMap seats)
	{
		for (int i = 0; i < seats.getNumOfFirstClass(); i++)
		{
			for (int j = 0; j < seats.getNumOfColumns(); j++)
			{
				seats.getSeat(i+1, (char)(Character.valueOf('A')+j)).reserveSeat();
			}
		}
	}
}
