/*
 *Name: Brian Matthys
 *Date: 3/14/2013
 *Class: CSCI 1301
 *Section: 201
 *Name of Program: ArrayNames
 *Description: Make an array to read and store ten names as a string. 
 *Then sort the array in alphabetical order. It also reports the frequency of each name in the list.
 */

package programs;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayNames 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String[] names = new String[10];
	
		System.out.println("Please enter a list of 10 names: ");
		
		for (int i =0; i< 10; i++)
		{
			names[i] = input.nextLine();
		}
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));
		
		int count = 1;
		String name = names[0];
		
		for (int j =1; j< 10; j++)
		{
		if(name.equals(names[j]))
		{
			count++;
		}
		
		else
		{
			System.out.println(name + " " + count);
			name = names[j];
			count = 1;
		}
	}
		System.out.println(name + " " + count);
  }
}
