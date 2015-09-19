
public class ScoreTable
{
	public static final int MAX_PLAY = 3;
	public static final int MAX_SCORE = 4;
	private Score[][] scoreTable;
	
	public ScoreTable()
	{
		this.scoreTable = new Score[MAX_PLAY][MAX_SCORE];
	}
	
	public String toString()
	{
		String scoreTableString = "        | Score 0  Score 1  Score 2  Score 3\n"
				+ "--------|-----------------------------------\n";
		for (int r = 0; r < MAX_PLAY; r++)
		{
			scoreTableString += "Player " + r + "|   ";
			for (int c = 0; c < MAX_SCORE; c++)
			{
				scoreTableString += this.scoreTable[r][c].getScore() + "      ";
			}
			scoreTableString += "\n";
		}
		return scoreTableString;
	}
	
	public void update(int row, int column, Score aScore)
	{
		if (row >=0 && row < MAX_PLAY && column >= 0 && column < MAX_SCORE)
		{
			this.scoreTable[row][column] = aScore;
		}
	}
	
	public Score highestScore()
	{
		Score highScore = this.scoreTable[0][0];
		for (Score[] scores: this.scoreTable)
		{
			for (Score aScore: scores)
			{
				highScore = (aScore.getScore() > highScore.getScore())?aScore:highScore;
			}
		}
		return highScore;
	}
}
