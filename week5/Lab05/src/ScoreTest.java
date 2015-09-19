
public class ScoreTest
{

	public static void main(String[] args)
	{
		Score s1 = new Score("Ken Johnson", 910);
		Score s2 = new Score("Steffan Hopper", 1000);
		Score s3 = new Score("Bobby Pinns", 599);
		Score s4 = new Score("Hugh Jarms", 321);
		Score s5 = new Score("Justin Case", 672);
		
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s3);
//		System.out.println(s4);
//		System.out.println(s5);
		
		ScoreBoard sb = new ScoreBoard();
		
		sb.add(s1);
		sb.add(s2);
		sb.add(s3);
		sb.add(s4);
		sb.add(s5);
		
		System.out.println(sb);
	}

}
