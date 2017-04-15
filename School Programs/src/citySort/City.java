/*
 *Name: Brian Matthys
 *Date: 10/7/2013
 *Class: CSCI 1302
 *Section: 200
 */

package citySort;

public class City implements Comparable<City>
{
	String city;
	String state;
	
	public City(String c, String s)
	{
		city = c;
		state = s;
	}

	public int compareTo(City o)
	{
		return 0;
	}
	
	public String toString()
	{
		return city + " " + state;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public String getState()
	{
		return state;
	}
	
}
