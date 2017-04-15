/*
 *Name: Brian Matthys
 *Date: 1/22/2013
 *Class: CSCI 1301
 *Section: 201
 *Name of Program: Lab3
 *Description: Write a program that prompts the user to enter two integers.
 * Print the smaller of the two numbers entered. You’ll need to use a Scanner and a Math method. 
 */
package labs;

import java.util.Scanner;

public class Lab3
{
	public static void main(String[] args)
	{
		int a;
		int b;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter a number: ");
		a = input.nextInt();
		System.out.println("Please enter a second number: ");
		b = input.nextInt();
		
		System.out.println("The smaller of the two numbers is " + Math.min(a, b));		
	}
}
