package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DateSort implements Comparator<Date>
{
	static ArrayList<Date> dates = new ArrayList<Date>();
	
	public static void main(String[] args) throws Exception
	{
		int day, month, year;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a day: ");
		day = input.nextInt();
		System.out.println("Enter a month: ");
		month = input.nextInt();
		System.out.println("Enter a year: ");
		year = input.nextInt();
		
		Date date1 = new Date(day,month,year);
		dates.add(date1);
			
		
		System.out.println("Enter a day: ");
		day = input.nextInt();
		System.out.println("Enter a month: ");
		month = input.nextInt();
		System.out.println("Enter a year: ");
		year = input.nextInt();
		
		Date date2 = new Date(day,month,year);
		dates.add(date2);
		
		Collections.sort(dates, new DateSort());
		
	}

	public int compare(Date day1, Date day2)
	{
		for (int i = 0; i < dates.size(); i++)
		{
			Date theDate = dates.get(i);
			System.out.println(theDate);
		}
		
		return 0;
	}

	}

