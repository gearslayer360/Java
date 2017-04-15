/*
 *Name: Brian Matthys
 *Date: 11/18/2013
 *Class: CSCI 1302
 *Section: 200
 */

package trees;

import java.util.LinkedList;
import java.util.Queue;

import trees.BinarySearchTree.Node;

public class AverageValue 
{
	private double sum = 0;
	private int nodeCount = 0;
	private static Node root;

	 public void add(Comparable obj) 
	   {
	      int value = 2;
		  Node newNode = new Node(null, null, value);
	      newNode.data = obj;
	      newNode.leftNode = null;
	      newNode.rightNode = null;
	      
	      if (root == null)
	      {
	    	  root = newNode;
	      }
	      
	      else
	      {
	    	  root.addNode(newNode);
	      }
	   }
	
	public double treeAverage(Node node)
	{
	    if(node == null)
	    	{
	    		return Double.NaN;
	    	}

	    sum = treeSum(node);
	    double average = (sum/nodeCount);

	    sum = 0;
	    nodeCount = 0;

	    return average;

	}
	
	public double treeSum(Node node)
	{

	    nodeCount ++; 
	    sum = sum + node.getValue(); 
   
	    if(node.getLeftNode()!=null)
	    {
	        sum = treeSum(node.getLeftNode()); 
	    }
	    
	    if(node.getRightNode()!=null)
	    {
	        sum = treeSum(node.getRightNode());
	    }
	    return sum;
	}
		
		class Node 
		{
		    public Comparable data;
			private int value;
		    private Node leftNode;
		    private Node rightNode;

		    public void addNode(Node newNode)
		      {
		         int comp = newNode.data.compareTo(data);
		         
		         if (comp < 0)
		         {  
		            if (leftNode == null)
		            {
		            	leftNode = newNode;
		            }
		            
		            else
		            {
		            	leftNode.addNode(newNode);
		            }
		         }
		         
		         else if (comp > 0)
		         {  
		            if (rightNode == null)
		            {
		            	rightNode = newNode;
		            }
		            
		            else
		            {
		            	rightNode.addNode(newNode);
		            }
		         }
		      }
		    
		    public Node(Node leftNode, Node rightNode, int value)
		    {
		        this.leftNode = leftNode;
		        this.rightNode = rightNode;
		        this.value = value;
		    }

			public Node getRightNode()
			{
				return rightNode;
			}

			public Node getLeftNode()
			{
				
				return leftNode;
			}

			public double getValue()
			{
				return value;
			}
		}
		
		public static void main(String[] args)
		{
			AverageValue a = new AverageValue();
			
			a.add(1);
			a.add(2);
			a.add(3);
			
			System.out.println("The average value of the tree is " +a.treeAverage(root));
		}
	}
