
public class ScoreBoard
{
	public static final int MAX_SCORE = 5;
	private Score[] scores;
	
	public ScoreBoard()
	{
		this.scores = new Score[MAX_SCORE];
	}
	
	public String toString()
	{
		String scoresString = "";
		for (int i = 0; i < this.scores.length; i++)
		{
			if (this.scores[i] != null)
			{
				scoresString += this.scores[i] + "\n";
			}
		}
		return scoresString;
	}
	
	public void update(int index, Score score)
	{
		if (index >= 0 && index < this.scores.length)
		{
			this.scores[index] = score;
		}
	}
	
	public boolean add(Score score)
	{
		boolean added = false;
		for (int i = 0; i < this.scores.length; i++)
		{
			if (this.scores[i] == null)
			{
				this.scores[i] = score;
				added = true;
				break;
			}
		}
		return added;
	}
	
	public void remove(int index)
	{
		update(index, null);
	}
	
	public Score findScore(int score)
	{
		Score aScore = null;
		for (int i = 0; i < this.scores.length; i++)
		{
			if (this.scores[i].getScore() == score)
			{
				aScore = this.scores[i];
				break;
			}
		}
		return aScore;
	}
	
	public Score highScore()
	{
		int highScore = this.scores[0].getScore();
		int highScoreIndex = 0;
		for (int i = 1; i < this.scores.length; i++)
		{
			if (this.scores[i].getScore() > highScore)
			{
				highScore = this.scores[i].getScore();
				highScoreIndex = i;
			}
		}
		return this.scores[highScoreIndex];
	}
}
