
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author Chad
 */
public class Director {
    private static ArrayList<String> directors;
    
    static {
	Director.directors = new ArrayList<>();
    }
    
    public static void init(ArrayList<String> directors) {
	Director.directors = new ArrayList<>(new HashSet<>(directors));
    }
    
    public static String getDirector(int index) {
	return Director.directors.get(index);
    }
    
    public static String[] getDirectors(int[] index) {
	String[] film_directors = new String[index.length];
	for (int i = 0; i < index.length; i++) {
	    film_directors[i] = Director.directors.get(index[i]);
	}
	return film_directors;
    }
    
    public static void addDirector(String name) {
	if (!Director.contains(name)) {
	    Director.directors.add(name);
	}
    }
    
    public static boolean contains(String name) {
	Iterator<String> it = Director.directors.iterator();
	while (it.hasNext()) {
	    if (it.next().equalsIgnoreCase(name)) {
		return true;
	    }
	}
	return false;
    }
    
}
