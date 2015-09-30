import java.util.*;

public class AirlineReservationApplication
{
	private static Random rand = new Random();
	private static Scanner keyboard = new Scanner(System.in);
	private static SeatMap[] seats = new SeatMap[10];
	private static Flight[] flights = new Flight[10];
	private static ArrayList<String> cityArray = new ArrayList<>();
	
	static
	{
		for (int i = 0; i < 10; i++)
		{
			seats[i] = (rand.nextInt(2) == 0)?new BoeingSeatMap():new AirBusSeatMap();
		}
		flights[0] = new Flight("CI51", "TAIPEI", "AUCKLAND", "11:40", seats[0]);
		flights[1] = new Flight("EK407", "AUCKLAND", "DUBAI", "18:30", seats[1]);
		flights[2] = new Flight("CA975", "BEIJING", "SINGAPORE", "00:05", seats[2]);
		flights[3] = new Flight("CA942", "DUBAI", "BEIJING", "12:10", seats[3]);
		flights[4] = new Flight("SQ878", "SINGAPORE", "TAIPEI", "11:55", seats[4]);
		flights[5] = new Flight("AF5202", "PARIS", "SHANGHAI", "20:20", seats[5]);
		flights[6] = new Flight("KA831", "SHANGHAI", "HONGKONG", "08:40", seats[6]);
		flights[7] = new Flight("CX846", "HONGKONG", "NEWYORK", "18:45", seats[7]);
		flights[8] = new Flight("BA180", "NEWYORK", "LONGDON", "07:15", seats[8]);
		flights[9] = new Flight("VS250", "LONGDON", "SHANGHAI", "15:15", seats[9]);
	}
	
	public static void main(String[] args) throws AirlineReservationException
	{
		while(true)
		{
			int menu;
			int selectedCity;
			int selectedAirline;
			Flight selectedFlight;
			
			System.out.println("Welcome to Airline Reservation System!");
			System.out.println("--------------------------------------");
			System.out.println("1. Book by start city");
			System.out.println("2. Book by destination city");
			System.out.println("3. Exit");
			System.out.print("\nPlease choose from menu: ");
			try
			{
				menu = keyboard.nextInt();
				if (menu > 3 || menu < 1)
				{
					throw new AirlineReservationException();
				}
				if (menu == 3)
				{
					System.out.println("Thank you! Bye!");
				}
				else if (menu == 1)
				{
					printCities(1);
				}
				else
				{
					printCities(2);
				}
				
				System.out.println("Please select city: ");
				selectedCity = keyboard.nextInt();
				
				if (selectedCity > cityArray.size() || selectedCity < 1)
				{
					throw new AirlineReservationException();
				}
			}
			catch (AirlineReservationException are)
			{
				System.out.println("\nInvalid input!\nPlease try again.\n");
				continue;
			}
			catch (InputMismatchException ime)
			{
				System.out.println("\nInvalid input!\nPlease try again.\n");
				keyboard.next();
				continue;
			}
			
			
		}
	}
	
	public static void generateCityArray(int menu)
	{
		if (!cityArray.isEmpty())
		{
			cityArray.clear();
		}
		HashSet<String> citySet = new HashSet<>();
		for (Flight aFlight : flights)
		{
			citySet.add((menu == 1)?aFlight.getStartCity():aFlight.getDestinationCity());
		}
		for (String str : citySet)
		{
			cityArray.add(str);
		}
	}
	
	public static void printCities(int menu)
	{
		generateCityArray(menu);
		System.out.println();
		for (int i = 0; i < cityArray.size(); i++)
		{
			System.out.println((i+1) + ". " + cityArray.get(i));
		}
		System.out.println();
	}
	
//	public static void randomFillSeats(SeatMap seats)
//	{
//		Random rand = new Random();
//		for (int i = 0; i < 50; i++)
//		{
//			seats.getSeat(rand.nextInt(seats.getNumOfRows())+1, (char)(Character.valueOf('A')+rand.nextInt(seats.getNumOfColumns()))).reserveSeat();
//		}
//	}
//	
//	public static void fillFirstClass(SeatMap seats)
//	{
//		for (int i = 0; i < seats.getNumOfFirstClass(); i++)
//		{
//			for (int j = 0; j < seats.getNumOfColumns(); j++)
//			{
//				seats.getSeat(i+1, (char)(Character.valueOf('A')+j)).reserveSeat();
//			}
//		}
//	}
}
