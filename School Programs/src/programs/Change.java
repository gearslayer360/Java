/*
 * Brian Matthys 
 * 1/10/13
 * This program should let you enter an amount of money
 * and give you the least amount of coins it can make the change with.
 */

package programs;

import java.util.Scanner;

public class Change 
{
	public static void main(String[] args) 
	{
		int quarters, dimes, nickels, pennies;
		int change;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the change in cents: ");
		change = input.nextInt();

		quarters = (change / 25);
		dimes = ((change % 25 / 10));
		nickels = (((change % 25) % 10 / 5));
		pennies = (((change % 25) % 10) % 5);

		System.out.println("The minimum number of coins is: ");
		System.out.println("Number of Quarters: " + quarters);
		System.out.println("Number of Dimes: " + dimes);
		System.out.println("Number of Nickels: " + nickels);
		System.out.println("Number of Pennies: " + pennies);
	}
}
