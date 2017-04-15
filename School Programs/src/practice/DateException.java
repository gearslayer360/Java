package practice;

public class DateException extends IllegalArgumentException 
{
	public DateException()
	{
		super();
		setMessage(super.getMessage() + "Months must be between 1 and 12." +
		"Days must be between 1 and 31. Don't forget about April, June, September" +
		" & November. Also, remember about February and leap years.");
	}

	public DateException(String m)
	{
		super();
		setMessage (super.getMessage() + m);
	}
	
	private void setMessage(String string)
	{
		
	}
}
