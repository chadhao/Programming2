/**
 *
 * @author Chad
 */
public class Film {
    private String title;
    private String year;
    private Genre[] genres;
    private Rating rating;
    private int[] directors;
    private int[] casts;
    
    public Film(String title, String year, Genre[] genres, Rating rating, int[] directors, int[] casts) {
	this.title = title;
	this.year = year;
	this.genres = genres;
	this.rating = rating;
	this.directors = directors;
	this.casts = casts;
    }
    
    public String toString() {
	String[] directorList = FilmDatabase.directorsList.getName(directors);
	String[] castList = FilmDatabase.castsList.getName(casts);
	String film = this.title + "|" + this.year + "|";
	for (int i = 0; i < genres.length; i++) {
	    film += genres[i].getGenre() + (i==genres.length-1?"|":",");
	}
	film += this.rating.getRating() + "|";
	for (int i = 0; i < directorList.length; i++) {
	    film += directorList[i] + (i==directorList.length-1?"|":",");
	}
	for (int i = 0; i < castList.length; i++) {
	    film += castList[i] + (i==castList.length-1?"":",");
	}
	
	return film;
    }
}
