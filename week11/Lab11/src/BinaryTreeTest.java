
public class BinaryTreeTest
{

	public static void main(String[] args)
	{
		BinaryTree<Integer> aTree = new BinaryTree<Integer>(4);
		aTree.insert(3);
		aTree.insert(6);
		aTree.insert(2);
		
		BinaryTree<String> nameTree = new BinaryTree<String>("Bob");
		nameTree.insert("Alice");
		nameTree.insert("Carl");
	}

}
