/*
 *Name: Brian Matthys
 *Date: 1/21/2013
 *Class: CSCI 1301
 *Section: 201
 *Name of Program: MilitaryTime
 *Description: This program takes in two numbers from a user in military time. Then
 *it will display the elapsed time between the two user inputs. 
 */

package programs;

import java.util.Scanner;

public class MilitaryTime 
{
	public static void main(String[] args)
	{
		int firstTime;
		int secondTime;
		int fMinutes;
		int fMinutesFromMidnight;
		int fHours;
		int sHours;
		int sMinutes;
		int sMinutesFromMidnight;
		int finalMinutes;
		int finalHours;
		
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter the first time: ");
	    firstTime = in.nextInt();
	    
	    System.out.print("Please enter the second time: ");
		secondTime = in.nextInt();
		
		fMinutes = firstTime % 100; 
		fHours = (firstTime / 100);
		fMinutesFromMidnight = (24 - fHours) * 60;
		
		sHours = (secondTime / 100 );
		sMinutesFromMidnight = (24- sHours) * 60;
		sMinutes = secondTime % 100;
		
		finalHours = ((fMinutesFromMidnight + sMinutesFromMidnight));
		System.out.println("Hours: " + finalHours);
		//System.out.println("Hours: " + ((sMinutesFromMidnight - fMinutesFromMidnight)));
		System.out.println("Minutes: " + Math.abs((sMinutes - fMinutes)));
	}
}
