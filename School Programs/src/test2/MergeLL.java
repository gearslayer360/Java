package test2;

import javax.swing.JButton;

public class MergeLL {

    public static Node merge(Node n1, Node n2)
    {
    	    if (n1 == null)
    	    {
    	    	return n2;
    	    }
    	    
    	    if (n2 == null)
    	    {
    	    	return n1;
    	    }

    	    if (n1.value < n2.value)
    	    {
    	        n1.next = merge(n1.next, n2);
    	        return n1;
    	    }
    	    
    	    else
    	    {
    	        n2.next = merge(n2.next, n1);
    	        return n2;
    	    }
    	}
    
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n3 = new Node(3);
        Node n5 = new Node(5);
        Node n7 = new Node(7);
        Node n9 = new Node(9);

        n1.next = n3;
        n3.next = n5;
        n5.next = n7;
        n7.next = n9;
        n9.next = null;

        Node n2 = new Node(2);
        Node n4 = new Node(4);
        Node n6 = new Node(6);
        Node n8 = new Node(8);
        Node n10 = new Node(10);

        n2.next = n4;
        n4.next = n6;
        n6.next = n8;
        n8.next = n10;
        n10.next = null;

        System.out.println("Merge : " + merge(n1, n2));
    }
}

class Node {

    Node next;
    int value;

    Node(int val) {
        this.value = val;
        this.next = null;
    }

    @Override
    public String toString() {
        Node cur = this;
        String str = "";

        while(cur != null) {
            str += cur.value+"->";
            cur = cur.next;
        }

        return str;
    }
}

 ObjectInputStream in = new ObjectInputStream(
 new FileInputStream(f));
 firstBankOfJava = (Bank) in.readObject();
 in.close();
 
 