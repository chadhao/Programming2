
public class Course
{
	private String courseName;
	private String courseCode;
	private double coursePoints;
	private Level courseLevel;
	
	public Course(String courseName, String courseCode, double coursePoints, Level courseLevel)
	{
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.coursePoints = coursePoints;
		this.courseLevel = courseLevel;
	}
	
	public Course()
	{
		this.courseName = "UNKNOWN";
		this.courseCode = "UNKNOWN";
		this.coursePoints = 0;
		this.courseLevel = Level.FIVE;
	}
	
	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}
	
	public void setCourseCode(String courseCode)
	{
		if (courseCode.length() != 6)
		{
			this.courseCode = "UNKNOWN";
		}
		else
		{
			this.courseCode = courseCode;
		}
	}
	
	public void setCoursePoints(double coursePoints)
	{
		if (coursePoints != 15 || coursePoints != 45)
		{
			this.coursePoints = 0;
		}
		else
		{
			this.coursePoints = coursePoints;
		}
	}
	
	public void setCourseLevel(Level courseLevel)
	{
		this.courseLevel = courseLevel;
	}
	
	public Level getCourseLevel()
	{
		return courseLevel;
	}
	
	public double getCoursePoints()
	{
		return coursePoints;
	}
	
}
