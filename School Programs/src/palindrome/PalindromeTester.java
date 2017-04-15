package palindrome;

import java.util.Stack;

public class PalindromeTester
{
	static Stack<Character> palindrome; 
	static char reversed;
	static String theReverse;
		
	public static boolean isPalindrome(String str)
	{
		palindrome = new Stack<Character>();
		theReverse = "";
		
		for(int i = 0; i < str.length(); i++)
		{
			palindrome.push(str.charAt(i));
		}		
		
		System.out.println();
		
		while(palindrome.size() > 0)
		{
			
			reversed = palindrome.pop();
			theReverse += reversed;
			System.out.println(theReverse.toString());
		}
		
		if(str.equalsIgnoreCase(theReverse))
		{
			return true;
		}
		
		else
		{
			return false;
		}
		
	}
}
