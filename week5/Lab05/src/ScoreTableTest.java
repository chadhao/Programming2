import java.util.Random;

public class ScoreTableTest
{
	public static int randScore()
	{
		int min = 100;
		int max = 999;
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}
	
	public static void main(String[] args)
	{
		ScoreTable st = new ScoreTable();
		for (int r = 0; r < ScoreTable.MAX_PLAY; r++)
		{
			for (int c = 0; c < ScoreTable.MAX_SCORE; c++)
			{
				Score score = new Score("Player" + r, randScore());
				st.update(r, c, score);
			}
		}
		
		System.out.println(st);
		System.out.println(st.highestScore());
	}

}
