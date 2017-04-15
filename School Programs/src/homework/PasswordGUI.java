/*
 *Name: Brian Matthys
 *Date: 8/31/2013
 *Class: CSCI 1302
 *Section: 200
 */

package homework;

import java.lang.String;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PasswordGUI extends JFrame
{
	//all variables and fields needed for the program
		static String theUser;
		static String line;
		static String thePassword;
		static String userText;
		static char[] passText;
		static int incorrect;
		static JFrame frame = new JFrame();
		static JPanel panel = new JPanel();
		static JButton enter = new JButton();
		static JButton exit = new JButton();
		static JTextField username = new JTextField(7);
		static JPasswordField password = new JPasswordField(7);
		static JLabel name = new JLabel("Enter username:");
		static JLabel pass = new JLabel("Enter password:");
		static PasswordGUI game = new PasswordGUI();
	
	public static void main (String[]args) throws IOException
	{
		setUp();
		exit();
		enter();
		password();
		
	}
	
	//set up the GUI and its properties
		public static void setUp()
		{		
			final int WIDTH = 600;
			final int HEIGHT = 400;
					
			enter.setText("Enter");
			panel.add(enter);
			exit.setText("Exit");
			panel.add(exit);
			panel.add(name);
			panel.add(username);
			panel.add(pass);
			panel.add(password);
			frame.add(panel);
			
			frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			frame.setSize(WIDTH, HEIGHT);
			frame.setVisible(true);
			frame.setTitle("PasswordGUI");
			frame.setLocationRelativeTo(null);
		}
			
		 /* Reads the file users.txt to find out the username and password.
		 *  Sets the first word up until the space equal to the username
		 *  and the next word after the space to the password. The current username is Brian 
		 *  and the password is Matthys.
		 */
	public static void password() throws FileNotFoundException
	{
		String line;
		File file = new File("Users");
		Scanner inputFile = new Scanner(file);
		
		while(inputFile.hasNextLine())
		{
			line = inputFile.nextLine();
			
			int i = 0;
			while(!Character.isWhitespace(line.charAt(i))) {i++;}
			
			theUser = line.substring(0, i);
			thePassword = line.substring(i+1);
			break;
		}
		
		inputFile.close();
	}
	
	public static void enter()
	{
	//Action listener for Enter Button
			enter.addActionListener(new ActionListener()
			{
				/*
				 *Logic for the enter button. It takes the text in the username and password
				 *textfields and sets them equal to a string to be compared to the actual username and password.
				 *If they are both correct, it displays a welcome message. If incorrect, it displays an 
				 *error message and then the user has up to 3 tries to get it correct. After three unsuccessful tries
				 *a different error message pops up saying access denied because you used all 3 attempts. It then exits 
				 *the program.
				 */
				public void actionPerformed(ActionEvent e)
				{	
				   userText = username.getText();
				   passText = password.getPassword();
				   
				   thePassword = new String(passText);
					
				   if(userText.equalsIgnoreCase(theUser) && isPasswordCorrect(passText))
				      {
					   frame.hide();
					   JOptionPane.showMessageDialog(null,"Welcome","Accepted Username and Password",JOptionPane.WARNING_MESSAGE);
					   System.exit(0);
				      }   
				     
				     else if ((!userText.equalsIgnoreCase(theUser) && !isPasswordCorrect(passText) || userText.equalsIgnoreCase(theUser) && !isPasswordCorrect(passText)
				    	 || !userText.equalsIgnoreCase(theUser) && isPasswordCorrect(passText)))
				      {
				    	 JOptionPane.showMessageDialog(null,"Invalid Username or Password. Try again.","Warning",JOptionPane.WARNING_MESSAGE);
				    	 incorrect ++;
				      }
				   
				      if(incorrect >2)
				      {
				    	  JOptionPane.showMessageDialog(null,"All attempts used. Access Denied.","Warning",JOptionPane.WARNING_MESSAGE);
				    	  System.exit(0);
				      }
				      }
			});
	}
	
	private static boolean isPasswordCorrect(char[] inputPassword)
	{
		char[] passtext = { 'M', 'a', 't', 't', 'h', 'y', 's' };
		
		if (inputPassword.length != passtext.length)
		{
			// Return false if lengths are unequal
			return false; 
		}
			
		for (int i = 0; i < inputPassword.length; i++)
			if (inputPassword[i] != passtext[i])
				return false;
		return true;
	}
		
	public static void exit()
	{
	//Action listener for exit Button
			exit.addActionListener(new ActionListener()
			{
				//exits the program
				public void actionPerformed(ActionEvent e)
				{	
					System.exit(0);
				}
			});
	}
}