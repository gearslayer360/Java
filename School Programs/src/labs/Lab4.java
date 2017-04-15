/*
 *Name: Brian Matthys
 *Date: 1/22/2013
 *Class: CSCI 1301
 *Section: 201
 *Name of Program: Lab4
 */

package labs;

public class Lab4 
{
	public static void main(String[] args)
	{
		double milk = 5.5;
		double jarCapacity = .75;
		int completelyFilledJars = (int) (milk / jarCapacity);
		
		System.out.println("The number of filled jars is " + completelyFilledJars);
		
	}
}
