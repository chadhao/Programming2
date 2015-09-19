import java.util.Scanner;

public class BookInputTest {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Book oneBook = new Book();
		
		System.out.println("Please enter the title of the book");
		oneBook.title = keyboard.next();
		System.out.println("Please enter the author name");
		oneBook.author = keyboard.next();
		
		while (true)
		{
			System.out.println("Please enter the number of pages");
			oneBook.numberOfPages = keyboard.nextInt();
			if (oneBook.numberOfPages > 0)
			{
				break;
			}
		}
		
		
		System.out.println("The book title is: " + oneBook.title);
		System.out.println("The book author is: " + oneBook.author);
		System.out.println("The book has: " + oneBook.numberOfPages + " pages");
	}

}
