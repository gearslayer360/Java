package trees;

public class TreeTester
{ 
   public static void main(String[] args)
   {  
      BinarySearchTree t = new BinarySearchTree();
      t.add("D");
      t.add("B");
      t.add("A");
      t.add("C");
      t.add("F");
      t.add("E");
      t.add("I");
      t.add("G");
      t.add("H");
      t.add("J");
      
      System.out.print("PreOrder Tree: ");
      t.preorderPrint();
     
      System.out.print("\nPostOrder Tree: ");
      t.postorderPrint();
      
      System.out.print("\nInOrder Tree: ");
      t.inorderPrint(); 
      
      System.out.print("\nMin: ");
      t.Smallest(); 
   }
}

