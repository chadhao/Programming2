
public class Customer
{
	private String name;
	private int age;
	private boolean student;
	
	public Customer(String name, int age, boolean student)
	{
		setName(name);
		setAge(age);
		setStudent(student);
	}
	
	public Customer()
	{
		setName("UNKNOWN");
		setAge(0);
		setStudent(false);
	}
	
	public String toString()
	{
		return "CUSTOMER DETAILS: "+getName()+", Age: "+getAge()+", Student: "+(getStudent()?"Yes":"No");
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setAge(int age)
	{
		this.age = (age > 0)?age:0;
	}
	
	public void setStudent(boolean student)
	{
		this.student = student;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getAge()
	{
		return this.age;
	}
	
	public boolean getStudent()
	{
		return this.student;
	}
}
