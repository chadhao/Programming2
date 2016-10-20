
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Chad
 */
public class FilmDatabase {
    public static NameList directorsList;
    public static NameList castsList;
    public static ArrayList<Film> films;
    
    static {
	FilmDatabase.directorsList = new NameList();
	FilmDatabase.castsList = new NameList();
	FilmDatabase.films = new ArrayList<>();
    }
    
    public static String listAllFilms() {
	String all_films = "";
	Iterator it = FilmDatabase.films.iterator();
	while (it.hasNext()) {
	    all_films += it.next().toString() + (it.hasNext()?"\n":"");
	}
	return all_films;
    }
}
