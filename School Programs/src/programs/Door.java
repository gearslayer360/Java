/*
 *Name: Brian Matthys
 *Date: 4/09/2013
 *Class: CSCI 1301
 *Section: 201
 *Name of Program: Door
 */

package programs;

public class Door 
{
	private String name =" ";
	private String state = " ";
	public static final String MANUFACTURER = "Doors inc.";
	
	public Door(String name, String state)
	{
		this.name = name;
		this.state = state;
	}
	
	public void open()
	{
		state = "Open";
	}
	
	public void close()
	{
		state = "Closed";
	}

	public String getName()
	{
		return name;
	}	
	
	public void setName(String name)
	{
		this.name = name;
	}

	public void setState(String state) 
	{
		this.state = state;
	}

	public String getState()
	{
		return state;
	}	
}
