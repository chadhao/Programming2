import java.util.Random;

public class AirlineReservationApplication
{
	
	public static void main(String[] args)
	{
		SeatMap seats = new AirBusSeatMap();
		System.out.println(seats);
		randomFillSeats(seats);
		System.out.println(seats);
	}
	
	public static void randomFillSeats(SeatMap seats)
	{
		Random rand = new Random();
		for (int i = 0; i < 20; i++)
		{
			
			seats.getSeat(rand.nextInt(seats.getNumOfRows())+1, (char)(Character.valueOf('A')+rand.nextInt(seats.getNumOfColumns()))).reserveSeat();
		}
	}
}
