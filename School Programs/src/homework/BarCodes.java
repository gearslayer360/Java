/*
 *Name: Brian Matthys
 *Date: 3/11/2013
 *Class: CSCI 1301
 *Section: 201
 *Name of Program: BarCodes
 *Description:	Write a program that asks the user for a zip code and prints the bar code. Use : for
  half bars, | for full bars. For example, 95014 becomes
  ||:|:::|:|:||::::::||:|::|:::|||
  Provide these methods:
  public static void printDigit(int d)
  public static void printBarCode(int zipCode)
 */

package homework;

import java.util.Scanner;

public class BarCodes
{
	public static void main(String[] args)
	{
		printBarCode(1);
	}
	
	public static void printBarCode(int zipCode)
	{
		int zip = 0;;
		zipCode = zip;
		int remainder;
		int sum = 0;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter the zip code: ");
		zip = input.nextInt();
		
		while(zip > 1)
		{
		remainder = zip % 10;
		sum += remainder;
		zip /= 10;
		}
		
		System.out.println(sum);
		sum = sum %10;
		sum = 10 - sum;
		System.out.println(sum);
	}
	
	public static void printDigit(int d)
	{
		String zero = "||:::";
		String one = ":::||";
		String two = "::|:|";
		String three = "::||:";
		String four = ":|::|";
		String five = ":|:|:";
		String six = ":||::";
		String seven = "|:::|";
		String eight = "|::|:";
		String nine = "|:|::";
	}
}
