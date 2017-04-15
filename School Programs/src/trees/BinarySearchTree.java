package trees;

public class BinarySearchTree
{
   private Node root;

   /**
      Constructs an empty tree.
   */
   public BinarySearchTree()
   {
      root = null;
   }

   /**
      Inserts a new node into the tree.
      @param obj the object to insert
   */
   public void add(Comparable obj) 
   {
      Node newNode = new Node();
      newNode.data = obj;
      newNode.left = null;
      newNode.right = null;
      
      if (root == null)
      {
    	  root = newNode;
      }
      
      else
      {
    	  root.addNode(newNode);
      }
   }
   
   public Comparable Smallest()
   {
	   return root.findMin(root);
   }
    
   public void preorderPrint()
   {
      root.preorderPrintNode(root);
   }
   
   public void postorderPrint()
   {
      root.postOrderPrintNode(root);
   }
   
   public void inorderPrint()
   {
      root.inorderPrintNode(root);
   }


   /**
      A node of a tree stores a data item and references
      to the left and right child nodes.
   */
   class Node implements Comparable
   {
      public Comparable data;
      public Node left;
      public Node right;
      
      /**
         Inserts a new node as a descendant of this node.
         @param newNode the node to insert
      */
      public void addNode(Node newNode)
      {
         int comp = newNode.data.compareTo(data);
         
         if (comp < 0)
         {  
            if (left == null)
            {
            	left = newNode;
            }
            
            else
            {
            	left.addNode(newNode);
            }
         }
         
         else if (comp > 0)
         {  
            if (right == null)
            {
            	right = newNode;
            }
            
            else
            {
            	right.addNode(newNode);
            }
         }
      }
      
      //New method added to find the smallest. Currently not working properly
      public Node findMin(Node n)
      {
          if(n == null )
          {
        	  return null;
          }
          
          else if(n.left == null)
          {
        	  return n;
          }
          
          else
          {
        	 System.out.print(n.data);
          }   
          
          return n;
      }
      
      public void postOrderPrintNode(Node n)
      {
    	  if(n != null)
    	  {  
    		  postOrderPrintNode(n.left);
    		  postOrderPrintNode(n.right);
    		  System.out.print(n.data);
    	  }   
      }

      public void preorderPrintNode(Node n)
      {
    	  if(n != null)
    	  {  
    		  System.out.print(n.data);
    		  preorderPrintNode(n.left);
    		  preorderPrintNode(n.right);
    	  } 
      }
      
      public void inorderPrintNode(Node n)
      {
    	  if(n != null)
    	  { 
    		inorderPrintNode(n.left);
    		System.out.print(n.data);
    		inorderPrintNode(n.right);
    	  }
      }
     
	public int compareTo(Object obj) 
	{
		return 0;
	}
   }
}
