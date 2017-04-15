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

public class CitySortDemo2 
{
	static ArrayList<City> city = new ArrayList<City>();
	
	static String theCity;
	static String theState;
	
	public static void main(String[] args) throws FileNotFoundException
	{
		
		City atlanta = new City("Atlanta", "Georgia");
		City austin = new City("Austin", "Texas");
		City montgomery = new City("Montgomery", "Alabama");
		City norcross = new City("Norcross", "Georgia"); 
		City sacremento = new City("Sacremento", "California");
		
		city.add(atlanta);
		city.add(austin);
		city.add(montgomery);
		city.add(norcross);
		city.add(sacremento);
		
		Collections.sort(city, new CityComparator());
		
		System.out.println(city.toString());
		
	}
}
