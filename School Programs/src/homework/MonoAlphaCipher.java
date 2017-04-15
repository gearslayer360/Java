package homework;

import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class MonoAlphaCipher
{
	private String key;		
	private String alphabet = "ZYXWVUTSRQPOMNLKJIHGFEDCBA";
	private String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private char[] cipherText;
	private char[] plain;
	
	public static void main(String[] args) throws IOException
	{
		MonoAlphaCipher cipher = new MonoAlphaCipher();
		
		String inFile = JOptionPane.showInputDialog("File to encrypt or decrypt");	
		String outFile = JOptionPane.showInputDialog("Output File");
		
		InputStream inStream = new FileInputStream(inFile);
		OutputStream outStream = new FileOutputStream(outFile);
		
		String command = "";
		Scanner in = new Scanner(System.in);		
		
		System.out.println("Encrpytor begin...");
		help();

		try
		{
			command = in.nextLine().toUpperCase();
			
			if(command.contains("-K"))
			{
				try
				{
					System.out.println("Encrypting file...");
					String key = command.substring(3).trim();
					cipher = new MonoAlphaCipher(key);
					cipher.createKey();
					cipher.encyrptStream(inStream, outStream);	// encrypt file
				}
				catch(StringIndexOutOfBoundsException e)
				{
					System.out.println("ERROR: You must supply a key after using the <-k> command in order to encrypt the file.");
					System.exit(0);
				}
			}
			if(command.contains("-D"))
			{
				try
				{
					System.out.println("Decrypting file...");
					String key = command.substring(3).trim();
					cipher = new MonoAlphaCipher(key);
					cipher.createKey();
					cipher.decryptStream(inStream, outStream);
				}
				catch(StringIndexOutOfBoundsException e)
				{
					System.out.println("ERROR: You must supply a key after using the <-d> command in order to decrypt the file.");
					System.exit(0);
				}
			}
			
			inStream.close();
			outStream.close();
			
			System.out.println("\nProcess complete.");
		}
		
		catch(IOException e)
		{
			System.out.println("Error processing file: " + e);
		}
	}

	public static void help()
	{
		System.out.println("\nList of Commands \n-k <keyword> defines keyword and encrypts file.");
		System.out.println("-d <keyword> defines keyword and decrypts file.");
		System.out.println("Do not include the < > in the commands.");
		System.out.println();
	}

	public MonoAlphaCipher()
	{
		key = "";
	}

	public MonoAlphaCipher(String aKey)
	{
		key = aKey;
	}
	
	public void encyrptStream(InputStream in, OutputStream out) throws IOException
	{
		boolean done = false;
		while(!done)
		{
			int next = in.read();
			if(next == -1)
			{
				done = true;
			}
			
			else
			{
				int encrypted = encrypt(next);
				out.write(encrypted);
			}
		}
	}
	
	public void decryptStream(InputStream in, OutputStream out) throws IOException
	{
		boolean done = false;
		while(!done)
		{
			int next = in.read();
			
			if(next == -1)
			{
				done = true;
			}
			
			else
			{
				int decrypted = decrypt(next);
				out.write(decrypted);
			}
		}
	}

	public void createKey()
	{
		plain = text.toCharArray();
		removeDuplicates(key);
		appendAlphabet(key);
		cipherText = key.toCharArray();
		System.out.println("The key is accepted and a cipher was successfully generated.");
	}

	private void removeDuplicates(String key)
	{
		StringBuilder keyword = new StringBuilder();
		for(int i = 0; i < key.length(); i++)
		{
			String st = key.substring(i, i+1);
			if(keyword.indexOf(st) == -1)
			{
				keyword.append(st);
			}
		}
		this.key = keyword.toString();
	}

	private void appendAlphabet(String key)
	{
		this.key = key + alphabet;
		removeDuplicates(this.key);
	}

	private int encrypt(int bin)
	{
		char c = (char) bin;
		c = Character.toUpperCase(c);
		for(int i = 0; i < plain.length; i++)
		{
			char value = plain[i];
			if(c == value)
			{
				return cipherText[i];
			}
		}
		return bin;
	}

	private int decrypt(int bin)
	{
		char c = (char) bin;
		c = Character.toUpperCase(c);
		
		for(int i = 0; i < cipherText.length; i++)
		{
			char value = cipherText[i];
			if(c == value)
			{
				return plain[i];
			}
		}
		return bin;
	}
}
