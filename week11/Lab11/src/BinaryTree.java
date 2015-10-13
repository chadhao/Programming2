
public class BinaryTree<T extends Comparable<T>>
{
	private T data;
	private BinaryTree<T> left;
	private BinaryTree<T> right;
	
	public BinaryTree(T data)
	{
		this.data = data;
	}
	
	@Override
	public String toString()
	{
		return data.toString();
	}
}
