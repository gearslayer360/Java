/*
 *Name: Brian Matthys
 *Date: 3/14/2013
 *Class: CSCI 1301
 *Section: 201
 *Name of Program: TicTacToe
 *Description: Write a program that plays tic-tac-toe. The tic-tac-toe
    game is played on a 3 × 3 grid as in the photo at right. The
	game is played by two players, who take turns. The first
	player marks moves with a circle, the second with a cross.
	The player who has formed a horizontal, vertical, or diagonal
	sequence of three marks wins. Your program should
	draw the game board, ask the user for the coordinates of
	the next mark, change the players after every successful
	move, and pronounce the winner.
 */

//while the game is not won
//check the win state, and present the findings
//present the board
//present the player to enter a location
//apply location to the board
//advance the turn index
package homework;

import java.util.Scanner;
import java.util.Arrays;

public class TicTacToe 
{
	public static int location;
	public static int rows = 3;
	public static int cols = 3;
	public static int row;
	public static int col;
	public static int currentRow; 
	public static int currentCol;
	public static int turn = 1;
	public static int[][] board = new int[rows][cols];
	public static int[][] remaining = new int[rows][cols];
	public static boolean won = false;
	public static boolean valid = false;
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		System.out.println("Tic Tac Toe Game\n");
		System.out.println("Rules:");
		System.out.println("Please enter the number indicating which square you want to pick;");
		System.out.println("The numbers range 1-9 starting from the top left across and going down when you reach an edge.\n");
		System.out.println();
		setBoard();
		printBoard();
		playGame();
	}
	
		public static void printBoard()
		{	
			for(int i = 0; i < rows; i++)
			{
				for(int j = 0; j < cols; j++)
				{
					printLocation(board[currentRow][currentCol]);					
					
					if(cols!= cols -1)
					{
						System.out.print("    | ");
					}
				}
				
				System.out.println();
				
				if(rows != rows -1)
				{
					System.out.println("  ----+-------+-------+");
				}
			}	
			
			System.out.println();
		}
		
		public static void printLocation(int content)
		{
			if(board[currentRow][currentCol] == 0)
			{
				System.out.print("  ");
			}
			
			else if(valid && board[currentRow][currentCol] == 1 && turn == 1)
			{
				System.out.print(" O ");
			}
						
			else if(valid && board[currentRow][currentCol] == 1 && turn == 2)
			{
				System.out.print(" X ");
			}
		}
		
		public static void setBoard()
		{
			for(int i=0; i < rows; i++)
			{
				for(int j=0; j < cols; j++)
				{
					board[i][j] = 0;
				}
			}
		}
		
		public static void playGame()
		{				
			for(int i = 0; i < rows; i++)
			{
				for(int j = 0; j < cols; j++)
				{
				remaining[i][j] = 0;
			}
			}
			
			while(!won)
			{			
				if(turn == 1)
				{
					System.out.println("Player 1 please pick your location: [row 1 - 3] [col 1 - 3]");
					row = input.nextInt() -1;
					col = input.nextInt() -1;
					
					if(row >= 0  && row <3 &&  col >= 0  && col <3 && board[row][col] == 0 )
					{
						row = currentRow;
						col = currentCol;
						remaining[currentRow][currentCol] = 1;
						board[currentRow][currentCol] = 1;
						System.out.println("\nAvailable locations: " + Arrays.toString(remaining));
						valid = true;
					}
					
					else
					{
						valid = false;
						do
						{
							System.out.println("Player 1 please pick your location:");
							row = input.nextInt();
							col = input.nextInt();
							if(row >= 0  && row <3 &&  col >= 0  && col <3 && board[row][col] == 0 )
							{
								row = currentRow;
								col = currentCol;
								remaining[currentRow][currentCol] = 1;
								board[currentRow][currentCol] = 1;
								System.out.println("\nAvailable locations: " + Arrays.toString(remaining));
								valid = true;
							}
						}
						while(valid == false);
					}
										
					printBoard();
					
					turn = 2;
				}
				
				else if(turn == 2)
				{
					System.out.println("Player 2 please pick your location: [row 1 - 3] [col 1 - 3]");
					row = input.nextInt() -1;
					col = input.nextInt() -1;
					
					if(row >= 0  && row <3 &&  col >= 0  && col <3 && board[row][col] == 0 )
					{
						row = currentRow;
						col = currentCol;
						remaining[currentRow][currentCol] = 1;
						board[currentRow][currentCol] = 1;
						System.out.println("\nAvailable locations: " + Arrays.toString(remaining));
						valid = true;
					}
					
					else
					{
						valid = false;
						do
						{
							System.out.println("Player 2 please pick your location:");
							row = input.nextInt();
							col = input.nextInt();
							if(row >= 0  && row <3 &&  col >= 0  && col <3 && board[row][col] == 0 )
							{
								row = currentRow;
								col = currentCol;
								remaining[currentRow][currentCol] = 1;
								board[currentRow][currentCol] = 1;
								System.out.println("\nAvailable locations: " + Arrays.toString(remaining));
								valid = true;
							}
						}
						while(valid == false);
					}
										
					printBoard();
					
					turn = 1;
					}
				}	
			}
		}