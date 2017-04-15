/*
 *Name: Brian Matthys
 *Date: 2/18/2013
 *Class: CSCI 1301
 *Section: 201
 *Name of Program: Diamond
 *Description: Write a program that reads an integer and displays, using asterisks, a filled diamond
of the given side length. For example, if the side length is 4, the program should display
 	*
   ***
  *****
 *******
  *****
   ***
 	*
 */

package practice;

import java.util.Scanner;

public class Diamond 
{
	public static void main(String[] args)
	{
	int num;
	Scanner input = new Scanner (System.in);
	
	System.out.println("Please enter a number: ");
	num = input.nextInt();
	
	String x = "*";
	
		for (int i = 1; i <= (num * 2) - 1; i++) 
		{
			for (int j = i; j <=num; j++) 
			{
				System.out.print(" ");
			}
			System.out.println(x);
		}
	 }
}
