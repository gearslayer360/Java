/*
 *Name: Brian Matthys
 *Date: 2/21/2013
 *Class: CSCI 1301
 *Section: 201
 *Name of Program: Vowels
 *Description: Write a method
  public static int countVowels(String str)
  that returns a count of all vowels in the string str. Vowels are the letters a, e, i, o, and
  u, and their uppercase variants.
 */

package practice;

import java.util.Scanner;

public class Vowels 
{
	public static void main(String[] args)
	{		
		countVowels("");
	}
	
	public static int countVowels(String str)
	{
		int num =0;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please type a word: ");
		str = input.next();
				
		for(int i = 0; i <str.length(); i++)
		{
			if(str.charAt(i) == 'a' || str.charAt(i) == 'A' || str.charAt(i) == 'e' || str.charAt(i) == 'E' 
			|| str.charAt(i) == 'i' || str.charAt(i) == 'I' || str.charAt(i) == 'o' || str.charAt(i) == 'O'
			|| str.charAt(i) == 'u' || str.charAt(i) == 'U')
			{
				num++;
			}
		}
		System.out.println("The number of vowels in " + str + " is " + num + ".");
		return(num);
	}
}
