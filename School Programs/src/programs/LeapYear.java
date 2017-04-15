/*
 * Brian Matthys 
 * 1/24/13
 * Description: This program should let you enter a year as a number
 * and return wether it is a leap year or not.
 */

package programs;

import java.util.Scanner;

public class LeapYear
{
	public static void main(String[] args)
	{
		int year;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter a year: ");
		year = input.nextInt();
		
		if(year % 400 == 0 || year % 4 == 0 && year % 100 !=0 )
		{
			System.out.println(year + " is a leap year.");
		}
		
		else
		{
			System.out.println(year + " is not a leap year.");
		}
	}
}
