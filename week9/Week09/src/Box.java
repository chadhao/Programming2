
public class Box<T> {
	private T contents;

	public Box(T contents)
	{
		this.contents = contents;
	}
	
	@Override
	public String toString()
	{
		return super.toString();
	}
	
	public T getContents()
	{
		return contents;
	}
	
	public void setContents(T contents)
	{
		this.contents = contents;
	}
	
	public static void main(String[] args)
	{
		Box<Integer> a = new Box<Integer>(2);
		Box<Integer> b = new Box<Integer>(4);
		System.out.println(a.getContents()+b.getContents());
		Box<Double> c = new Box<Double>(1.5);
		Box<String> d = new Box<String>("This is a String Box!");
		Box<Box<Integer>> e = new Box<Box<Integer>>(a);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
	}
}
