
public class Person {
	int age;
	double weight;
	boolean student;
	char gender;
	
	public Person(int age, double weight, boolean student, char gender) {
		this.age = age;
		this.weight = weight;
		this.student = student;
		this.gender = gender;
	}
	
	public Person() {
		this.age = 0;
		this.weight = 0.0;
		this.student = false;
		this.gender = 'M';
	}
}
