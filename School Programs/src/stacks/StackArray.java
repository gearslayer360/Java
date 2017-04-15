package stacks;

import java.util.NoSuchElementException;

public class StackArray
{ 
	private Object[] item; // The array where elements are stored
	private Object[] temp;
	private int open = 0;  // The index of the first empty location in the stack
	private int size = 2;  // The current number of item locations in the stack

	/**
      Constructs an empty stack.
	 */
	public StackArray()
	{
		item = new Object[size];
	}

	public void push(Object element)
	{
		if(open == size)
		{
			System.out.println("Resizing array: --");
			resize(item);
		}
		item[open] = element;
		open++;
	}

	public Object pop()
	{
		if(open == 0)
		{
			throw new NoSuchElementException();
		}

		Object temp = item[open];
		item[open] = null;
		open--;
		return temp;  
	}

	public Object peek()
	{
		return item[open - 1];
	}

	public void resize(Object obj)
	{
		int newSize = size * 2;
		temp = new Object[newSize];

		for(int i = 0; i < size; i ++)
		{
			temp[i] = item[i];
		}
		
		size = newSize;
		item = temp;
		item[open] = obj;
	}

	public boolean isEmpty()
	{
		return open == 0;
	}

	public String toString()
	{
		if (open == 0)
		{
			return "[]";
		}

		String temp = "[" + item[0];
		int i = 1;

		while (i < open)
		{
			temp = temp + ", " + item[i];
			i = i + 1;
		}

		temp = temp + "]";
		return temp;
	}  
}

