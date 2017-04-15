/*
 * Brian Matthys 
 * 1/24/13
 * Description: This program should let you enter a grade as a number
 * and return the appropriate letter grade.
 */
package programs;

import java.util.Scanner;

public class Grades
{
	public static void main(String[] args)
	{
		int grade;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter a whole number numeric grade: ");
		grade = input.nextInt();
		
		if(grade < 60)
		{
			System.out.println("You got an F.");
		}
		
		else if(grade >= 60 && grade < 70)
		{
			System.out.println("You got a D.");
		}
		
		else if(grade >= 70 && grade < 80)
		{
			System.out.println("You got a C.");
		}
		
		else if(grade >= 80 && grade < 90)
		{
			System.out.println("You got a B.");
		}
		
		else
		{
			System.out.println("You got an A.");
		}
	}
}
