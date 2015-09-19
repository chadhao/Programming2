
public enum Rating
{
	G(0), P(12), M(16);
	
	private int minimalAge;
	
	private Rating(int minimalAge)
	{
		this.minimalAge = minimalAge;
	}
	
	public int getMinimalAge()
	{
		return minimalAge;
	}
}
