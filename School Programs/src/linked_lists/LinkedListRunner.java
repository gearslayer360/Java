package linked_lists;

public class LinkedListRunner
{
   public static void main(String[] args)
   {
       CircularLinkedList myList = new CircularLinkedList();
       myList.addFirst("aaa");
       myList.addFirst("bbb");
       myList.addFirst("ccc");
       myList.addFirst("ddd");
       System.out.println(myList);
       System.out.println("Removed element:  " + myList.removeFirst());
       System.out.println("Removed element:  " + myList.removeFirst() + "\n");
       System.out.println(myList);
       
       ListIterator iterator = myList.listIterator();
   }
}

