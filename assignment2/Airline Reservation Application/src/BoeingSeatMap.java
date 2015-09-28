
public class BoeingSeatMap extends SeatMap
{
	public BoeingSeatMap()
	{
		setNumOfRows(10);
		setNumOfColumns(7);
		setNumOfFirstClass(4);
		setAircraftModel("Boeing");
		setSeatMap(new Seat[10][7]);
		initialiseSeatMap();
	}
	
	protected void initialiseSeatMap()
	{
		for (int i = 0; i < getNumOfRows(); i++)
		{
			for (int j = 0; j < getNumOfColumns(); j++)
			{
				if (j == 3)
				{
					setASeat(i, j, new Seat(new SeatPosition(i+1, (char)('A' + j)), SeatType.M, (i<getNumOfFirstClass()?true:false)));
				}
				else if (j == 0 || j == 6)
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
