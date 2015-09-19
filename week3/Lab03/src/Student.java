
public class Student {
	private String firstname;
	private String lastname;
	private String studentID;
	private SimpleDate enrolDate;
	
	public Student(String firstName, String lastName, String ID, SimpleDate aDate)
	{
		this.firstname = firstName;
		this.lastname = lastName;
		this.studentID = ID;
		this.enrolDate = aDate;
	}
	
	public Student(String firstname, String lastname, String studentID)
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.studentID = studentID;
		this.enrolDate = new SimpleDate();
	}
	
	public Student(String studentID)
	{
		this.firstname = "";
		this.lastname = "";
		this.studentID = studentID;
		this.enrolDate = new SimpleDate();
	}
	
	public String toString()
	{
		return "Student's first name: " + this.firstname + ", last name: " + this.lastname + ", ID: " + this.studentID;
	}
	
	public String getFirstname()
	{
		return this.firstname;
	}
	
	public String getLastname()
	{
		return this.lastname;
	}
	
	public String getStudentID()
	{
		return this.studentID;
	}
	
	public SimpleDate getEnrolDate()
	{
		return this.enrolDate;
	}
	
	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}
	
	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}
	
	public void setStudentID(String studentID)
	{
		this.studentID = studentID;
	}
	
	public void setEnrolDate(SimpleDate enrolDate)
	{
		this.enrolDate = enrolDate;
	}
}
