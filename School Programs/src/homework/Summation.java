/*
 *Name: Brian Matthys
 *Class: CSCI 1302
 *Section: 200
 */

package homework;

import java.util.*;
import javax.swing.JOptionPane;

public class Summation
{
	private static String sum;			
	private static String sum1; 	
	private static String sum2; 
	private static char[] unique;
	private static int[] nums;
	private static boolean solved;
	
	public static void main (String[] args)
	{
		String combo;
		
		sum1 = JOptionPane.showInputDialog(null, "Enter the first word");
		sum2 = JOptionPane.showInputDialog(null, "Enter the second word");
		sum = JOptionPane.showInputDialog(null, "Enter the summing word");
			
		combo = sum1 + sum2 + sum;
				
		Summation puzzle = new Summation(sum1, sum2, sum);
		
		puzzle.unique();
		System.out.println(puzzle.solve());
		while(puzzle.solve() == false)
		{
			int i = JOptionPane.showConfirmDialog(null, "Try Again?");
			if(i == JOptionPane.OK_OPTION)
			{
				puzzle.solve();
			}
			else
				System.exit(0);
		}
		System.out.println(puzzle.print());
	}
	
	public Summation(String word1, String word2, String sums)
	{
		sum1 = word1;
		sum2 = word2;
		sum = sums;
	}
	
	public boolean checkLeft(char[] uniqueChars, int[] num)
	{
		final char theFirst = sum1.charAt(0);
		final char theSecond = sum2.charAt(0);
		final char theThird = sum.charAt(0);
		boolean test = true;
		
		for(int i = 0; i < uniqueChars.length; i++)
		{
			if(uniqueChars[i] == theFirst && num[i] == 0)
			{
				test = false;
			}
			else if(uniqueChars[i] == theSecond && num[i] == 0)
			{
				test =  false;
			}
			else if(uniqueChars[i] == theThird && num[i] == 0)
			{
				test =  false;
			}
		}
		return test;
	}
	
	public int[] assign()
	{	
		Random r = new Random();
		nums = new int [unique.length];
		
		if((checkLeft(unique,nums) == true) && (checkOneToOne(nums) == true)){return nums;}
		else
		
		for(int i = 0; i < nums.length; i++)
		{
			nums[i] = r.nextInt(9);
		}
		checkOneToOne(nums);
		checkLeft(unique,nums);
		return nums;
	}
		
	public char[] unique()
	{
		String temp = sum1 + sum2 + sum;
		StringBuilder combos = new StringBuilder();
		
		for(int i = 0; i < temp.length(); i++)
		{
			String st = temp.substring(i, i+1);
			if(combos.indexOf(st) == -1)
			{
				combos.append(st);
			}
		}
		unique = combos.toString().toCharArray();	
		Arrays.sort(unique);
		return unique;
	}
	
	public boolean checkOneToOne(int[] num)
	{
		for(int i = 0; i < num.length; i++)
		{
			for(int j = i+1; j < num.length; j++)
			{
				if(num[i] == num[j])
				{
					assign();
					return false;
				}
			}
		}
		return true;
	}
		
	public String sumTheWords(char[] uniqueChars, int[] numbers, String t, String val)
	{
		final int end = t.length();	
		for(int i = 0; i < uniqueChars.length; i++)		
		{
			for(int j = 0; j < uniqueChars.length; j++)
			{
				if(t.equals("")){return val.substring(0,end);}	

				if(uniqueChars[j] == t.charAt(0))	
				{
					val = val + numbers[j];		
					t = t.substring(1, t.length());
					sumTheWords(uniqueChars, numbers, t,val);
				}
			}
		}
		return val.substring(0,end);
	}
	
	public boolean finalSum()
	{
		String summandVal1 = sumTheWords(unique, nums, sum1, "");
		String summandVal2 = sumTheWords(unique, nums, sum2, "");
		String sumWordVal = sumTheWords(unique, nums, sum, "");
		
		int sumVal1 = Integer.parseInt(summandVal1);
		int sumVal2 = Integer.parseInt(summandVal2);
		int sumVal = Integer.parseInt(sumWordVal);
		
		System.out.println(sumVal1 + "+ " + sumVal2 + " = " + sumVal + "      " + Arrays.toString(unique));
		System.out.println("Result: " + sumVal1 + sumVal2 + "     " + Arrays.toString(nums));

		if(sumVal1 + sumVal2 == sumVal)
			return solved = true;
		else
			return solved = false;
	}
	
	public boolean solve()
	{		
		assign();
		finalSum();
		
		if(solved == false)
		{
			try
			{
				solve();
			}
			
			catch(Exception e){}

			finally
			{
				return solved;
			}
		}
		else
			return solved;
		
	}
	
	public String print()
	{
		return Arrays.toString(assign()) + "\n" + Arrays.toString(unique());
	}
}