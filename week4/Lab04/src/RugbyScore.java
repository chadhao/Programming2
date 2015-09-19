
public class RugbyScore {
	private int score;
	private String teamName;
	
	public RugbyScore(String teamName)
	{
		this.teamName = teamName;
		this.score = 0;
	}
	
	public RugbyScore()
	{
		this.teamName = "";
		this.score = 0;
	}
	
	public String toString()
	{
		return this.teamName + " score: " + this.score;
	}
	
	public void score(ScoreAction scoreAction)
	{
		this.score += scoreAction.getScore();
	}
	
	public int getScore()
	{
		return this.score;
	}
	
	public String getTeamName()
	{
		return this.teamName;
	}
}
