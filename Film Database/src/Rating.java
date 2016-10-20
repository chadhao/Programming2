/**
 *
 * @author Chad
 */
public enum Rating {
    ONE("★☆☆☆☆", 1),
    TWO("★★☆☆☆", 2),
    THREE("★★★☆☆", 3),
    FOUR("★★★★☆", 4),
    FIVE("★★★★★", 5);
    
    private String ratingStar;
    private int rating;
    
    private Rating(String ratingStar, int rating) {
	this.rating = rating;
	this.ratingStar = ratingStar;
    }
    
    public int getRating() {
	return this.rating;
    }
    
    public String getRatingStar() {
	return this.ratingStar;
    }
}
