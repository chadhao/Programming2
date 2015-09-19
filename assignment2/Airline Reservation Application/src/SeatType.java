
public enum SeatType
{
	A("AISLE"), M("MIDDLE"), W("WINDOW");
	
	private String typeName;
	
	private SeatType(String typeName)
	{
		this.typeName = typeName;
	}
	
	public String getTypeName()
	{
		return typeName;
	}
}
