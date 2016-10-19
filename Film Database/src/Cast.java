
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author Chad
 */
public class Cast {
    private static ArrayList<String> casts;
    
    static {
	Cast.casts = new ArrayList<>();
    }
    
    public static void init(ArrayList<String> casts) {
	Cast.casts = new ArrayList<>(new HashSet<String>(casts));
    }
    
    public static String getCast(int index) {
	return Cast.casts.get(index);
    }
    
    public static String[] getCasts(int[] index) {
	String[] film_casts = new String[index.length];
	for (int i = 0; i < index.length; i++) {
	    film_casts[i] = Cast.casts.get(index[i]);
	}
	return film_casts;
    }
    
    public static void addCast(String name) {
	if (!Cast.contains(name)) {
	    Cast.casts.add(name);
	}
    }
    
    public static boolean contains(String name) {
	Iterator<String> it = Cast.casts.iterator();
	while (it.hasNext()) {
	    if (it.next().equalsIgnoreCase(name)) {
		return true;
	    }
	}
	return false;
    }
}
