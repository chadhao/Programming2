
public class DegreeProgram
{
	private String degreeName;
	private Student student;
	private Address address;
	private Course[] courses;
	private int nCourse;
	private final int MAX_COURSE = 24;
	
	public DegreeProgram(String degreeName, Student student, Address address)
	{
		this.degreeName = degreeName;
		this.student = student;
		this.address = address;
		this.courses = new Course[MAX_COURSE];
		this.nCourse = 0;
	}
	
	public DegreeProgram()
	{
		this.degreeName = "UNKNOWN";
		this.student = new Student();
		this.address = new Address();
		this.courses = new Course[MAX_COURSE];
		this.nCourse = 0;
	}
	
	public void addCourse(Course aCourse)
	{
		this.courses[nCourse] = aCourse;
		nCourse++;
	}
	
	public double pointCount(Level aLevel)
	{
		double totalPoints = 0;
		
		for (int i = 0; i < MAX_COURSE; i++)
		{
			if (courses[i].getCourseLevel() == aLevel)
			{
				totalPoints += courses[i].getCoursePoints();
			}
		}
		
		return totalPoints;
	}
	
	public boolean canGraduate()
	{
		boolean canGraduate;
		double totalPoints = 0;
		double levelFivePoints = 0;
		double levelSixPoints = 0;
		double levelSevenPoints = 0;
		
		for (int i = 0; i < MAX_COURSE; i++)
		{
			totalPoints += courses[i].getCoursePoints();
			if (courses[i].getCourseLevel() == Level.FIVE)
			{
				levelFivePoints += courses[i].getCoursePoints();
			}
			else if (courses[i].getCourseLevel() == Level.SIX)
			{
				levelSixPoints += courses[i].getCoursePoints();
			}
			else if (courses[i].getCourseLevel() == Level.SEVEN)
			{
				levelSevenPoints += courses[i].getCoursePoints();
			}
		}
		
		canGraduate = (totalPoints<360||levelFivePoints<120||levelSixPoints<120||levelSevenPoints<120)?false:true;
		return canGraduate;
	}
}
