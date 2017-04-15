package homework;

import java.io.IOException;
import java.io.RandomAccessFile;


public class BankData
{
   private RandomAccessFile file;

   public static final int INT_SIZE = 4;  
   public static final int DOUBLE_SIZE = 8;  
   public static final int RECORD_SIZE = INT_SIZE + DOUBLE_SIZE;

   public BankData()
   {
      file = null;
   }

   public void open(String filename)
         throws IOException
   {
      if (file != null) { file.close(); }
      file = new RandomAccessFile(filename, "rw");
   }

   public int size()
         throws IOException
   {
      return (int) (file.length() / RECORD_SIZE);
   }

   public void close()
         throws IOException
   {
      if (file != null) { file.close(); }
      file = null;
   }

   public Bank read(int n)
         throws IOException
   {  
      file.seek(n * RECORD_SIZE);      
      int accountNumber = file.readInt();
      double balance = file.readDouble();
      return new Bank(accountNumber, balance);
   }

   public int find(int accountNumber)
         throws IOException
   {
      for (int i = 0; i < size(); i++)
      {
         file.seek(i * RECORD_SIZE);
         int a = file.readInt();         
         if (a == accountNumber) { return i; }           
      } 
      return -1; 
   }

   public void write(int n, Bank account)
         throws IOException
   {  
      file.seek(n * RECORD_SIZE);
      file.writeInt(account.getAccountNumber());
      file.writeDouble(account.getBalance());
   }
   
   public void delete(int n) throws IOException
   {
	  file.seek(n * RECORD_SIZE);
	  file.writeInt(0);
	  file.writeDouble(0);
   }
   
   public void compact() throws IOException
   {
	   Bank account;
	   int deleted = 0;
	   
	   for(int i = 0; i < size()-1; i++)
	   {
		   find(i);	
		   account = read(i);
		   System.out.println("Processing Account Number " + account.getAccountNumber());
		   
		   if(account.getAccountNumber() == 0)
		   {
			   System.out.println("\nDeleted record found at position = " + file.getFilePointer() + "\n");
			   Bank tempAccount = read(i+1);
			   account = read(i);
			   write((i+1), account);
			   write(i, tempAccount);
		   }
	   }
	   
	   for(int i = 0; i < size(); i++)
	   {
		   find(i);
		   account = read(i);
		   if(account.getAccountNumber() == 0)
		   {
			   deleted = deleted + 12;
		   }
	   }
	   System.out.println("Current file length " + file.length());
	   file.setLength(file.length() - deleted);
	   System.out.println("New file length " + file.length());
	   
	   System.out.println("File compacted. \nVerifying contents...\n");
	   for(int i = 0; i < size(); i++)
	   {
		   account = read(i);
		   System.out.println("Account " + account.getAccountNumber());
	   }
   }
}
