/*
 * Brian Matthys
 * 1/17/2013
 */

package programs;

import java.util.Scanner;

public class SpacedNumbers
{
	public static void main(String[] args)
	{
		int num;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter a number five digits or less");
		num = input.nextInt();
		
		System.out.print(num / 10000 + " ");
		System.out.print((num / 1000) - 10 + " ");
		System.out.print((num % 1000) / 100 + " ");
		System.out.print((num % 100) / 10 + " ");
		System.out.print((num % 10) + " ");
		
	}
}
