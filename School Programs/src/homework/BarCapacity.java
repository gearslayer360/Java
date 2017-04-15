/*
 *Name: Brian Matthys
 *Date: 2/14/2013
 *Class: CSCI 1301
 *Section: 201
 *Name of Program: BarCapacity
 *Description: Write a program that reads the sizes of the groups that arrive or depart.
 *Use negative numbers for departures. After each input, display the current number
 *of occupants. As soon as the bar holds the maximum number of people, report that
 *the bar is full and exit the program. 
 */

package homework;

import java.util.Scanner;

public class BarCapacity 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		int max = 100; //bar maximum capacity
		int current = 0; //current number of people in bar. Initially zero.
		int response; 
		int entering;
		int leaving;
		
		// Main loop that runs until the bar is full with 100 people
		
		do
		{
			//Loop to ask if person is entering or leaving the bar.
			//Error checks and won't accept an answer other than 1 or 2
			do
			{
				System.out.println("\nAre you entering or exiting the bar?");
				System.out.println("Type [1] for entering");
				System.out.println("     [2] for exiting:");
				response = input.nextInt();
			}
			while (!(response == 1 || response == 2 ));
			
			//if the person wants to enter, asks how many people are
			//with them, and adds that number to the current number of people in the bar
			if(response == 1)
			{
				System.out.println("How many people will be entering with you today? Press [1] if you are alone.");
				entering = input.nextInt();
				
				//If adding that many people causes current to be greater than 100
				//it will deny entry and restart the main loop
				if(current + entering > 100)
				{
					System.out.println("I'm sorry, but the bar has a maximum capacity of 100 people.");
				}
				
				if(current + entering <= 100)
				{
				current += entering;
				System.out.println("Have fun. There are now " + current + " people in the bar.\n");
				}
			}
			
			//if the person wants to exit, asks how many people are
			//with them, and subtracts that number from the current number of people in the bar
			else if(response == 2 && current > 0)
			{
				System.out.println("How many people will be leaving with you today? Press [1] if you are alone.");
				leaving = input.nextInt();
				
				//If subtracting that many people causes current to be less than 0
				//it will deny the exit and restart the main loop
				if(current-leaving < 0)
				{
				System.out.println("Sorry, there are not that many people currently in the bar.");
				}
				
				if(current-leaving >= 0)
				{
				current -= leaving;
				System.out.println("Have a good day. There are now " + current + " people in the bar.\n");
				}
			}
		}
		while(current < 100);
	}
}
