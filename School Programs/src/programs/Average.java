package programs;

/*
 * Brian Matthys 
 * 1/15/13
 * This program will take the average of three user entered values and 
 * return it to two decimal places
 */

import java.util.Scanner;

public class Average
{
	public static void main(String[] args)
	{
		int value1;
		int value2;
		int value3;
		double avg;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter the first test score:");
		value1 = input.nextInt();
		System.out.println("Please enter the second test score:");
		value2 = input.nextInt();
		System.out.println("Please enter the third test score:");
		value3 = input.nextInt();
		
		avg = (double)(value1 + value2 + value3) / 3;
		
		System.out.printf("The average of the test scores is " + "%5.2f" , avg);
	}
}
