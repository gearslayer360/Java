package homework;

import java.util.NoSuchElementException;


public class LinkedList
{  
   private Node first;
   private int currentSize;	
   
   public static void main(String[] args)
   {  
      LinkedList staff = new LinkedList();
      staff.addFirst("Tom");
      staff.addFirst("Romeo");
      staff.addFirst("Harry");
      staff.addFirst("Diana");
 
      ListIterator iterator = staff.listIterator();
      iterator.next();
      iterator.next();
      
      iterator.add("Juliet");
      iterator.add("Nina");

      iterator.next();
      iterator.remove(); 
     
      iterator = staff.listIterator();
      while (iterator.hasNext())
      {
         System.out.print(iterator.next() + " ");
      }
      
      System.out.println("\n");
      
      iterator = staff.listIterator();
     
      while(iterator.hasNext())
      {
   	   String temp = (String) iterator.next();
   	   System.out.println("Does the list contain " + temp + "? - " + staff.contains(temp));
      }
     
      System.out.println("Does the list contain Bobby? - " + staff.contains("Bobby"));
      System.out.println("Does the list contain Jimmy? - " + staff.contains("Jimmy"));

   }
  
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

   public Object removeFirst()
   {  
	  currentSize--;	
      if (first == null)
      {
    	  throw new NoSuchElementException();
      }
      
      Object element = first.data;
      first = first.next;
      return element;
   }

   public void addFirst(Object element)
   {  
	  currentSize++;	
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      first = newNode;
   }

   public int size()
   {
	   return currentSize;
   }
 
   public ListIterator listIterator()
   {  
      return new LinkedListIterator();
   }
   
   public boolean contains(Object obj)
   {
	   Node temp = first;	
	   for(int i = 0; i < currentSize; i++)	
	   {
		   if(obj.equals(temp.data))
		   {
			   return true;	
		   }
		   temp = temp.next;
	   }
	   return false;							
   }
   
   class Node
   {  
      public Object data;
      public Node next;
   }

   class LinkedListIterator implements ListIterator
   {  
      private Node position;
      private Node previous;
      private boolean isAfterNext;

      public LinkedListIterator()
      {  
         position = null;
         previous = null;
         isAfterNext = false;
      }
  
      public Object next()
      {  
         if (!hasNext())
         {
        	 throw new NoSuchElementException();
         }
         previous = position; 
         isAfterNext = true;

         if (position == null)
         {
            position = first;
         }
         else
         {
            position = position.next;
         }

         return position.data;
      }

      public boolean hasNext()
      {  
         if (position == null)
         {
            return first != null;
         }
         else
         {
            return position.next != null;
         }
      }

      public void add(Object element)
      {  
         currentSize++; 
         if (position == null)
         {
            addFirst(element);
            position = first;
         }
         else
         {  
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            position.next = newNode;
            position = newNode;
         }
         isAfterNext = false;
      }

      public void remove()
      {  
    	 currentSize--;	
         if (!isAfterNext)
         { 
        	 throw new IllegalStateException(); 
         }

         if (position == first)
         {
            removeFirst();
         }
         else 
         {  
            previous.next = position.next;
         }
         position = previous;
         isAfterNext = false;
      }

      public void set(Object element)
      {
         if (!isAfterNext)
         {
        	 throw new IllegalStateException();
         }
         position.data = element;
      }
   }
}
