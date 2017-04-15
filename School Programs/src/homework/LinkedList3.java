package homework;

import java.util.NoSuchElementException;
import java.util.Iterator;

public class LinkedList3 <T> implements Iterable<T> 
{
	private Node first;
	private int currentSize; 

	public static void main(String[] args)
	{
		LinkedList3<Integer> nums = new LinkedList3<Integer>();	
		
		for(int i = 0; i <= 10; i++)
		{
			nums.addFirst(i);
		}
		
		while(nums.size() > 0)
		{
			System.out.print(nums.removeFirst() + " ");
		}
		System.out.println();
		
		LinkedList3<Character> characters = new LinkedList3<Character>();	
		characters.addFirst('A');
		characters.addFirst('B');
		characters.addFirst('C');
		characters.addFirst('D');
		characters.addFirst('E');
		
		System.out.println();
		while(characters.size() > 0)
		{
			System.out.print(characters.removeFirst() + " ");
		}
		System.out.println();
		
		LinkedList3<String> str = new LinkedList3<String>();	
		str.addFirst("Book");
		str.addFirst("Water");
		str.addFirst("Queue");
		str.addFirst("Linked List");
		str.addFirst("Computer");
	
		System.out.println();
		while(str.size() > 0)
		{
			System.out.print(str.removeFirst() + " ");
		}
	}
	
	public LinkedList3()
	{
		first = null;
	}

	public Object getFirst() 
	{
		if (first == null)
		{
			throw new NoSuchElementException();
		}
		return first.data;
	}

	public Object removeFirst()
	{
		currentSize--; 
		if (first == null) 
		{
			throw new NoSuchElementException();
		}
		Object element = first.data;
		first = first.next;
		return element;
	}

	public void addFirst(Object element)
	{
		currentSize++; 
		Node newNode = new Node();
		newNode.data = element;
		newNode.next = first;
		first = newNode;
	}

	public int size() {
		return currentSize;
	}

	public boolean contains(Object obj) {
		Node tempNode = first;
		
		for (int i = 0; i < currentSize; i++) 
		{
			if (obj.equals(tempNode.data)) 							
			{
				return true; 
			}
			tempNode = tempNode.next; 
		}
		return false;
	}

	public ListIterator listIterator() 
	{
		return new LinkedListIterator<T>();
	}

	class Node 
	{
		public Object data;
		public Node next;
	}

	class LinkedListIterator<T> implements ListIterator
	{
		private Node position;
		private Node previous;
		private boolean isAfterNext;

		
		public LinkedListIterator()
		{
			position = null;
			previous = null;
			isAfterNext = false;
		}

		public Object next()
		{
			if (!hasNext())
			{
				throw new NoSuchElementException();
			}
			previous = position; 
			isAfterNext = true;

			if (position == null) 
			{
				position = first;
			}
			
			else 
			{
				position = position.next;
			}
			return position.data;
		}

		public boolean hasNext() 
		{
			if (position == null) 
			{
				return first != null;
			}
			
			else 
			{
				return position.next != null;
			}
		}

		public void add(Object element)
		{
			currentSize++; 
							
			if (position == null)
			{
				addFirst(element);
				position = first;
			}
			
			else
			{
				Node newNode = new Node();
				newNode.data = element;
				newNode.next = position.next;
				position.next = newNode;
				position = newNode;
			}
			isAfterNext = false;
		}

		public void remove()
		{
			currentSize--;
							
			if (!isAfterNext)
			{
				throw new IllegalStateException();
			}

			if (position == first)
			{
				removeFirst();
			}
			
			else 
			{
				previous.next = position.next;
			}
			position = previous;
			isAfterNext = false;
		}

		public void set(Object element)
		{
			if (!isAfterNext)
			{
				throw new IllegalStateException();
			}
			position.data = element;
		}
	}

	@Override
	public Iterator<T> iterator()
	{
		return null;
	}
}
