package homework;

public class Bank
{  
private int accountNumber;
private double balance;

public Bank(int anAccountNumber)
{   
   accountNumber = anAccountNumber;
   balance = 0;
}

public Bank(int anAccountNumber, double initialBalance)
{
	 accountNumber = anAccountNumber;
	   balance = initialBalance;
}


public void withdraw(double amount)
{   
   double newBalance = balance - amount;
   balance = newBalance;
}

public double getBalance()
{   
   return balance;
}

public void deposit(double amount)
{
	 double newBalance = balance + amount;
	   balance = newBalance;
	
}

public int getAccountNumber() 
{
	 return accountNumber;
}

}
