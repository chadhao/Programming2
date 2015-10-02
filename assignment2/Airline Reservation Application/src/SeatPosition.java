
/**
 * This class defines position of a seat in seatmap.
 * 
 * @author Duan Hao
 *
 */
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
	
	/**
	 * @return row of a seat
	 */
	public int getRow()
	{
		return row;
	}
	
	/**
	 * @return column of a seat
	 */
	public char getColumn()
	{
		return column;
	}
}
