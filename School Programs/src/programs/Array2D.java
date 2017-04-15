/*
 *Name: Brian Matthys
 *Date: 3/14/2013
 *Class: CSCI 1301
 *Section: 201
 *Name of Program: ArrayNames
 *Description: Make a 2D int array and add the values of the rows together.
 */

package programs;

public class Array2D 
{
	public static void main(String[] args)
	{
		int[][] num = {{2,3} ,{4,2} , {5,6}};
		
		for(int i = 0; i <num.length; i++)
		{
			int sum = 0;
			for(int j = 0; j<num[i].length; j++)
			{
				sum+=num[i][j];
			}
			System.out.println("Total is " + sum);
		}
	}
}
