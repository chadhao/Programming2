
public class Film {
	private String title;
	private Rating rating;
	
	public Film(String title, Rating rating)
	{
		this.title = title;
		this.rating = rating;
	}
	
	public Film()
	{
		this.title = "UNKNOWN";
		this.rating = Rating.G;
	}
	
	public String toString()
	{
		return this.title+"("+this.rating+")";
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public void setRating(Rating rating)
	{
		this.rating = rating;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public Rating getRating()
	{
		return this.rating;
	}
}
