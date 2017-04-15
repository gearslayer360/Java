package homework;

import java.util.NoSuchElementException;

import java.util.NoSuchElementException;

public class StackArray
{ 
	private Object[] item; 		
	private int open = 0;  	// The index of the first empty location in the stack
	private int size = 2;  	// The current number of item locations in the stack
	private int currentItems;	// The number of items in the stack

	public static void main(String[] args)
	{
		StackArray stack = new StackArray();
		
		System.out.println("Testing push method...\n");
		System.out.println("pushing A onto stack"); 
		stack.push("A");
		System.out.println("pushing B onto stack");
		stack.push("B");
		System.out.println("pushing C onto stack");
		stack.push("C");

		System.out.println("\nTesting pop method...\n");
		while (stack.size() > 0) 
		{
			System.out.println(stack.pop());
		}
	}
	
	public StackArray()
	{
		item = new Object[size];
	}

	public void push(Object element)
	{
		if(item.length == open)
		{
			Object[] newItem = new Object[open*2];

			for(int i = 0; i < item.length; i++)
			{
				newItem[i] = item[i];
			}
			item = newItem;
		}
		item[open] = element;
		open++;
		currentItems++;	
	}

	public Object pop()
	{
		if(isEmpty()) {throw new NoSuchElementException();}

		Object element = item[open-1];

		open--;
		currentItems--;
		return element;
	}

	public Object peek()
	{
		Object element = item[open-1];
		return element;
	}
	
	public int size()
	{
		return currentItems;
	}

	public boolean isEmpty()
	{
		return open == 0;
	}

	public String toString()
	{
		if (open == 0) { return "[]"; }
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
