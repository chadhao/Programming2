
public class SeatPosition
{
	private int row;
	private char column;
	
	public SeatPosition(int row, char column)
	{
		this.row = row;
		this.column = column;
	}
	
	@Override
	public String toString()
	{
		return Integer.toString(row)+column;
	}
	
	public int getRow()
	{
		return row;
	}
	
	public char getColumn()
	{
		return column;
	}
}
