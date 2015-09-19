
public class RugbyMatch
{
	private RugbyScore home;
	private RugbyScore opposition;
	private boolean finished;
	
	public RugbyMatch(RugbyScore home, RugbyScore opposition)
	{
		this.home = home;
		this.opposition = opposition;
		this.finished = false;
	}
	
	public RugbyMatch()
	{
		this.home = new RugbyScore();
		this.opposition = new RugbyScore();
		this.finished = false;
	}
	
	public String toString()
	{
		String aString = "";
		
		if (this.home.getScore() == this.opposition.getScore())
		{
			aString = this.home.getTeamName() + " tied with the " + this.opposition.getTeamName() + " " + this.home.getScore() + " points";
		}
		else if (this.isFinished())
		{
			aString = (this.home.getScore()>this.opposition.getScore())?this.home.getTeamName() + " won over " + this.opposition.getTeamName() + " " + this.home.getScore() + " - " + this.opposition.getScore():this.opposition.getTeamName() + " won over " + this.home.getTeamName() + " " + this.opposition.getScore() + " - " + this.home.getScore();
		}
		else
		{
			aString = (this.home.getScore()>this.opposition.getScore())?this.home.getTeamName() + " leading the " + this.opposition.getTeamName() + " " + this.home.getScore() + " - " + this.opposition.getScore():this.opposition.getTeamName() + " leading the " + this.home.getTeamName() + " " + this.opposition.getScore() + " - " + this.home.getScore();
		}
		
		return aString;
	}
	
	public void setFinished(boolean finished)
	{
		this.finished = finished;
	}
	
	public boolean isFinished()
	{
		return this.finished;
	}
	
	public void homeScore(ScoreAction scoreAction)
	{
		this.home.score(scoreAction);
	}
	
	public void oppositionScore(ScoreAction scoreAction)
	{
		this.opposition.score(scoreAction);
	}
	
	public RugbyScore winner()
	{
		return (this.home.getScore()>this.opposition.getScore())?this.home:this.opposition;
	}
}
