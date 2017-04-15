/*
 *Name: Brian Matthys
 *Date: 9/25/2013
 *Class: CSCI 1302
 *Section: 200
 */

package homework;

import java.util.Scanner;

public class Substrings 
{
	static String phrase;
	static String substring;
	static int current = 0;
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a word or phrase to be searched: ");
		phrase = input.nextLine();
		System.out.println("Enter something to search for in the word or phrase: ");
		substring = input.nextLine();
		
		find(phrase, substring);
	}
	
	public static boolean find(String text, String str)
	{	
		while(current < text.length())
		{
			if(str.length() > text.length())
			{
				System.out.println(str + " is not found in " + text + " because it is longer than " + text);
				return false;
			}
				
			if(str.equalsIgnoreCase(text))
			{
				System.out.println(str + " is found in " + text);
				return true;
			}
		
			else if(text.substring(current, text.length()).contains(str))
			{
				System.out.println(str + " is found in " + text);
				return true;
			}
		
			else if(!(text.substring(current, text.length()).contains(str)))
			{
				current++;
				find(text, str);
			}
			
			else 
			{
				return false;
			}
		}
		System.out.println(str + " is not found in " + text);
		return false;
	}
}
