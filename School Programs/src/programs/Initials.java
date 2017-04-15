package programs;

/* Brian Matthys
 * Date: October 20, 2010
 * Period:05
 */

import java.util.Scanner;

public class Initials
{
  public static void main (String[] args)
  {
    String name, first, last;
    
     Scanner input = new Scanner(System.in);
     
     System.out.println("Enter your name: ");
     name=input.nextLine();
     
     first = name.substring(0, name.indexOf(" "));
     last = name.substring(first.length() + 1 , name.length());
     
     System.out.print(name.charAt(0));
     System.out.print(last.charAt(0));
  }
}
