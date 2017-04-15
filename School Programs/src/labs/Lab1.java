/*
 *Name: Brian Matthys
 *Date: 1/22/2013
 *Class: CSCI 1301
 *Section: 201
 *Name of Program: Lab1
 *Description: Write a program that does the following: Create seven variables, one for each of the primitive number types in Java,
 * and initialize each variable with any appropriate value. Print out the name of each variable and its value. 
 * Modify the value of each variable with an assignment statement and print out the names of the variables and their new values.
 * Next, create seven constants, one for each of the primitive number types in Java. Print the name of the constant and its value.
 */

package labs;

public class Lab1 
{
	public static void main(String[] args)
	{
		byte myByte = 100;
		short myShort = 10000;
		int myInt = 500;
		long myLong = 10000346L;
		float myFloat = 10.5f;
		double myDouble = 100.5;
		char myChar = 'a';
		boolean myBoolean = false;
		
		final byte MY_BYTE = 20;
		final short MY_SHORT = 15600;
		final int MY_INT = 26564;
		final long MY_LONG = 1005465640L;
		final float MY_FLOAT = 30.5f;
		final double MY_DOUBLE = 446540.5;
		final char MY_CHAR = 'z';
		
		System.out.println("myByte: " + myByte);
		System.out.println("myShort: " + myShort);
		System.out.println("myInt: " + myInt);
		System.out.println("myLong: " + myLong);
		System.out.println("myFloat: " + myFloat);
		System.out.println("myDouble: " + myDouble);
		System.out.println("myChar: " + myChar);
		System.out.println("myBoolean: " + myBoolean);
		
		 myByte = 50;
		 myShort = 1000;
		 myInt = 600;
		 myLong = 200564560L;
		 myFloat = 20.5f;
		 myDouble = 200.5;
		 myChar = 'b';
		 myBoolean = true;
		 
		 System.out.println("\nmyByte: " + myByte);
		 System.out.println("myShort: " + myShort);
		 System.out.println("myInt: " + myInt);
		 System.out.println("myLong: " + myLong);
		 System.out.println("myFloat: " + myFloat);
		 System.out.println("myDouble: " + myDouble);
		 System.out.println("myChar: " + myChar);
		 System.out.println("myBoolean: " + myBoolean);
		 
		 System.out.println("\nMY_BYTE: " + MY_BYTE);
		 System.out.println("MY_SHORT: " + MY_SHORT);
		 System.out.println("MY_INT: " + MY_INT);
		 System.out.println("MY_LONG: " + MY_LONG);
		 System.out.println("MY_FLOAT: " + MY_FLOAT);
		 System.out.println("MY_DOUBLE: " + MY_DOUBLE);
		 System.out.println("MY_CHAR: " + MY_CHAR);
		 
	}
}
