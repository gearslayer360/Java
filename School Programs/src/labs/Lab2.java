/*
 *Name: Brian Matthys
 *Date: 1/22/2013
 *Class: CSCI 1301
 *Section: 201
 *Name of Program: Lab2
 *Description: Execute the program below. Each invocation of println outputs an arithmetic expression. 
 * The first two println commands are followed by comments that describe the operations that occur in each expression.
 * Complete the program by adding a comment after each println statement that describes all the arithmetic operations 
 * that occur when evaluating the expression that is printed. 
 */

package labs;

public class Lab2 
{
	public static void main(String[] args)
	{
		      int a = 3;
		      int b = 4;
		      int c = 5;
		      int d = 17;
		      System.out.println((a + b)/ c);
		      // 3 and 4 are added with sum 7
		      // 7 is divided by 5 with quotient 1
		      System.out.println(a + b / c);
		      // 4 is divided by 5 with quotient 0
		      // 3 is added to 0 with sum 3
		      System.out.println(a++);
		      //3 is added with 1 for a sum of 4
		      System.out.println(a--);
		      //1 is subtracted with 3 for a difference of 2
		      System.out.println(a + 1);
		      //3 is added with 1 for a sum of 4
		      System.out.println(d % c);
		      //17 is modulus divided with 5 for a quotient of 3 and a remainder of 2
		      System.out.println(d / c);
		      //17 is divided with 5 for a quotient of 3
		      System.out.println(d % b);
		      //17 is modulus divided with 4 for a quotient of 4 and a remainder of 1
		      System.out.println(d / b);
		      //17 is divided with 4 for a quotient of 4
		      System.out.println(d + a / d + b);
		      //3 is divided by 17 for a quotient of 0 and added with 4 and 17 fora a sum of 21
		      System.out.println((d + a) / (d + b));
		      //17 is added with 3 for a sum of 20, 
		      //then divided by the sum of 17 and 4 which is 21, for a quotient of 0
		      System.out.println(Math.sqrt(b));
		      //the square root of 4 is taken, leaving 2
		      System.out.println(Math.pow(a, b));
		      //3 is raised to the power of 4, for an answer of 81
		      System.out.println(Math.abs(-a));
		      //this prints the absolute value of -3, which is 3
		      System.out.println(Math.max(a, b));
		      //this compares two numbers, 3 and 4, and prints the larger value 4
		      
		   }
	}
