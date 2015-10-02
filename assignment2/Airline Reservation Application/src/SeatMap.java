
/**
 * This class stores seats information on a flight.
 * It also provides method on accessing and mutating its state.
 * 
 * @author Duan Hao
 *
 */
public abstract class SeatMap
{
	private Seat[][] seatMap;
	private int numOfRows;
	private int numOfColumns;
	private int numOfFirstClass;
	private String aircraftModel;
	
	@Override
	public String toString()
	{
		String aString = "   |";
		String seperateLine = "\n---|";
		for (int i = 0; i < numOfColumns; i++)
		{
			aString += "   " + (char)('A'+i) + "  |";
			seperateLine += "------|";
		}
		seperateLine += "\n";
		aString += seperateLine;
		for (int i = 0; i < numOfRows; i++)
		{
			aString += (i+1) + (i<9?"  | ":" | ");
			for (int j = 0; j < numOfColumns; j++)
			{
				aString += seatMap[i][j] + " | ";
			}
			aString += seperateLine;
		}
		return aString;
	}

	/**
	 * This method is used by sub classes to initialise seatmaps.
	 */
	protected abstract void initialiseSeatMap();
	
	/**
	 * @return a 2D array of Seat objects
	 */
	public Seat[][] getSeatMap()
	{
		return seatMap;
	}
	
	/**
	 * @return number of rows in this SeatMap
	 */
	public int getNumOfRows()
	{
		return numOfRows;
	}
	
	/**
	 * @return number of columns in this SeatMap
	 */
	public int getNumOfColumns()
	{
		return numOfColumns;
	}
	
	/**
	 * @return number of rows in First Class in this SeatMap
	 */
	public int getNumOfFirstClass()
	{
		return numOfFirstClass;
	}
	
	/**
	 * @return aircraft model name
	 */
	public String getAircraftModel()
	{
		return aircraftModel;
	}
	
	/**
	 * @param seatMap a 2D array of Seat objects
	 */
	protected void setSeatMap(Seat[][] seatMap)
	{
		this.seatMap = seatMap;
	}
	
	/**
	 * @param numOfRows number of rows in this SeatMap
	 */
	protected void setNumOfRows(int numOfRows)
	{
		this.numOfRows = numOfRows;
	}
	
	/**
	 * @param numOfColumns number of columns in this SeatMap
	 */
	protected void setNumOfColumns(int numOfColumns)
	{
		this.numOfColumns = numOfColumns;
	}
	
	/**
	 * @param numOfFirstClass number of rows in First Class in this SeatMap
	 */
	protected void setNumOfFirstClass(int numOfFirstClass)
	{
		this.numOfFirstClass = numOfFirstClass;
	}
	
	/**
	 * Assign a Seat object to a specific position in the seatmap
	 * 
	 * @param row a specific row
	 * @param column a specific column
	 * @param aSeat a Seat object
	 */
	protected void setASeat(int row, int column, Seat aSeat)
	{
		this.seatMap[row][column] = aSeat;
	}
	
	/**
	 * @param aircraftModel aircraft model name
	 */
	protected void setAircraftModel(String aircraftModel)
	{
		this.aircraftModel = aircraftModel;
	}
	
	/**
	 * @return an integer representing the last row of this seatmap
	 */
	public int lastRow()
	{
		return numOfRows;
	}
	
	/**
	 * @return a character representing the last column of this seatmap
	 */
	public char lastColumn()
	{
		return (char)('A' + (numOfColumns - 1));
	}
	
	/**
	 * Get a Seat object in a specific position
	 * 
	 * @param row a specific row
	 * @param column a specific column
	 * @return a Seat object in provided position
	 */
	public Seat getSeat(int row, char column)
	{
		return seatMap[row-1][column - 'A'];
	}
	
	/**
	 * @param originSeat seat to search from
	 * @return the seat on left side of the original seat
	 */
	public Seat getLeft(Seat originSeat)
	{
		return (originSeat.getPosition().getColumn() - 'A' - 1) >= 0?seatMap[originSeat.getPosition().getRow() - 1][originSeat.getPosition().getColumn() - 'A' - 1]:null;
	}
	
	/**
	 * @param originSeat seat to search from
	 * @return the seat on right side of the original seat
	 */
	public Seat getRight(Seat originSeat)
	{
		return (originSeat.getPosition().getColumn() - 'A' + 1) < numOfColumns?seatMap[originSeat.getPosition().getRow() - 1][originSeat.getPosition().getColumn() - 'A' + 1]:null;
	}
	
	/**
	 * This method provides means to search seatmap based on some conditions.
	 * 
	 * @param typedSearch whether this search need to specify a SeatType
	 * @param beginRow starting row of this search
	 * @param endRow ending row of this search
	 * @param seatType a specific seat type
	 * @return a Seat object based on the searching criteria provided in parameters
	 */
	private Seat searchAvailableSeat(boolean typedSearch, int beginRow, int endRow, SeatType seatType)
	{
		Seat aSeat = null;
		for (int i = beginRow; i < endRow; i++)
		{
			for (int j = 0; j < numOfColumns; j++)
			{
				if (typedSearch)
				{
					if (!seatMap[i][j].isReserved() && seatMap[i][j].getType() == seatType)
					{
						aSeat = seatMap[i][j];
						break;
					}
				}
				else
				{
					if (!seatMap[i][j].isReserved())
					{
						aSeat = seatMap[i][j];
						break;
					}
				}
			}
			if (aSeat != null)
			{
				break;
			}
		}
		return aSeat;
	}
	
	/**
	 * @param seatType a specific seat type
	 * @return a Seat object in Economy class or <code>null</code> if no seats found
	 */
	public Seat queryAvailableEconomySeat(SeatType seatType)
	{
		Seat aSeat = searchAvailableSeat(true, numOfFirstClass, numOfRows, seatType);
		return aSeat == null?searchAvailableSeat(false, numOfFirstClass, numOfRows, seatType):aSeat;
	}
	
	/**
	 * @param seatType a specific seat type
	 * @return a Seat object in First class or <code>null</code> if no seats found
	 */
	public Seat queryAvailableFirstClassSeat(SeatType seatType)
	{
		Seat aSeat = searchAvailableSeat(true, 0, numOfFirstClass, seatType);
		return aSeat == null?searchAvailableSeat(false, 0, numOfFirstClass, seatType):aSeat;
	}
}
