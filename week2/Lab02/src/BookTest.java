import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int numberOfBooks;
		
		System.out.print("How many books do you want to input: ");
		numberOfBooks = keyboard.nextInt();
		
		Book[] oneBook = new Book[numberOfBooks];
		
		for (int i = 0; i < numberOfBooks; i++)
		{
			oneBook[i] = new Book();
			System.out.println("Please enter the title of the book");
			oneBook[i].title = keyboard.next();
			System.out.println("Please enter the author name");
			oneBook[i].author = keyboard.next();
			while (true)
			{
				System.out.println("Please enter the number of pages");
				oneBook[i].numberOfPages = keyboard.nextInt();
				if (oneBook[i].numberOfPages > 0)
				{
					break;
				}
			}
			System.out.println("");
		}
		
		for (int j = numberOfBooks-1; j >= 0; j--)
		{
			System.out.println(oneBook[j].title);
		}
		
	}

}
