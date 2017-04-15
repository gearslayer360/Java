/*
 *Name: Brian Matthys
 *Date: 4/17/2013
 *Class: CSCI 1301
 *Section: 201
 *Name of Program: ComboLock
 *Description: Declare a class ComboLock that works like the combination lock
 *in a gym locker, as shown here. The lock is constructed with a
 *combination— three numbers between 0 and 39. 
 *The reset method resets the dial so that it points to 0.
 *The turnLeft and turnRight methods turn the dial by a given number of ticks to the left or right.
 *The open method attempts to open the lock.
 *The lock opens if the user first turned it right to the first number in the combination, then left to the second, and then right to the third.
 * 
 *public class ComboLock
 *{
 *. . .
 *public ComboLock(int secret1, int secret2, int secret3) { . . . }
 *public void reset() { . . . }
 *public void turnLeft(int ticks) { . . . }
 *public void turnRight(int ticks) { . . . }
 *public boolean open() { . . . }
 *}
 */

package homework;

import java.util.Scanner;

public class ComboLock
{
	public static int turn;
	public static int secret1 = 10;
	public static int secret2 = 20;
	public static int secret3 = 25;
	public static int guess1;
	public static int guess2;
	public static int guess3;
	public static String direction1;
	public static String direction2;
	public static String direction3;
	
	public static void main(String[] args)
	{
		String reset;
		boolean running = true;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter the first number you wish to turn to: ");
		guess1 = input.nextInt();
		System.out.println("Please enter the direction you wish to turn the dial. L)eft or R)ight");
		direction1 = input.next().toLowerCase();
		turn = 1;
		
		if(direction1.equals("l"))
		{
			turnLeft(guess1);
		}
		
		else if(direction1.equals("r"))
		{
			turnRight(guess1);
		}
				
		System.out.println("Please enter the second number you wish to turn to: ");
		guess2 = input.nextInt();
		System.out.println("Please enter the direction you wish to turn the dial. (Left or Right)");
		direction2 = input.next();
		turn = 2;
		
		if(direction1.equals("l"))
		{
			turnLeft(guess1);
		}
		
		else if(direction1.equals("r"))
		{
			turnRight(guess1);
		}
				
		System.out.println("Please enter the third number you wish to turn to: ");
		guess3 = input.nextInt();
		System.out.println("Please enter the direction you wish to turn the dial. (Left or Right) ");
		direction3 = input.next();
		turn = 3;
		
		if(direction1.equals("l"))
		{
			turnLeft(guess1);
		}
		
		else if(direction1.equals("r"))
		{
			turnRight(guess1);
		}
		
		open();
		
		}
	
	public ComboLock(int secret1, int secret2, int secret3)
	{
		this.secret1 = secret1;
		this.secret2 = secret2;
		this.secret3 = secret3;
	}
	
	public static void reset()
	{
		guess1 = 0;
		guess2 = 0;
		guess3 = 0;
	}
	
	public static void turnLeft(int ticks)
	{
		if(turn == 1)
		{
			ticks = guess1;
		}
		
		if(turn == 2)
		{
			ticks = guess2;
		}
		
		if(turn == 3)
		{
			ticks = guess3;
		}
	}
	
	public static void turnRight(int ticks)
	{
		if(turn == 1)
		{
			ticks = guess1;
		}
		
		if(turn == 2)
		{
			ticks = guess2;
		}
		
		if(turn == 3)
		{
			ticks = guess3;
		}
	}
	
	public static boolean open()
	{
		if(guess1 == secret1 && direction1.equals("r"))
		{
			if(guess2 == secret2 && direction2.equals("l"))
			{
				if(guess3 == secret3 && direction3.equals("r"))
				{
					System.out.println("Congratulations the lock was successfully opened!");
					return true;
				}
			}
		}
		
		System.out.println("The lock was not successfully opened");
		return false;
	}
}

