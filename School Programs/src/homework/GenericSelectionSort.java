package homework;

import java.util.Arrays;

public class GenericSelectionSort 
{
	public static void main(String[] args)
	{
		
		Integer[] a = {3, 8, 42, 46, 260, 615, 232, 31, 43, 242, 754, 101};
		System.out.println(Arrays.toString(a));
		
		GenericSelectionSort.sort(a);
		System.out.println(Arrays.toString(a));
		System.out.println();
		
		Double[] doubleArray = {100.5, 5.42, 6.41, 2.12, 27.4, 340.2, 21.21, 2.222};
		System.out.println(Arrays.toString(doubleArray));
		
		GenericSelectionSort.sort(doubleArray);
		System.out.println(Arrays.toString(doubleArray));
		System.out.println();
		
		Character[] charArray = {'C', 'X', 'Y', 'V', 'U', 'S', 'R', 'Z', 'N', 'B', 'J'};
		System.out.println(Arrays.toString(charArray));
		
		GenericSelectionSort.sort(charArray);
		System.out.println(Arrays.toString(charArray));
		System.out.println();
		
		String[] stringArray = {"Rope", "Water", "Human", "Computer", "Xbox", "Window", "Silent", "Night"};
		System.out.println(Arrays.toString(stringArray));
		
		GenericSelectionSort.sort(stringArray);
		System.out.println(Arrays.toString(stringArray));
	}

	public static <E extends Comparable<E>> void sort(E[] a)
	{
		for(int i = 0; i < a.length - 1; i++)
		{
			int minPos = minimumPosition(a,i);
			ArrayHelp.swap(a, minPos, i);
		}
	}
	
	private static <E extends Comparable<E>> Integer minimumPosition(E[] a, Integer from)
	{
		Integer minPos = from;
		for(int i = from + 1; i < a.length; i++)
		{
			if(a[i].compareTo(a[minPos]) < 0) 
			{
				minPos = i;
			}
		}
		return minPos;
	}
}
