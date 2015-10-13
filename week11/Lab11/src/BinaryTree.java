import java.util.ArrayList;
import java.util.Iterator;

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
	
	public BinaryTree<T> insert(T element)
	{
		if (element.compareTo(this.data) == 0)
		{
			return this;
		}
		
		if (element.compareTo(this.data) < 0)
		{
			if (this.left == null)
			{
				this.left = new BinaryTree<T>(element);
				return this.left;
			}
			return this.left.insert(element);
		}
		
		if (this.right == null)
		{
			this.right = new BinaryTree<T>(element);
			return this.right;
		}
		return this.right.insert(element);
	}
	
	public BinaryTree<T> search(T element)
	{
		if (element.compareTo(this.data) == 0)
		{
			return this;
		}
		
		if (element.compareTo(this.data) < 0)
		{
			if (this.left == null)
			{
				return null;
			}
			else
			{
				return this.left.search(element);
			}
		}
		
		if (this.right == null)
		{
			return null;
		}
		else
		{
			return this.right.search(element);
		}
	}
	
	public void insertAll(ArrayList<T> array)
	{
		Iterator<T> it = array.iterator();
		while (it.hasNext())
		{
			T element = it.next();
			if (search(element) != null)
			{
				continue;
			}
			insert(element);
		}
	}
}
