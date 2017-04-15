/*
 *Name: Brian Matthys
 *Date: 2/26/2013
 *Class: CSCI 1301
 *Section: 201
 *Name of Program: AreaRectangle
 *Description: Write a method to calculate the area of a rectangle using the values 
 *double length = 3.4 and double width = 8.4. Take in two floats and return a double.
 */

package labs;

public class AreaRectangle
{
	public static void main(String[] args)
	{
		double length = 3.4;
		double width = 8.4;
		areaOfRectangle(length, width);
	}
	
	public static double areaOfRectangle(double length, double width)
	{
		
		double area = length * width;
		System.out.println(area);
		return area;
	}
}
