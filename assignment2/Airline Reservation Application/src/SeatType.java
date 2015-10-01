/**
 * This is an enum class which stores different seat types of a flight.
 * 
 * @author      Duan Hao
 */
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
