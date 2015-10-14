import java.util.*;
import java.util.Map.Entry;

public class Abc
{

	public static void main(String[] args)
	{
		HashMap<Def, String> abc = new HashMap<>();
		Def[] a = new Def[10];
		for (int i = 0; i < 10; i++)
		{
			a[i] = new Def(new Random().nextInt(100));
			abc.put(a[i], Character.toString((char)('A'+i)));
		}
		ArrayList<Entry<Def, String>> anArrayList = new ArrayList<>(abc.entrySet());
		Iterator<Entry<Def, String>> it = abc.entrySet().iterator();
		while (it.hasNext())
		{
			Entry<Def, String> ent = it.next();
			System.out.println(ent.getKey().getA() + "=" + ent.getValue());
		}
	}

}

class Def implements Comparable<Def>
{
	private Integer a;
	
	public Def(int a)
	{
		this.a = a;
	}
	
	@Override
	public int compareTo(Def o)
	{
		return this.a.compareTo(o.a);
	}
	
	public int getA()
	{
		return a;
	}
}