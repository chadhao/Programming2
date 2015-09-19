import java.util.Scanner;

public class StudentTest {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter student firstname:");
		String firstname = keyboard.next();
		System.out.println("Please enter student lastname:");
		String lastname = keyboard.next();
		System.out.println("Please enter student ID:");
		String studentID = keyboard.next();
		
		System.out.println("Calling 3 parameter constructor:");
		Student studentOne = new Student(firstname, lastname, studentID);
		System.out.println("Student firstname: " + studentOne.firstname + " lastname: " + studentOne.lastname + " ID: " + studentOne.studentID);
		
		System.out.println("Calling 2 parameter constructor:");
		Student studentTwo = new Student(firstname, lastname);
		System.out.println("Student firstname: " + studentTwo.firstname + " lastname: " + studentTwo.lastname + " ID: " + studentTwo.studentID);
	
		System.out.println("Calling zero parameter constructor:");
		Student studentThree = new Student();
		System.out.println("Student firstname: " + studentThree.firstname + " lastname: " + studentThree.lastname + " ID: " + studentThree.studentID);
	}

}
