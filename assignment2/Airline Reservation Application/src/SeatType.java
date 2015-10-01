
public enum SeatType
{
	A("AISLE"), M("MIDDLE"), W("WINDOW");
	
	private String typeName;
	
	private SeatType(String typeName)
	{
		this.typeName = typeName;
	}
	
	/**
	 * Returns the full name of a seat type. 
	 *
	 * @return  the full seat type name
	 */
	public String getTypeName()
	{
		return typeName;
	}
}
