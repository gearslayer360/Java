package queues;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person>
{
	public int compare(Person a, Person b)
	{
		if(a.getFirstName().length() < b.getFirstName().length())
		{
			return -1;
		}
		else if(a.getFirstName().length() == b.getFirstName().length())
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
}




