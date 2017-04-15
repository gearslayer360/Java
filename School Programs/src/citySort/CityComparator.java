/*
 *Name: Brian Matthys
 *Date: 10/7/2013
 *Class: CSCI 1302
 *Section: 200
 */

package citySort;

import java.util.ArrayList;
import java.util.Comparator;

public class CityComparator implements Comparator<City>
{

	public int compare(City a, City b)
	{
		if (a.getState().charAt(0) < b.getState().charAt(0)) 
		{
			return -1;
		}
		
		else if (a.getState() == b.getState())
			{
				return 0;
			}
        
			else 
			{
				return 1;
			}
	}
}

