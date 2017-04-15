/*
 *Name: Brian Matthys
 *Date: 2/26/2013
 *Class: CSCI 1301
 *Section: 201
 *Name of Program: RowFun
 *Description: Reuse makeRow to write a method called printUpTriangle that is passed two arguments, an int n and a String s.
 *It should print a right triangle in which the base of the triangle is made  of n copies of s,
 * and the vertex of the triangle has a single copy of s on the right. );
 * For example, calling printUpTriangle(13, "*" ) prints the following lines:

            *
           **
          ***
         ****
        *****
       ******
      *******
     ********
    *********
   **********
  ***********
 ************
*************
Write a main method that calls printUpTriangle(13, "*").
 */

package labs;

public class RowFun2
{
	public static void main(String[] args)
	{		
		printUpTriangle(13, "*");
	}
	
	public static String makeRow(int n, String s)
	{
		for(int i = n; i>0; i--)
		{
			System.out.print(s);
		}
		return s;
	}
	
	public static void printUpTriangle(int n, String s)
	{
		for(int i = 1; i<=n; i++)
		{
			for(int j=i; j<n; j++)
			{
				System.out.print(" ");
			}
			
			System.out.println(makeRow(i-1, s));
		}
	}
}
