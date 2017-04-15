/*
 *Name: Brian Matthys
 *Class: CSCI 1302
 *Section: 200
 */

package homework;

import java.util.*;
import javax.swing.*;

public class DrivewayStack
{
	public static void main(String[] args)
	{
		Stack<Integer> theDriveway = new Stack<Integer>(); 
		Stack<Integer> theStreet = new Stack<Integer>();
		String entered;
		int plate = 1;
		
		while(plate != 0)
		{
			entered = JOptionPane.showInputDialog("Enter a positive number to park a car in the driveway, \n"
										+ "or a negative number to remove from the driveway, or zero to quit.");
			plate = Integer.parseInt(entered);
			
			if(plate > 0)				
			{theDriveway.push(plate);}	
		
			else if(plate < 0)
			{
				while(theDriveway.contains(Math.abs(plate)))
				{
					theStreet.push(theDriveway.pop());
					System.out.println("Cars in street: " + theStreet.toString());
				}
				theStreet.pop();
				
				while(theStreet.size() > 0)	
				{
					theDriveway.push(theStreet.pop());
				}
			}
			System.out.println("\nStreet empty " + theStreet.toString());
			System.out.println("Driveway: " + theDriveway.toString());
		}
	}
}

