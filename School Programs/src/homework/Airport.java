/*
 *Name: Brian Matthys
 *Class: CSCI 1302
 *Section: 200
 */
package homework;

import java.util.*;
import javax.swing.*;

public class Airport
{
	public static void main(String[] args)
	{
		Queue<String> landing = new LinkedList<String>();
		Queue<String> takeoff = new LinkedList<String>();
		
		String entered = "";
		
		while(!entered.equals("quit"))
		{
			entered = JOptionPane.showInputDialog("Available Commands:" 
					+ "						 takeoff 'flight symbol'\n"
					+ "                      land 'flight symbol'\n"
					+ "                      next\n"
					+ "                      quit").toLowerCase();
					
			if(entered.contains("land"))
			{
				entered = entered.substring(4).trim();		
				checkNull(entered);					
				landing.add(entered);				
				System.out.println("\nPlanes waiting for takeoff... " + takeoff.toString());
				System.out.println("\nPlanes waiting to landing... " + landing.toString() + "\n");
			}
			
			else if(entered.contains("takeoff"))
			{
				entered = entered.substring(7).trim();		
				checkNull(entered);					
				takeoff.add(entered);				
				System.out.println("\nPlanes waiting for takeoff... " + takeoff.toString());
				System.out.println("\nPlanes waiting to landing... " + landing.toString() + "\n");
			}
			
			else if(entered.equals("next"))
			{
				if(landing.size() > 0)			
				{
					System.out.println("RUNWAY IS BUSY");
					System.out.println("Landing Flight: " + landing.poll() + "\n");	
					
					if(landing.size() == 0){System.out.println("\nRUNWAY IS CLEAR");}	
				}
				
				else if(takeoff.size() > 0)	
				{
					System.out.println("\nRUNWAY IS BUSY");
					System.out.println("Flight Taking Off: " + takeoff.poll() + " ---\n");
				}
				
				System.out.println("\n Planes waiting for takeoff:" + takeoff.toString());
				System.out.println("\nPlanes waiting to landing: " + landing.toString() + "\n");
			}
			
			if(takeoff.size() == 0 && landing.size() == 0)	
			{
				System.out.println("\nRUNWAY IS CLEAR");	
			}
		}	
	}
	
	public static void checkNull(String input)
	{
		if(input.length() <= 0)
		{
			JOptionPane.showMessageDialog(null,"Please enter a flight smybol after desired command.","Need flight symbol", JOptionPane.ERROR_MESSAGE);
		}
	}
}
