package trees;

public class BinaryTree
{
   private Node root;

   public BinaryTree()
   {
	   root = null;
   }

   public BinaryTree(Object rootData, BinaryTree left, BinaryTree right)
   {
      root = new Node();
      root.data = rootData;
      root.left = left.root;
      root.right = right.root;
   }

   class Node
   {
      public Object data;
      public Node left;
      public Node right;
      
      public String toString()
      {
         if (left == null && right == null)
         {
            return "(" + data + ")";
         }
         else
         {
            String temp = "(" + data;
            
            if(left != null)
            { 
               temp = temp + left.toString();
            }
            
            if(right != null)
            { 
               temp = temp + right.toString();
            }
            
            return temp = temp + ")";
         }
      } 
   }
 
   public String toString()
   {
      return root.toString();
   }
}   

