/*
 *Name: Brian Matthys
 *Date: 11/18/2013
 *Class: CSCI 1302
 *Section: 200
 */

package homework;

public class BtreeNode
{
	private String data; 
	private BtreeNode left, right; 

	public BtreeNode(String value)
	{
		data = value;
		left = null;
		right = null;
	}
	
	public BtreeNode(String value,BtreeNode l,BtreeNode r)
	{
		data = value;
		left = l;
		right = r;
	}

	public BtreeNode getLeft()
	{
		return left;
	}

	public BtreeNode getRight()
	{
		return right;
	}

	{

	}

	public void setLeft(BtreeNode newLeft)
	{
		left = newLeft;
	}

	public void setRight(BtreeNode newRight)
	{
		right = newRight;
	}

	public void setParent(BtreeNode newParent)
	{
		
	}

	public int size()
	{
		int countR = 0;

		while (right.left != null)
		{
			
		}
		return countR;
	}

	public int height()
	{
		int n = size();
		return n +2;
	}

	public boolean isEmpty()
	{
		return (left == null && right == null);
	}

	public boolean isLeaf()
	{
		return (this.left == null && this.right == null);
	}

	public boolean isLeftChild()
	{
		return false;
	}

	public boolean isRightChild()
	{
		return false;
	}

	public String getAnimalOrQuestion()
	{
		return this.data;
	}

	public void setAnimalName(String value)
	{
		this.data = value;
	}

	public void print()
	{
		System.out.println(data);
	}

	public String getData()
	{
		return data;
	}
	
	public void setData(String newQuestion)
	{
		data = newQuestion;
	}

}
