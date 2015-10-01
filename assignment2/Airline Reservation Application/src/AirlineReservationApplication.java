import java.util.*;

public class AirlineReservationApplication
{
	private static Random rand = new Random();
	private static Scanner keyboard = new Scanner(System.in);
	private static Flight[] flights = new Flight[10];
	private static ArrayList<String> cityArray = new ArrayList<>();
	private static ArrayList<Flight> flightArray = new ArrayList<>();
	
	static
	{
		flights[0] = new Flight("CI51", "BEIJING", "AUCKLAND", "11:40", (rand.nextInt(2) == 0)?new BoeingSeatMap():new AirBusSeatMap());
		flights[1] = new Flight("EK407", "AUCKLAND", "DUBAI", "18:30", (rand.nextInt(2) == 0)?new BoeingSeatMap():new AirBusSeatMap());
		flights[2] = new Flight("CA975", "BEIJING", "SINGAPORE", "00:05", (rand.nextInt(2) == 0)?new BoeingSeatMap():new AirBusSeatMap());
		flights[3] = new Flight("CA942", "HONGKONG", "BEIJING", "12:10", (rand.nextInt(2) == 0)?new BoeingSeatMap():new AirBusSeatMap());
		flights[4] = new Flight("SQ878", "HONGKONG", "TAIPEI", "11:55", (rand.nextInt(2) == 0)?new BoeingSeatMap():new AirBusSeatMap());
		flights[5] = new Flight("AF5202", "AUCKLAND", "SHANGHAI", "20:20", (rand.nextInt(2) == 0)?new BoeingSeatMap():new AirBusSeatMap());
		flights[6] = new Flight("KA831", "BEIJING", "HONGKONG", "08:40", (rand.nextInt(2) == 0)?new BoeingSeatMap():new AirBusSeatMap());
		flights[7] = new Flight("CX846", "HONGKONG", "NEWYORK", "18:45", (rand.nextInt(2) == 0)?new BoeingSeatMap():new AirBusSeatMap());
		flights[8] = new Flight("BA180", "AUCKLAND", "LONGDON", "07:15", (rand.nextInt(2) == 0)?new BoeingSeatMap():new AirBusSeatMap());
		flights[9] = new Flight("VS250", "BEIJING", "SHANGHAI", "15:15", (rand.nextInt(2) == 0)?new BoeingSeatMap():new AirBusSeatMap());
		for (int i = 0; i < 10; i++)
		{
			randomFillSeats(flights[i].getSeats());
		}
	}
	
