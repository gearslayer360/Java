/*
 *Name: Brian Matthys
 *Class: CSCI 1302
 *Section: 200
 */

package homework;

import java.awt.GridLayout;
import java.util.*;

import javax.swing.*;

public class Downsize
{
	static JPanel program;
	static JPanel names;
	public static void main(String[] args)
	{
		LinkedList<String> theNames = new LinkedList<String>();
		
		theNames.add("Brian");
		theNames.add("Tim");
		theNames.add("Joeseph");
		theNames.add("Bob");
		theNames.add("Steve");
	
		String input = JOptionPane.showInputDialog(null,namePanel(theNames),"Enter employee number:");
		removeEmployee(theNames, Integer.parseInt(input));	
		
		
		
		JOptionPane.showMessageDialog(null, "New List\n " + theNames.toString().replaceAll("[\\W]", "\n"));
	}
	
	public static void removeEmployee(LinkedList<String> employeeNames, int n)
	{
		employeeNames.remove(n-1);
	}
	
	public static JPanel namePanel(LinkedList<String> theNames)
	{		
		names = new JPanel(new GridLayout(theNames.size(),1));		
	
		for(int i = 0; i < theNames.size(); i++)
		{
			names.add(new JLabel(String.valueOf(i+1)));
			names.add(new JLabel(theNames.get(i)));
		}
		return names;
	}
}
