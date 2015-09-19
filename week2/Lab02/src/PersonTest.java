import java.util.Scanner;

public class PersonTest {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int age;
		double weight;
		boolean student;
		char gender;
		int discount = 0;
		
		System.out.println("Please enter the person's age:");
		age = keyboard.nextInt();
		System.out.println("Please enter the person's weight:");
		weight = keyboard.nextDouble();
		System.out.println("Is the person a student (true/false):");
		student = keyboard.nextBoolean();
		System.out.println("Please enter the person's gender (M/F):");
		gender = keyboard.next().charAt(0);
		
		Person onePerson = new Person(age, weight, student, gender);
		
		if (onePerson.age >= 65)
		{
			discount = (discount < 100)?100:discount;
		}
		else if (onePerson.gender == 'F' && onePerson.student && onePerson.age >= 40)
		{
			discount = (discount < 75)?75:discount;
		}
		else if (onePerson.student && onePerson.age >= 10 && onePerson.age <= 20)
		{
			discount = (discount < 50)?50:discount;
		}
		else if ((int)onePerson.weight % 2 == 0)
		{
			discount = (discount < 25)?25:discount;
		}
		else if ((int)onePerson.weight % 2 == 1)
		{
			discount = (discount < 15)?15:discount;
		}
		
		System.out.println("Person: age: " + onePerson.age + " weight: " + onePerson.weight + " student: " + onePerson.student + " gender: " + onePerson.gender);
		System.out.println("This person's bus Discount is " + discount + "%");
	}

}
