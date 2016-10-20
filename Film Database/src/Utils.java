/**
 *
 * @author Chad
 */
public class Utils {
    public static String formatName(String name) {
	String[] name_split = name.split(" ");
	String name_formatted = "";
	for (int i = 0; i < name_split.length; i++) {
	    name_formatted += Character.toUpperCase(name_split[i].charAt(0))
		    + name_split[i].substring(1) + (i==name_split.length-1?"":" ");
	}
	return name_formatted;
    }
}
