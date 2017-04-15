package linked_lists;

import java.util.NoSuchElementException;

public class LinkedList
{
   private Node first;

   public LinkedList()
   {
	   first = null; 
   }

   public Object getFirst()
   {
      if (first == null) 
      {
    	  throw new NoSuchElementException();
      }   
      return first.data;
   }

   public void addFirst(Object element)
   {
	   Node newNode = new Node(); 
	   newNode.data = element;
	   newNode.next = first;
	   first = newNode;
   }

   public Object removeFirst()
   {
	   if (first == null)
	   {
		   throw new NoSuchElementException();
	   }
	   
	   Object element = first.data;
	   first = first.next; 
	   return element;
   }

   public String toString()
   {
      String temp = "";
      Node current = first;
      while (current != null)
      {
         temp = temp + current.data.toString() + '\n';
         current = current.next;
      }
      return temp;
   }

   class Node
   {
      public Object data;
      public Node next;
   }
}




