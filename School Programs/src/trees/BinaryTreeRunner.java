package trees;

public class BinaryTreeRunner 
{
	public static void main(String[] args)
	{
		BinaryTree empty = new BinaryTree();
		
		BinaryTree g = new BinaryTree("G", empty, empty);
		BinaryTree f = new BinaryTree("F", empty, empty);
		BinaryTree e = new BinaryTree("E", empty, empty);
		BinaryTree d = new BinaryTree("D", empty, empty);
		BinaryTree c = new BinaryTree("C", f, g);
		BinaryTree b = new BinaryTree("B", d, e);
		BinaryTree a = new BinaryTree("A", b, c);
		
		System.out.print(a);
	}
}
