package homework;

import java.util.Random;
public class ArrayHelp 
{
	private static Random r = new Random();

	public static Integer[] randomIntArray(int length, int n)
	{
		Integer[] ints = new Integer[length];
		for(int i = 0; i < ints.length; i++)
		{
			ints[i] = r.nextInt(n);
		}
		return ints;
	}

	public static<E> void swap(E[] a, int i, int j)
	{
		E temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}

