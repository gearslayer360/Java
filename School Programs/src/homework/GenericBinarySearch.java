package homework;

import java.util.Arrays;
import java.util.Scanner;

public class GenericBinarySearch
{
	 public static void main(String[] args)
	   {           
	      Integer[] ints = {4,5,8,9,2,3,7,0,1};
	      Arrays.sort(ints);
	      System.out.println(Arrays.toString(ints));
	      Scanner input = new Scanner(System.in);
	       
	      boolean finished = false;
	      
	      while (!finished)
	      {
	         System.out.print
	               ("Enter number to search for, -1 to quit: ");
	         int a = input.nextInt();
	         if (a == -1) 
	         {
	        	 finished = true;
	         }
	         else
	         {
	        	int position = GenericBinarySearch.search(ints, a, 0, ints.length - 1);
	        	
	        	if(position == -1)
	        	{
	        		System.out.println(a + " not found");
	        	}
	        	else
	        	{
	        		System.out.println("Found in position " + position);
	        	}
	         }
	      }
	   }
	
	public static <T extends Comparable<T>> int search(T[] array, T value, int lower, int higher)
	{
		if(lower <= higher)
		{
			int middle = (lower + higher) / 2;
			int compare = array[middle].compareTo(value);
			
			if(compare < 0) return search(array, value, middle + 1, higher);	
			if(compare > 0) return search(array, value, lower, middle - 1);	
			
			return middle;
		}
			return -1;
	}
}
