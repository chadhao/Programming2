
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author Chad
 */
public class NameList {
    private ArrayList<String> names;
        
    public NameList(ArrayList<String> names) {
	this.names = new ArrayList<>(new HashSet<>(names));
    }
    
    public String[] getName(int[] index) {
	String[] name_list = new String[index.length];
	for (int i = 0; i < index.length; i++) {
	    if (index[i] >= this.names.size() || index[i] < 0) {
		return null;
	    }
	    name_list[i] = this.names.get(index[i]);
	}
	return name_list;
    }
    
    public int[] getDirectorList(String[] name) {
	int[] name_index_list = new int[name.length];
	for (int i = 0; i < name.length; i++) {
	    name_index_list[i] = contains(name[i]);
	    if (name_index_list[i] == -1) {
		return null;
	    }
	}
	return name_index_list;
    }
    
    public void addDirector(String[] name) {
	for (String one_name : name) {
	    if (contains(one_name) == -1) {
		this.names.add(Utils.formatName(one_name));
	    }
	}
    }
    
    public int contains(String name) {
	Iterator<String> it = this.names.iterator();
	while (it.hasNext()) {
	    String one_name = it.next();
	    if (one_name.equalsIgnoreCase(name)) {
		return this.names.indexOf(one_name);
	    }
	}
	return -1;
    }
    
}
