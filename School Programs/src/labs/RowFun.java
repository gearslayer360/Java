/*
 *Name: Brian Matthys
 *Date: 2/26/2013
 *Class: CSCI 1301
 *Section: 201
 *Name of Program: RowFun
 *Description: Write a method called makeRow that is passed two arguments: an int n and a String s,
 * and which returns a String containing n copies of s, concatenated in a row. For instance, 
 * if we call the method with makeRow(5, "*"), the method returns *****. 
 * Write a main method that uses the method to print the string *****=====*****.
 */

package labs;

public class RowFun
{
	public static void main(String[] args)
	{		
		makeRow(1, "*****=====*****");
	}
	
	public static String makeRow(int n, String s)
	{
		
		for(int i = 0; i<n; i++)
		{
			System.out.print(s);
		}
		return s;
	}
}
