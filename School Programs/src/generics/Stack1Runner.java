package generics;

import java.util.Stack;

public class Stack1Runner
{
   public static void main(String[] args)
   {
      Stack<Integer> stk1 = new Stack<Integer>();
      stk1.push(1);
      stk1.push(2);
      stk1.push(3);
      stk1.push(4);
      while (!stk1.empty())
      {
         System.out.println(stk1.pop());
      }
   }
}

