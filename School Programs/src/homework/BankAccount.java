/*
 *Name: Brian Matthys
 *Date: 4/23/2013
 *Class: CSCI 1301
 *Section: 201
 *Name of Program: BankAccount
 *Description: Write a graphical application simulating a bank account.
 *Supply text fields and buttons for depositing and withdrawing money,
 *and for displaying the current balance in a label.
 */

package homework;

public class BankAccount 
{
	private double balance;
	
	/*
	Makes a deposit into this account.
	*/
	public void deposit(double amount) 
	{
		balance += amount;
	}
	
	/*
	Makes a withdrawal from this account, or charges a penalty if
	sufficient funds are not available.
	*/
	public void withdraw(double amount)
	{
		balance -= amount;
	}
	
	/*
	Gets the current balance of this bank account.
	*/
	
	public double getBalance() 
	{
		return balance;
		
	}
	
}
