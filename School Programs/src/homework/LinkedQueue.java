package homework;

import java.util.NoSuchElementException;
import java.util.LinkedList;

public class LinkedQueue 
{
	private Node last;			
	private Node first;			
	private int currentSize;
	
	public static void main(String[] args)
	{
		LinkedQueue q = new LinkedQueue();

		q.add("A");
		q.add("B");
		q.add("C");
		q.add("D");
		q.add("E");
		
		while(q.size() > 0)
		{
			int size = q.size();
			System.out.println("Removing " + q.remove() + " Current size: " + size);
		}
		
		q.add("1");
		q.add("2");
		q.add("3");
		q.add("4");
		q.add("5");
		
		q.lastToFirst();
		while(q.size() > 0)
		{
			System.out.println(q.remove());
		}
	
		q.add("A");
		q.add("B");
		q.add("C");
		q.add("D");
		q.add("E");
			
		q.firstToLast();
		while(q.size() > 0)
		{
			System.out.println(q.remove());
		}
		
		System.out.println("\nQueue empty? - " + q.isEmpty());
	}

	public LinkedQueue()
	{
		last = null;
		first = null;
	}

	public void add(Object element)
	{
		Node newNode = new Node();
		if(isEmpty()) {first = newNode;}
		else 
		{
			last.next = newNode;
			newNode.previous = last;
		}
		newNode.data = element;
		last = newNode;
		currentSize++;	
	}

	public Object remove()
	{
		if(last == null) {throw new NoSuchElementException();}
		Object element = first.data; 
		first = first.next; 
		currentSize--;	
		return element;
	}

	public boolean isEmpty()
	{
		return first == null;
	}

	public int size()
	{
		return currentSize;
	}
	
	public void firstToLast()
	{
		Object temp = first.data;	
		remove();
		add(last.data);
		last.data = temp;			
	}
	
	public void lastToFirst()
	{
		for(int i = 1; i < currentSize; i++)
		{
			Object temp = remove();
			add(temp);
		}
	}

	class Node
	{  
		public Object data;
		public Node next;
		public Node previous;
	}
}
