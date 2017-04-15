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

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankAccountGUI extends JFrame
{
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JButton deposit = new JButton();
	static JButton withdraw = new JButton();
	static JTextField text = new JTextField(5);
	static JLabel accountBalance = new JLabel("Balance : $0.00 ");
	public static double balance;
	public static double amount;
	
	static BankAccount account = new BankAccount();
	
	public static void main (String[] args)
	{
		setUp();
	}
	
	//set up the GUI properties
	public static void setUp()
	{		
		final int WIDTH = 400;
		final int HEIGHT = 300;
				
		deposit.setText("Deposit");
		panel.add(deposit);
		withdraw.setText("Withdraw");
		panel.add(withdraw);
		panel.add(text);
		panel.add(accountBalance);
		frame.add(panel);
		
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setTitle("Bank Account");
		frame.setLocationRelativeTo(null);
		
		//Action listener for withdraw Button
		withdraw.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{	
				amount = Double.parseDouble(text.getText());
				
				if(account.getBalance() - amount <0)
				{
					JOptionPane.showMessageDialog(null, "Insufficient Funds");
				}
				
				else
				{
					account.withdraw(amount);
					accountBalance.setText("Balance : $ " + account.getBalance());
				}
			}
		});
		
		//Action listener for deposit Button
		deposit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{	
				amount = Double.parseDouble(text.getText());
				account.deposit(amount);
				accountBalance.setText("Balance : $ " + account.getBalance());
			}
		});
	}
}
