package homework;

import java.util.NoSuchElementException;

public class Deque
{
	private Object[] buffer;
	private int currentSize;
	private int head;
	private int tail;
	
	public static void main(String[] args)
	{
		Deque q = new Deque();
		
		System.out.println("addLast - A, B, C, D");
		q.addLast("A");
		q.addLast("B");
		q.addLast("C");
		q.addLast("D");
		
		System.out.println();
		while(q.size() > 0)
		{
			System.out.println(q.removeFirst());
		}
		
		System.out.println();
		System.out.println("addFirst - 1, 2, 3");
		q.addFirst("1");
		q.addFirst("2");
		q.addFirst("3");
		
		System.out.println();
		while(q.size() > 0)
		{
			System.out.println(q.removeLast());
		}
	}
	
	public Deque()
	{
		final int INITIAL_SIZE = 10;
		buffer = new Object[INITIAL_SIZE];
		currentSize = 0;
		head = 0;
		tail = 0;
	}
	
	public boolean isEmpty()
	{
		return currentSize == 0;
	}

	public void addFirst(Object element)
	{
		if(element == null) {throw new NullPointerException();}
		growBufferIfNeccessary();
		currentSize++;
		buffer[head] = element;
		head = (head + 1) % buffer.length;
	}

	public void addLast(Object element)
	{
		if(element == null) {throw new NullPointerException();}
		growBufferIfNeccessary();
		currentSize++;
		buffer[tail] = element;
		tail = (tail + 1) % buffer.length;
	}

	public Object removeFirst()
	{
		if(currentSize == 0) {throw new NoSuchElementException();}
		Object removed = buffer[head];
		head = (head + 1) % buffer.length;
		currentSize--;						
		return removed;
	}
	
	public Object removeLast()
	{
		if(currentSize == 0) {throw new NoSuchElementException();}
		Object removed = buffer[tail];
		tail = (tail + 1) % buffer.length;
		currentSize--;					
		return removed;
	}

	public int size()
	{
		return currentSize;
	}
	
	private void growBufferIfNeccessary()
	{
		if(currentSize == buffer.length)
		{
			Object[] newBuffer = new Object[2 * buffer.length];
			for(int i = 0; i < buffer.length; i++)
			{
				newBuffer[i] = buffer[(head + i) % buffer.length];
			}
			buffer = newBuffer;
			head = 0;
			tail = currentSize;
		}
	}
}
