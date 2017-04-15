/*
 *Name: Brian Matthys
 *Date: 3/12/2013
 *Class: CSCI 1301
 *Section: 201
 *Name of Program: CollatzConjecture
 */

package fun;

import java.util.Scanner;

public class CollatzConjecture 
{
	public static void main(String[] args)
	{
		long chosenNumber; 
		int steps =0;;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a number: ");
		chosenNumber = input.nextLong();
		
		while(chosenNumber > 1)
		{
			if(chosenNumber ==1)
			{
				break;
				//System.out.println("1");
			}
			
			else if(chosenNumber % 2 == 0)				
			{
				chosenNumber /=2;
				steps++;
			}
			
			else if(chosenNumber % 2 == 1)
			{
				chosenNumber = (chosenNumber * 3) + 1;
				steps++;
			}
			System.out.println(chosenNumber);
		}
		System.out.println("The chosen number converges to " + chosenNumber);
		System.out.println("This took " + steps + " steps.");
	}
}
