package programs;

import java.io.*;
import java.util.*;

public class FileArray
{
	public static int line;
	
	public static void main(String[] args) throws IOException
	{
		
		File file = new File("Sample.txt");
		Scanner inputFile = new Scanner(file);
		
		while(inputFile.hasNextInt())
		{
			line = Integer.parseInt(inputFile.next());
		}
		
		inputFile.close();
		
		printNum();
	}
	
	public static ArrayList<Integer> printNum()
	{
		ArrayList<Integer> num = new ArrayList<Integer>();
		num.add(line * 2);
		
		for(int i = 0; i <num.size(); i ++)
		{
			System.out.println(num);
		}
		
		return num;
	}
}


