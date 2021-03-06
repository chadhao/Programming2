
/**
 * This class represents an Airbus airplane seatmap
 * 
 * @author Duan Hao
 *
 */
public class AirBusSeatMap extends SeatMap
{
	public AirBusSeatMap()
	{
		setNumOfRows(12);
		setNumOfColumns(9);
		setNumOfFirstClass(6);
		setAircraftModel("Airbus");
		setSeatMap(new Seat[12][9]);
		initialiseSeatMap();
	}
	
	/**
	 * @see SeatMap#initialiseSeatMap()
	 */
	protected void initialiseSeatMap()
	{
		for (int i = 0; i < getNumOfRows(); i++)
		{
			for (int j = 0; j < getNumOfColumns(); j++)
			{
				if (j == 1 || j == 4 || j == 7)
				{
					setASeat(i, j, new Seat(new SeatPosition(i+1, (char)('A' + j)), SeatType.M, (i<getNumOfFirstClass()?true:false)));
				}
				else if (j == 0 || j == 8)
				{
					setASeat(i, j, new Seat(new SeatPosition(i+1, (char)('A' + j)), SeatType.W, (i<getNumOfFirstClass()?true:false)));
				}
				else
				{
					setASeat(i, j, new Seat(new SeatPosition(i+1, (char)('A' + j)), SeatType.A, (i<getNumOfFirstClass()?true:false)));
				}
			}
		}
		
	}
}