	public static void main(String[] args) throws AirlineReservationException
	{
		while (true)
		{
			String tempStr;
			int tempInt;
			int selectedCity;
			int selectedFlight;
			Airline selectedAirline;
			boolean isFirstClass = false;
			boolean bookAnother = false;
			SeatType selectedType;
			Seat bookedSeat = null;
			
			System.out.println("<Welcome to Airline Reservation System>");
			printCities();
			System.out.print("Please choose from menu: ");
			try
			{
				selectedCity = keyboard.nextInt();
				if (selectedCity > cityArray.size() || selectedCity < 0)
				{
					throw new AirlineReservationException();
				}
				if (selectedCity == 0)
				{
					System.out.println("Thank you! Bye!");
					break;
				}
				else
				{
					printFlights(cityArray.get(selectedCity - 1));
					System.out.print("Please choose from menu: ");
					while (true)
					{
						selectedFlight = keyboard.nextInt();
						if (selectedFlight > flightArray.size() || selectedFlight < 0)
						{
							throw new AirlineReservationException();
						}
						if (selectedFlight == 0)
						{
							System.out.println("Returning to previous menu...");
							break;
						}
						else
						{
							System.out.println("\nSeatmap of flight " + flightArray.get(selectedFlight-1).getFlightNum() + " are shown below");
							System.out.println("------------------------------------------\n");
							System.out.println(flightArray.get(selectedFlight-1).getSeats());
							System.out.println("Do you want to book first class ticket?(Y/N): ");
							tempStr = keyboard.next();
							if (tempStr.length() > 1 || (tempStr.toUpperCase().charAt(0) != 'Y' && tempStr.toUpperCase().charAt(0) != 'N'))
							{
								throw new AirlineReservationException();
							}
							isFirstClass = tempStr.toUpperCase().charAt(0) == 'Y'?true:false;
							System.out.println("Do you prefer WINDOW/AISLE/MIDDLE seat?(W/A/M): ");
							tempStr = keyboard.next();
							if (tempStr.length() > 1 || (tempStr.toUpperCase().charAt(0) != 'W' && tempStr.toUpperCase().charAt(0) != 'A' && tempStr.toUpperCase().charAt(0) != 'M'))
							{
								throw new AirlineReservationException();
							}
							if (tempStr.toUpperCase().charAt(0) == 'W')
							{
								selectedType = SeatType.W;
							}
							else if (tempStr.toUpperCase().charAt(0) == 'A')
							{
								selectedType = SeatType.A;
							}
							else
							{
								selectedType = SeatType.M;
							}
							System.out.println("\nAvailable airlines are listed below");
							System.out.println("-----------------------------------");
							System.out.println("<1> SimpleJet Airline");
							System.out.println("<2> RynoAir Airline");
							System.out.print("\nPlease choose from menu: ");
							tempInt = keyboard.nextInt();
							if (tempInt > 2 || tempInt < 1)
							{
								throw new AirlineReservationException();
							}
							selectedAirline = tempInt == 1?new SimpleJet():new RynoAir();
							bookedSeat = isFirstClass?selectedAirline.reserveFirstClass(flightArray.get(selectedFlight-1), selectedType):selectedAirline.reserveEconomy(flightArray.get(selectedFlight-1), selectedType);
							if (bookedSeat != null)
							{
								System.out.println();
								System.out.println("********************Booking Confirmation********************");
								System.out.println("Your booking has been confirmed by " + selectedAirline + "!");
								System.out.println("Here is your booking detail:\n");
								System.out.println(flightArray.get(selectedFlight-1));
								System.out.println(bookedSeat.seatDescription());
							}
							else
							{
								System.out.println();
								System.out.println("Sorry, all available seats have been booked.");
								System.out.println("Your booking cannot be made!");
							}
							System.out.println("\nDo you want to book another ticket?(Y/N): ");
							tempStr = keyboard.next();
							if (tempStr.length() > 1 || (tempStr.toUpperCase().charAt(0) != 'Y' && tempStr.toUpperCase().charAt(0) != 'N'))
							{
								throw new AirlineReservationException();
							}
							bookAnother = tempStr.toUpperCase().charAt(0) == 'Y'?true:false;
							break;
						}
					}
				}
				if (!bookAnother)
				{
					System.out.println("Thank you! Bye!");
					break;
				}
			}
			catch (AirlineReservationException are)
			{
				System.out.println("\nInvalid input!\nPlease try again.\n");
				continue;
			}
			catch (InputMismatchException ime)
			{
				System.out.println("\nInput type mismatch!\nPlease try again.\n");
				keyboard.next();
				continue;
			}
		}
	}
	
	public static void printFlights(String city)
	{
		if (!flightArray.isEmpty())
		{
			flightArray.clear();
		}
		for (Flight aFlight : flights)
		{
			if (aFlight.getStartCity() == city)
			{
				flightArray.add(aFlight);
			}
		}
		System.out.println("\nAvailable flights are listed below");
		System.out.println("----------------------------------");
		System.out.println("<0> Return\n");
		for (int i = 0; i < flightArray.size(); i++)
		{
			System.out.println("<" + (i+1) + ">");
			System.out.println(flightArray.get(i));
			System.out.println();
		}
	}
	
	public static void printCities()
	{
		if (!cityArray.isEmpty())
		{
			cityArray.clear();
		}
		HashSet<String> citySet = new HashSet<>();
		for (Flight aFlight : flights)
		{
			citySet.add(aFlight.getStartCity());
		}
		for (String str : citySet)
		{
			cityArray.add(str);
		}
		System.out.println("\nAvailable start cities are listed below");
		System.out.println("---------------------------------------");
		System.out.println("<0> Exit");
		for (int i = 0; i < cityArray.size(); i++)
		{
			System.out.println("<" + (i+1) + "> " + cityArray.get(i));
		}
		System.out.println();
	}
	
	public static void randomFillSeats(SeatMap seats)
	{
		Random rand = new Random();
		for (int i = 0; i < 50; i++)
		{
			seats.getSeat(rand.nextInt(seats.getNumOfRows())+1, (char)(Character.valueOf('A')+rand.nextInt(seats.getNumOfColumns()))).reserveSeat();
		}
	}
	
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
