/*
 *Name: Brian Matthys
 *Date: 1/23/2013
 *Class: CSCI 1301
 *Section: 201
 *Name of Program: Paycheck(3.31)
 *Description: Write a program that reads in the name and salary of an employee. Here the salary
will denote an hourly wage, such as $9.25. Then ask how many hours the employee
worked in the past week. Be sure to accept fractional hours. Compute the pay. Any
overtime work (over 40 hours per week) is paid at 150 percent of the regular wage.
Print a paycheck for the employee. 
 */

package programs;

import java.util.Scanner;

public class Paycheck
{
	public static void main(String[] args)
	{
		String name;
		float salary;
		float hours;
		double pay;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("What is your name? ");
		name = input.nextLine();
		
		System.out.println("What is your salary? ");
		salary = input.nextFloat();
		
		System.out.println("How many hours did you work this week? ");
		hours = input.nextFloat();
		
		if(hours <= 40)
		{
			pay = (salary * hours);
			System.out.println(name + ", your pay for this week is " + pay + " dollars");
		}
		
		if(hours > 40)
		{
			pay = (salary * hours * 1.5);
			System.out.print(name + ", your pay for this week is " + pay + " dollars");
		}
		
	}
}
