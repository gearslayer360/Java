/*
 *Name: Brian Matthys
 *Date: 1/29/2013
 *Class: CSCI 1301
 *Section: 201
 *Name of Program: Prizes
 *Description: This program will read three numbers as scores and three names  
 * of the people who got the scores and return who got the highest score in order greatest to least.  
 */

package programs;

import java.util.Scanner;

public class Prizes 
{
	public static void main(String[] args)
	{
		String name1, name2, name3;
		int score1, score2, score3;
				
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter the first name: ");
		name1 = input.next();
		
		do
		{
		System.out.println("Please enter the first score: ");
		score1 = input.nextInt();
		}
		while(score1 > 100);
		
		System.out.println("\nPlease enter the second name: ");
		name2 = input.next();
		
		do
		{
		System.out.println("Please enter the second score: ");
		score2 = input.nextInt();
		}
		while(score2 >100);
		
		System.out.println("\nPlease enter the third name: ");
		name3 = input.next();
		
		do
		{
		System.out.println("Please enter the third score: ");
		score3 = input.nextInt();
		}
		while(score3 > 100);
		
		if(score1 > score2 && score1 > score3 && score2 > score3)
		{
			System.out.println("\nFirst prize: " + name1 + " " + score1);//name 1 first
			System.out.println("Second prize: " + name2 + " " + score2);//name 2 second
			System.out.println("Third prize: " + name3 + " " + score3);// name 3 third
		}
		
		else if(score2 > score1 && score2 > score3 && score1 > score3)
		{
			System.out.println("\nFirst prize: " + name2 + " " + score2);//name 2 first
			System.out.println("Second prize: " + name1 + " " + score1);//name 1 second
			System.out.println("Third prize: " + name3 + " " + score3);// name 3 third
		}
		
		else if(score2 > score1 && score2 > score3 && score3 > score1)
		{
			System.out.println("\nFirst prize: " + name2 + " " + score2);//name 2 first
			System.out.println("Second prize: " + name3 + " " + score3);//name 3 second
			System.out.println("Third prize: " + name1 + " " + score1);// name 1 third
		}
		
		else if(score3 > score1 && score3 > score2 && score1 > score2)
		{
			System.out.println("\nFirst prize: " + name3 + " " + score3);//name 3 first
			System.out.println("Second prize: " + name1 + " " + score1);//name 1 second
			System.out.println("Third prize: " + name2 + " " + score2);// name 2 third
		}
		
		else if(score3 > score1 && score3 > score2 && score2 > score1)
		{
			System.out.println("\nFirst prize: " +  name3 + " " + score3);//name 3 first
			System.out.println("Second prize: " + name2 + " " + score2);//name 2 second
			System.out.println("Third prize: " + name1 + " " + score1); // name 1 third
		}		
	}
}
