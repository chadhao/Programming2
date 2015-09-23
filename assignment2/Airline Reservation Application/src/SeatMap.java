
public abstract class SeatMap
{
	private Seat[][] seatMap;
	private int numOfRows;
	private int numOfColumns;
	private int numOfFirstClass;
	
	@Override
	public String toString()
	{
		String aString = "   |";
		String seperateLine = "\n---|";
		for (int i = 0; i < numOfColumns; i++)
		{
			aString += "   " + (char)(Character.valueOf('A')+i) + "  |";
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

	protected abstract void initialiseSeatMap();
	
	public Seat[][] getSeatMap()
	{
		return seatMap;
	}
	
	public int getNumOfRows()
	{
		return numOfRows;
	}
	
	public int getNumOfColumns()
	{
		return numOfColumns;
	}
	
	public int getNumOfFirstClass()
	{
		return numOfFirstClass;
	}
	
	protected void setSeatMap(Seat[][] seatMap)
	{
		this.seatMap = seatMap;
	}
	
	protected void setNumOfRows(int numOfRows)
	{
		this.numOfRows = numOfRows;
	}
	
	protected void setNumOfColumns(int numOfColumns)
	{
		this.numOfColumns = numOfColumns;
	}
	
	protected void setNumOfFirstClass(int numOfFirstClass)
	{
		this.numOfFirstClass = numOfFirstClass;
	}
	
	protected void setASeat(int row, int column, Seat aSeat)
	{
		this.seatMap[row][column] = aSeat;
	}
	
	public int lastRow()
	{
		return numOfRows+1;
	}
	
	public char lastColumn()
	{
		return (char)(Character.valueOf('A') + (numOfColumns-1));
	}
	
	public Seat getSeat(int row, char column)
	{
		return seatMap[row-1][Character.valueOf(column) - Character.valueOf('A')];
	}
	
	public Seat getLeft(Seat originSeat)
	{
		/*
		int row = originSeat.getPosition().getRow() - 1;
		int column = Character.valueOf(originSeat.getPosition().getColumn()) - Character.valueOf('A') - 1;
		Seat aSeat = column >= 0?seatMap[row][column]:null;
		*/
		return (Character.valueOf(originSeat.getPosition().getColumn()) - Character.valueOf('A') - 1) >= 0?seatMap[originSeat.getPosition().getRow() - 1][Character.valueOf(originSeat.getPosition().getColumn()) - Character.valueOf('A') - 1]:null;
	}
	
	public Seat getRight(Seat originSeat)
	{
		/*
		int row = originSeat.getPosition().getRow() - 1;
		int column = Character.valueOf(originSeat.getPosition().getColumn()) - Character.valueOf('A') + 1;
		Seat aSeat = column < numOfColumns?seatMap[row][column]:null;
		*/
		return (Character.valueOf(originSeat.getPosition().getColumn()) - Character.valueOf('A') + 1) < numOfColumns?seatMap[originSeat.getPosition().getRow() - 1][Character.valueOf(originSeat.getPosition().getColumn()) - Character.valueOf('A') + 1]:null;
	}
	
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
	
	public Seat queryAvailableEconomySeat(SeatType seatType)
	{
		Seat aSeat = searchAvailableSeat(true, numOfFirstClass, numOfRows, seatType);
		return aSeat == null?searchAvailableSeat(false, numOfFirstClass, numOfRows, seatType):aSeat;
	}
	
	public Seat queryAvailableFirstClassSeat(SeatType seatType)
	{
		Seat aSeat = searchAvailableSeat(true, 0, numOfFirstClass, seatType);
		return aSeat == null?searchAvailableSeat(false, 0, numOfFirstClass, seatType):aSeat;
	}
}
