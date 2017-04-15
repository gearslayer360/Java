/*
 *Name: Brian Matthys
 *Date: 1/22/2013
 *Class: CSCI 1301
 *Section: 201
 *Name of Program: Lab6
 */

package labs;

import java.util.Scanner;

public class Lab6 
{
	public static void main(String[] args)
	{
		int a;
		int b;
		int c;
		int d;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter a number");
		a = input.nextInt();
		System.out.println("Please enter a second number");
		b = input.nextInt();
		System.out.println("Please enter a third number");
		c = input.nextInt();
		System.out.println("Please enter a fourth number");
		d = input.nextInt();
		
		int e = Math.max(a, b);
		int f = Math.max(c, d);
		
		System.out.println("The largest of the four numbers is " + Math.max(e, f));
	}
}
