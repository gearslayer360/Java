/*
 *Name: Brian Matthys
 *Date: 10/7/2013
 *Class: CSCI 1302
 *Section: 200
 */

package citySort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CitySortDemo
{
	static ArrayList<String> city = new ArrayList<String>();
	//static ArrayList<String> state = new ArrayList<String>();
	
	static String theCity;
	//static String theState;
	
	public static void main(String[] args) throws FileNotFoundException
	{
		String line;
		File file = new File("Cities.txt");
		Scanner inputFile = new Scanner(file);
	
		while(inputFile.hasNextLine())
		{
			line = inputFile.nextLine();
		
			int i = 0;
			while(!Character.isWhitespace(line.charAt(i))) {i++;}
		
			theCity = line.substring(0, i);
			//theState = line.substring(i+1);
			
			city.add(theCity);
			//state.add(theState);
		}
	
		inputFile.close();
		
		Collections.sort(city);
		
		for(int i = 0; i<city.size(); i++)
		{
			System.out.println("City: " + city.get(i));
		}

	}
		
}
