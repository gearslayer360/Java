package generics;

import java.util.*;

public class Stack1<T>
{
   private ArrayList<T> myList;
    
   public <T> Stack1()
   {
      T myList = (T) new ArrayList<T>();
   }

   public void push(T item)
   {
      myList.add(item);
   }

   public Integer pop()
   {
      Integer retItem = null;
      if (!myList.isEmpty())
      {
         retItem = myList.remove(myList.size() - 1);
      }
      return retItem;
   }

   public boolean  empty()
   {
      return myList.isEmpty();
   }
}

