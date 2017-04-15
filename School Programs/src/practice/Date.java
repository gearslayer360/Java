package practice;

public class Date 
{
	int month;
	int day;
	int year;
	
	//default value constructor
	public Date()
	{
		month = 1;
		day = 1;
		year = 1900;
	}
	
	//explicit value constructor
	public Date(int m, int d, int y) throws Exception
	{
	
		month = m;
		day = d;
		year = y;
	}

	private boolean isLeapYear(int y) 
	{
		return false;
	}
	
}
