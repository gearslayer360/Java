package homework;

import java.io.IOException;
import java.util.Scanner;

public class BankSimulation
{  
   public static void main(String[] args) throws IOException
   {  
      Scanner in = new Scanner(System.in);
      BankData data = new BankData();
      try
      {  
         data.open("bank.dat");

         boolean done = false;
         while (!done)
         {  
            System.out.print("Account number: ");
            int accountNumber = in.nextInt();
            System.out.print("Amount to deposit: ");
            System.out.println("\nEnter -1 to delete an account.");
            double amount = in.nextDouble();

            int position = data.find(accountNumber);
            Bank account = null;
            if (position >= 0 && amount != -1)
            {
               account = data.read(position);
               account.deposit(amount);
               System.out.println("New balance: " + account.getBalance());
            }
            
            else if(amount == -1)
            {
            	System.out.println("Account successfully deleted.");
            	data.delete(position);
            	data.compact();
            }
            
            else 
            {  
               account = new Bank(accountNumber, amount);
               position = data.size();
               System.out.println("Adding new account.");
            }
            
            if(amount != -1)
            {
            	data.write(position, account);
            }

            System.out.print("\nDone? (Y/N) ");
            String input = in.next();
            if (input.equalsIgnoreCase("Y"))
            {
            	done = true;
            }
         }      
      }
      finally
      {
         data.close();
      }
   }
}
