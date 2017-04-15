/*Name: Brian Matthys
 *Date: 3/14/2013
 *Class: CSCI 1301
 *Section: 201
 *Name of Program: ArrayNames
 *Description: A run is a sequence of adjacent repeated values. Write a program that generates a
	sequence of 20 random die tosses in an array and that prints the die values, marking
	the runs by including them in parentheses, like this:
	1 2 (5 5) 3 1 2 4 3 (2 2 2 2) 3 6 (5 5) 6 3 1

	Use the following pseudocode:
	
	Set a boolean variable inRun to false.
		For each valid index i in the array
			If inRun
				If values[i] is different from the preceding value 
				Print ).
				inRun = false.
				
				If not inRun
					If values[i] is the same as the following value 
					Print (.
					inRun = true.
				Print values[i].
				If inRun, print ).
 */

package programs;

import java.util.Random;
import java.util.Arrays;

public class InARun
{
	public static void main(String[] args)
	{
		Random rand = new Random();
		boolean run = false;
		int[] r = new int[20];
		
		for(int i = 1; i<r.length; i++)
		{
			r[i] = rand.nextInt(9) + 1;
		}
			
			for(int i = 0; i <r.length-1; i++)
			{
				if(run)
				{
					if(!(r[i] == r[i +1] ))
					{
						System.out.print(")");
						run = false;
					}
				}
				
				else if(!run)
				{
					if((r[i] == r[i +1]))
					{
						System.out.print("(");
						run = true;
					}
				}
			
				if(run)
				{
					System.out.print(")");
				}
				System.out.print(r[i]);
			}
			
	}
}

