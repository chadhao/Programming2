
public class Score {
	private String name;
	private int score;
	
	public Score(String name, int score)
	{
		this.name = name;
		this.score = score;
	}
	
	public String toString()
	{
		return this.name + "'s score: " + this.score;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setScore(int score)
	{
		this.score = score;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getScore()
	{
		return score;
	}
}
