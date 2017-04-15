package queues;

import java.util.*;

public class QueueRunner
{
	public static void main(String[] args)
	{
		
	Person samS = new Person("Sam", "Smith");
	Person charlieB = new Person("Charlie", "Black");
	Person bettyB = new Person("Betty", "Brown");
	Person jessicaS = new Person("Jessica", "Stewart");
	Person johnF = new Person("John", "Friday");
	Person frankF = new Person("Frank", "Foley");
	
	PriorityQueue<Person> personQ = new PriorityQueue<Person>();
	
	
	personQ.add(samS);
	personQ.add(charlieB);
	personQ.add(bettyB);
	personQ.add(jessicaS);
	personQ.add(johnF);
	personQ.add(frankF);
	
	System.out.println("Natural Order - first name's first letter has priority if it comes before the other...");

	while(personQ.size() > 0)
	{
		String p = personQ.poll().toString();
		System.out.println(p);
	}
	
	PriorityQueue<Person> personQLength = new PriorityQueue<Person>(6,new PersonComparator());
	
	personQLength.add(samS);
	personQLength.add(charlieB);
	personQLength.add(bettyB);
	personQLength.add(jessicaS);
	personQLength.add(johnF);
	personQLength.add(frankF);
	
	System.out.println("\nPriority Order Change - First names with least amount of letters have priority...");
	
	while(personQLength.size() > 0)	
	{
		String p = personQLength.poll().toString();
		System.out.println(p);
	}

 }
}

