package stacks;

public class StackArrayRunner
{
   public static void main(String[] args)
   {
      StackArray sa = new StackArray();
      
      
      sa.push("a");
      sa.push("b");
      sa.push("c");
      sa.push("d");
      sa.push("e");
      System.out.println(sa);
      System.out.println(sa.pop());
      System.out.println(sa);
      System.out.println(sa.pop());
      System.out.println(sa);
      System.out.println(sa.pop());
      System.out.println(sa);
      System.out.println(sa.pop());
      System.out.println(sa);
      System.out.println(sa.pop());
      //System.out.println(sa);
      //System.out.println(sa.pop());
   }
}

