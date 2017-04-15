package trees;

public class TreeDemo
{
	 public static void main(String[] args)
	   {
	      Tree t1 = new Tree("A");
	      Tree t2 = new Tree("B");
	      t1.addSubtree(t2);
	      Tree t3 = new Tree("C");
	      t1.addSubtree(t3);
	      Tree t4 = new Tree("D");
	      t2.addSubtree(t4);
	      Tree t5 = new Tree("E");
	      t2.addSubtree(t5);
	      Tree t6 = new Tree("F");
	      t3.addSubtree(t6);
	      Tree t7 = new Tree("G");
	      t3.addSubtree(t7);
	      
	      System.out.println("Size: " + t1.size());
	      System.out.println(t1.toString());
	   }
}
