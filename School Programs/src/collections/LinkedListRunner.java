/*
 *Name: Brian Matthys
 *Date: 10/7/2013
 *Class: CSCI 1302
 *Section: 200
 */

package collections;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListRunner 
{
	public static void main(String[] args)
	{
		LinkedList<String> list = new LinkedList<String>();
		
		list.addFirst("aaa");
		list.addLast("bbb");
		list.addLast("ccc");
		list.addLast("ddd");
		list.addLast("eee");
		list.addLast("fff");
		list.addLast("ggg");
		list.addLast("hhh");
		list.addLast("iii");
		
		ListIterator<String> iterator = list.listIterator();
		
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		
		System.out.println();
		
		while(iterator.hasPrevious())
		{			
			System.out.println(iterator.previous());
		}
		
		while(iterator.hasNext())
		{
			if((iterator.next().startsWith("a")) || (iterator.previous().startsWith("e")) || (iterator.next().startsWith("i")))
			{
				iterator.remove();
			}
		}
		
		System.out.println("\nList with removed vowels: ");
		
		System.out.println(list);
		}
	}
