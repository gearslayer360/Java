package programs;

import java.io.*;
import java.util.*;

public class FilePractice
{
	public static void main(String[] args) throws IOException
	{
		String line;
		File file = new File("Sample.txt");
		Scanner inputFile = new Scanner(file);
		
		while(inputFile.hasNext())
		{
			line = inputFile.nextLine();
			System.out.println(line);
		}
		
		inputFile.close();
	}
}
