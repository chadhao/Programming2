
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
	}
}
