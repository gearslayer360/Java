package programs;

import java.util.Arrays;

public class DiagonalArray
{
	public static void main(String[] args)
	{
		int scores[][] = { {88, 80, 79, 92}, {75, 84,93, 80}, {98, 95, 92, 94} , {91, 84, 88, 96} };
		
		for(int i = 0; i< scores.length; i++)
		{
			System.out.println(scores[i][i]);
		}
	}
}
