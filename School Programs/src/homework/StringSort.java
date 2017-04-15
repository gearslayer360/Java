/*
 *Name: Brian Matthys
 *Class: CSCI 1302
 *Section: 200
 */

package homework;

import java.util.Arrays;

public class StringSort
{
	public static void main(String[] args) 
	{
		String[] str = { "Goodbye", "Yellow", "Computer", "Keyring", "Brother", "Sister"};
		StringSort.sort(str);
		System.out.println(Arrays.toString(str));
	}

	public static void sort(String[] str)
	{
		if (str.length <= 1)
		{
			return;
		}
		
		String[] a = new String[str.length / 2];
		String[] b = new String[str.length - a.length];
		
		
		for (int i = 0; i < a.length; i++)
		{
			a[i] = str[i];
		}
		
		for (int i = 0; i < b.length; i++)
		{
			b[i] = str[a.length + i];
		}
		
		sort(a);
		sort(b);
		merge(a, b, str);
	}

	private static void merge(String[] theFirst, String[] theSecond, String[] str)
	{
		int first = 0; 
		int second = 0; 
		int i = 0; 
		int compare; 

		while (first < theFirst.length && second < theSecond.length)
		{
			compare = theFirst[first].compareToIgnoreCase(theSecond[second]);
			if (compare < 0) 
			{
				str[i] = theFirst[first];
				first++;
			}
			else
			{
				str[i] = theSecond[second];
				second++;
			}
			i++;
		}

		while (first < theFirst.length)
		{
			str[i] = theFirst[first];
			first++;
			i++;
		}
		
		
		while (second < theSecond.length)
		{
			str[i] = theSecond[second];
			second++;
			i++;
		}
	}
}
