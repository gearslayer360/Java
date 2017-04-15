package queues;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Person implements Comparable<Person>
{
   private String firstName;
   private String lastName;
   
   public Person(String firstName, String lastName)
   {
      this.firstName = firstName;
      this.lastName = lastName;
   }

   public String getFirstName() { return firstName; }

   public String getLastName() { return lastName; }

   public String toString()
   {
      return "Name: " + firstName + " " + lastName;
   }
   public int compareTo(Person p)
   {
      String pname1 = firstName + lastName;
      String pname2 = p.firstName + p.lastName;
      return pname1.compareTo(pname2);
   }	
}
