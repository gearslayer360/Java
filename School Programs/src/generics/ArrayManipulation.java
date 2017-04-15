package generics;

import java.util.*;

public class ArrayManipulation
{		
   public static void main(String[] args)
   {
      Integer[] a = { 1, 2, 3, 4, 5, 6, 7 };
      Character[] b = { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };
      Double[] c = { 1.0, 2.0, 3.3, 4.4, 5.9, 8.7 };
      print(a);
      reverse(a);
      print(a);
      print(b);
      reverse(b);
      print(b);
      print(c);
      reverse(c);
      print(c);
      System.out.println("\nThe smallest element in a is "  + minimum(a));
      System.out.println("The smallest element in b is "  + minimum(b));
      System.out.println("The smallest element in c is "  + minimum(c));
      
      System.out.println("\nThe list a is "  + increasing(a));
      System.out.println("The list b is "  + increasing(b));
      System.out.println("The list c is "  + increasing(c));
   }

   public static <T> void print(T[] x)
   {
     String result = " ";
     
     for(T t : x)
     {
    	 result += (t + " ");
     }
     System.out.println(result);
   }

   public static <T> void reverse(T[] x)
   {	 
	 Stack<T> newStack = new Stack<T>();
	 
     for(int i = 0; i < x.length; i++)
     {
    	 newStack.push(x[i]);
     }
     
     int counter = 0;
     
     while(newStack.size() > 0)
     {
    	x[counter] = newStack.pop();
    	counter++;
     }
   }
   
   public static <T extends Comparable<T>> T minimum(T[] x)
   {
	   T smallest = null;
	   int comp;
	   
	   for(int i = 0; i < x.length-1; i++)
	     {
	    	comp = x[i+1].compareTo(x[i]);
	    	
	    	if(comp < 0)
	    	{
	    		smallest = x[i+1];
	    	}
	    	
	    	else if(comp > 0)
	    	{
	    		smallest = x[i];
	    	}
	     }
	   
	return smallest; 
   }
   
   public static <T extends Comparable<T>> T increasing(T[] x)
   {
	   T least = x[0];
	   int next;
	   
	   for(int i = 0; i < x.length-1; i++)
	   {
		   next = x[i+1].compareTo(x[i]);
		   
		   if(next > 0)
		   {
			   least = x[i];
			   System.out.println("The list is increasing.");
		   }
		   
		   else if(next < 0 )
		   {
			   least = x[i + 1];
			   System.out.println("The list is not increasing.");
		   }		   
	   }
	return least;
   }
}
