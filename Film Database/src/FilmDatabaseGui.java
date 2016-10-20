/**
 *
 * @author Chad
 */
public class FilmDatabaseGui {
    public static void main(String[] args) {
	String[] directors = {"wen jiang"};
	String[] casts = {"yun-fat chow", "wen jiang", "you ge"};
	Genre[] genres = {Genre.ACTION, Genre.COMEDY, Genre.WESTERN};
	FilmDatabase.directorsList.addName(directors);
	FilmDatabase.castsList.addName(casts);
	Film aFilm = new Film(
		"Let the Bullets Fly",
		"2010",
		genres,
		Rating.FOUR,
		FilmDatabase.directorsList.getNameList(directors),
		FilmDatabase.castsList.getNameList(casts)
	);
	FilmDatabase.films.add(aFilm);
	
	System.out.println(FilmDatabase.listAllFilms());
    }
}
