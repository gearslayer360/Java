//Test exception handling in the Date Class

package practice;

public class Birthday
{
	public static void main(String[] args) throws Exception
	{
		Date myBirthday;
		
		//variables for user input
		String dateString = new String();
	    int myMonth = 1;
		int myDay = 1;
		int myYear = 1900;
		boolean isValidDate;
		
		do 
		{
			//get user input and create date object
			
			//more code here
			isValidDate = true;
			try
			{
				myBirthday = new Date(myMonth, myDay, myYear);
			}
			catch(IllegalArgumentException e)
			{
				//bad input data must redo
				isValidDate = false;
				System.out.println("Bad Date, please re-enter");
			}
		}
		while(!isValidDate);	
	}
}
