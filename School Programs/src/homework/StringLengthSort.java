/*
 *Name: Brian Matthys
 *Class: CSCI 1302
 *Section: 200
 */

package homework;

import java.util.Comparator;
import java.util.*;
import javax.swing.*;

public class StringLengthSort implements Comparator<String>
{
	public static void main(String[] args)
	{
		String notSorted;
		String isSorted; 
		ArrayList<String> list = new ArrayList<String>();
		
		String entered = JOptionPane.showInputDialog(null, "Enter words to be sorted by length each separated by a comma.\n"
				 								   + "\n Do not add extra spaces between words or the commas.");
		
		if(entered.contains(" ")) 
		{
			JOptionPane.showMessageDialog(null, "Please don't use extra spaces", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			entered = JOptionPane.showInputDialog(null, "Enter words to be sorted by length each separated by a comma.\n"
					   + "\n Do not add extra spaces between words or the commas.");
		}
		
		Collections.addAll(list, entered.split(","));
		
		notSorted = list.toString();
		
		Collections.sort(list, new StringLengthSort());	
		isSorted = list.toString();	
		JOptionPane.showMessageDialog(null,"Before Sort: " + notSorted +"\n\n" +  "Afrer Sort: " + isSorted	);
	}
	
	public int compare(String first, String second) 
	{
		int f = first.length();
		int s = second.length();
		
		if(f < s)
		{
			return -1;
		}
		
		else if(f == s)
		{
			return 0;
		}
		
		else
		{
			return 1;
		}	
	}
}
