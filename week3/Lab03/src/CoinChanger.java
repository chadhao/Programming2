
public class CoinChanger
{
	private int ten;
	private int twenty;
	private int fifty;
	private int oneDollar;
	private int twoDollar;
	
	public CoinChanger(int ten, int twenty, int fifty, int oneDollar, int twoDollar)
	{
		this.ten = ten;
		this.twenty = twenty;
		this.fifty = fifty;
		this.oneDollar = oneDollar;
		this.twoDollar = twoDollar;
	}
	
	public String toString()
	{
		return "10c: "+this.ten+", 20c:"+this.twenty+", 50c:"+this.fifty+", $1:"+this.oneDollar+", $2:"+this.twoDollar;
	}
	
	public int getTen()
	{
		return this.ten;
	}
	
	public int getTwenty()
	{
		return this.twenty;
	}
	
	public int getFifty()
	{
		return this.fifty;
	}
	
	public int getOneDollar()
	{
		return this.oneDollar;
	}
	
	public int getTwoDollar()
	{
		return this.twoDollar;
	}
	
	private int findCentsValue()
	{
		int totalCents = this.ten*10 + this.twenty*20 + this.fifty*50 + this.oneDollar*100 + this.twoDollar*200;
		return totalCents;
	}
	
	public int findDollars()
	{
		return findCentsValue()/100;
	}
	
	public int findChange()
	{
		return findCentsValue()%100;
	}
}
