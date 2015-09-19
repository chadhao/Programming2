
public class Student {
	String firstname;
	String lastname;
	String studentID;
	
	public Student(String firstname, String lastname, String studentID) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.studentID = studentID;
	}
	
	public Student() {
		this.firstname = "UNKNOWN";
		this.lastname = "UNKNOWN";
		this.studentID = "UNKNOWN";
	}
}
