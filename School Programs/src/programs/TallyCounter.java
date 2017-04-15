/*
 *Name: Brian Matthys
 *Date: 4/09/2013
 *Class: CSCI 1301
 *Section: 201
 *Name of Program: TallyCounter
 */

package programs;

public class TallyCounter
{
	private int value;
	private int max;
	
	public void count()
	{
		value++;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public void undo()
	{
		if(value > 0)
		{
		value --;
		}
	}
	
	public void setLimit(int maximum)
	{
		max = maximum;
	}
}
