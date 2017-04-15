/*
 *Name: Brian Matthys
 *Date: 8/28/2013
 *Class: CSCI 1302
 *Section: 200
 */

package homework;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TheNameGame extends JFrame
{
	//all variables and fields needed for the program
	static int firstVowel;
	static String root;
	static String name1;
	static String name2;
	static String name3;
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JButton lyrics = new JButton();
	static JButton clear = new JButton();
	static JButton exit = new JButton();
	static JTextField name = new JTextField(5);
	static JLabel song = new JLabel("Hello, enter a name to start:");
	static TheNameGame game = new TheNameGame();
	
	public static void main(String[] args)
	{
		//run all available methods the GUI can perform and wait for actions
		setUp();
		generateLyrics();
		clear();
		exit();
	}
	
	//set up the GUI and its properties
	public static void setUp()
	{		
		final int WIDTH = 600;
		final int HEIGHT = 400;
				
		lyrics.setText("Generate Lyrics");
		panel.add(lyrics);
		clear.setText("Clear");
		panel.add(clear);
		exit.setText("Exit");
		panel.add(exit);
		panel.add(name);
		panel.add(song);
		frame.add(panel);
		
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setTitle("Name Game");
		frame.setLocationRelativeTo(null);
	}
	
	public static void generateLyrics()
	{
		//Action listener for generate lyrics button
				lyrics.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{	
						name1 = name.getText();
						name2 = "";
						
						//loops through the name entered to check for the first vowel
						for(int i = 0; i < name1.length(); i++)
						{
							 name2 += name1.charAt(i);
							
							 //if a vowel is found, save the location where it is found in an integer firstVowel and stop the loop
								 if(name2.charAt(i) == 'a' || name2.charAt(i) == 'A' || name2.charAt(i) == 'e' || name2.charAt(i) == 'E' ||
										 name2.charAt(i) == 'i' || name2.charAt(i) == 'I' || name2.charAt(i) == 'o' ||
												 name2.charAt(i) == 'O' || name2.charAt(i) == 'u' || name2.charAt(i) == 'U')
								 { 
									 firstVowel = i;
									 break;
								 }						      
						 }
						
							//this is the new name for the song with only the part
						    //of the name after the first vowel so the lyrics are correct
							name3 = name1.substring(firstVowel, name1.length());
							
							//First case of generating song lyrics assuming no names that would generate a cuss word in the lyrics and assuming the
							//first letter of the name is not b,B,f,F,m, or M 
							if (!name1.substring(1).equalsIgnoreCase("uck") && !name1.substring(1).equalsIgnoreCase("hit") && !name1.substring(1).equalsIgnoreCase("itch")
									&& !(name1.indexOf('b') == 0 || name1.indexOf('B') == 0) && !(name1.indexOf('f') == 0 || name1.indexOf('F') == 0) &&
									!(name1.indexOf('m') == 0 || name1.indexOf('M') == 0))
							{
								song.setText(name1 + "! " + name1 + ", "+ name1 + " bo"+
										" B" + name3 + " Banana fanna fo F" + name3 + " Fee fy mo M"
										+ name3 + ", " + name1 + "!");
							}
							
							//Second case of generating song lyrics assuming no names that would generate a cuss word in the lyrics and assuming the
							//first letter of the name is either b or B 
							else if(name1.indexOf('b') == 0 || name1.indexOf('B') == 0 &&!name1.substring(1).equalsIgnoreCase("uck") && !name1.substring(1).equalsIgnoreCase("hit")
									&& !name1.substring(1).equalsIgnoreCase("itch"))
							{
								song.setText(name1 + "! " + name1 + ", "+ name1 + " bo " + name1.substring(1) +
										" Banana fanna fo F" + name3.substring(0) + " Fee fy mo M"
										+name3.substring(0) + ", " + name1 + "!");
							}
							
							//Third case of generating song lyrics assuming no names that would generate a cuss word in the lyrics and assuming the
							//first letter of the name is either f or F
							else if(name1.indexOf('f') == 0 || name1.indexOf('F') == 0 &&!name1.substring(1).equalsIgnoreCase("uck") && !name1.substring(1).equalsIgnoreCase("hit")
									&& !name1.substring(1).equalsIgnoreCase("itch"))
							{
								song.setText(name1 + "! " + name1 + ", "+ name1 + " bo B" + name3.substring(0) +
										" Banana fanna fo " + name1.substring(1) + " Fee fy mo M"
										+name3.substring(0) + ", " + name1 + "!");
							}
							
							//Fourth case of generating song lyrics assuming no names that would generate a cuss word in the lyrics and assuming the
							//first letter of the name is either m or M
							else if(name1.indexOf('m') == 0 || name1.indexOf('M') == 0 &&!name1.substring(1).equalsIgnoreCase("uck") && !name1.substring(1).equalsIgnoreCase("hit")
									&& !name1.substring(1).equalsIgnoreCase("itch"))
							{
								song.setText(name1 + "! " + name1 + ", "+ name1 + " bo B" + name3.substring(0) +
										" Banana fanna fo " + name3.substring(0) + " Fee fy mo "
										+name1.substring(1) + ", " + name1 + "!");
							}
							
							//Catch all for all cases failing the specified conditions above, including names that WOULD generate cuss words in the song
								else
									{
										song.setText("Error!\nThe name " + name1 + " cannot be used");
									}
					}
				});
	}
	
	public static void clear()
	{
	//Action listener for clear Button
			clear.addActionListener(new ActionListener()
			{
				//resets the JLabel to the default text
				public void actionPerformed(ActionEvent e)
				{	
					song.setText("Hello, enter a name to start:");
				}
			});
			
	}
	
	public static void exit()
	{
	//Action listener for clear Button
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

