import java.util.Scanner;

public class CinemaTicketBookingApplication
{
	private static Scanner keyboard = new Scanner(System.in);
	static final int NUMBER_OF_FILMS = 4;
	private static Film[] film = new Film[NUMBER_OF_FILMS];
	
	public static void main(String[] args)
	{
		film[0] = new Film("Ant-Man", Rating.P);
		film[1] = new Film("Minions", Rating.P);
		film[2] = new Film("Jurassic World", Rating.M);
		film[3] = new Film("Inside Out", Rating.G);
		
		while (true)
		{
			Customer customer = customerDetailsInput();
			Film oneFilm = filmSelection();
			Ticket ticket = issueTicket(customer, oneFilm);
			System.out.println(ticket == null?"Sorry, cannot issue ticket for age restricted film!":ticket);
			System.out.println("Issue another ticket? (Y/N)");
			if (keyboard.next().toUpperCase().charAt(0) != 'Y')
			{
				System.out.println("Bye!");
				break;
			}
			keyboard.nextLine();
		}
	}
	
	private static Customer customerDetailsInput()
	{
		Customer customer = new Customer();
		System.out.println("Please enter your name:");
		customer.setName(keyboard.nextLine());
		System.out.println("Please enter your age:");
		customer.setAge(keyboard.nextInt());
		System.out.println("Are you a student? (Y/N)");
		customer.setStudent(keyboard.next().toUpperCase().charAt(0) == 'Y');
		return customer;
	}
	
	private static Film filmSelection()
	{
		System.out.println("Which film would you like to watch:");
		for (int i = 0; i < NUMBER_OF_FILMS; i++)
		{
			System.out.println((i+1) + " " + film[i]);
		}
		return film[keyboard.nextInt()-1];
	}
	
	private static Ticket issueTicket(Customer customer, Film film)
	{
		Ticket ticket = new Ticket(customer, film);
		return ticket.getCustomer().getAge() < ticket.getFilm().getRating().getMinimalAge()?null:ticket;
	}

}
