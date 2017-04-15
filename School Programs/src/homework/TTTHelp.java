package homework;

import java.util.Scanner;  // this is a library needed to get the user's input

public class TTTHelp { // name of the class
	
	public static Scanner in = new Scanner(System.in);	// this is the scanner class object obtained from the imported 
										 				// scanner library, allows us to get user input
	
	public static int[][] gameBoard = {
		{1, 2, 3},		// this is the game board
		{4, 5, 6},		// the user just picks a number to 
		{7, 8, 9}		// place his x|o
	  };
	
	public static int[][] gameMarkers = {
		{0, 0, 0},		// this is the game board
		{0, 0, 0},		// that holds the users x and o 
		{0, 0, 0}
	  };
	
	public static int[][] p1gameMarkers = {
		{0, 0, 0},		// this is the game board
		{0, 0, 0},		// that holds the player 1's x 
		{0, 0, 0}
	  };
	
	public static int[][] p2gameMarkers = {
		{0, 0, 0},		// this is the game board
		{0, 0, 0},		// that holds the player 2's o 
		{0, 0, 0}
	  };
	
	public static String[][] game = {
		{" ", " ", " "},  // this is the game board that shows the current
		{" ", " ", " "},  // game screen that the players will see
		{" ", " ", " "}
	  };
	
	// all the winning boards
	public static int[][] board1 = {
		{1, 1, 1},
		{0, 0, 0},
		{0, 0, 0}
	};
	
	public static int[][] board2 = {
		{0, 0, 0},
		{1, 1, 1},
		{0, 0, 0}
	};
	
	public static int[][] board3 = {
		{0, 0, 0},
		{0, 0, 0},
		{1, 1, 1}
	};
	
	public static int[][] board4 = {
		{1, 0, 0},
		{1, 0, 0},
		{1, 0, 0}
	};
	
	public static int[][] board5 = {
		{0, 1, 0},
		{0, 1, 0},
		{0, 1, 0}
	};
	
	public static int[][] board6 = {
		{0, 0, 1},
		{0, 0, 1},
		{0, 0, 1}
	};
	
	public static int[][] board7 = {
		{1, 0, 0},
		{0, 1, 0},
		{0, 0, 1}
	};
	
	public static int[][] board8 = {
		{0, 0, 1},
		{0, 1, 0},
		{1, 0, 0}
	};
	
	public static boolean winner = false;		// will let the computer know if there is a winner or not
	public static int turns = 0;				// holds the current turn number
	public final static int TURNS_MAX = 5;		// the max amount of moves|turns the game can have
	
	public static int player1 = 0;				// the place were player 1 wants to place his "x"
	public static int player2 = 0;				// the place were player 2 wants to place his "0"
	public static String p1 = "p1";				// keeps track of what player 1 is doing
	public static String p2 = "p2";				// keeps track of what player 2 is doing	
	
	public static void main(String[] args){ // main method, were the program starts, the game loop
		
		runGame(); 				// calls the method that brings up the game screen
		
		// starts the game loop, and keeps running while a winner is not found or the 
		// max amount of turns hasn't been reached
		while(!winner && turns != TURNS_MAX){ 
			// get the location were player 1 wants to place his marker
			System.out.println("Player 1, MAKE YOUR MOVE!!! (choose a number and hit enter to place your mark)");
			player1 = in.nextInt();
			
			// place the players marker on the board 
			placeMarker(p1, player1);
			// check to see if their is a winner or if it is a tie
			winnerDecided(p1gameMarkers);
			
			// increment the turns|moves
			turns++;
			if(turns < TURNS_MAX && !winner){
				// get the location were player 2 wants to place his marker
				System.out.println("Player 2, MAKE YOUR MOVE!!! (choose a number and hit enter to place your mark)");
				player2 = in.nextInt();

				// place the players marker on the board 
				placeMarker(p2, player2);
				// check to see if their is a winner or if it is a tie
				winnerDecided(p2gameMarkers);
				
			}	
			
		}

	}
	
	public static void runGame(){
		System.out.println("         |          |         ");
		System.out.println("    " + gameBoard[0][0] + "\t |     " + gameBoard[0][1] + "    |    " + gameBoard[0][2]);
		System.out.println("         |          |         ");
		System.out.println("------------------------------");
		System.out.println("         |          |         ");
		System.out.println("    " + gameBoard[1][0] + "\t |     " + gameBoard[1][1] + "    |    " + gameBoard[1][2]);
		System.out.println("         |          |         ");
		System.out.println("------------------------------");
		System.out.println("         |          |         ");
		System.out.println("    " + gameBoard[2][0] + "\t |     " + gameBoard[2][1] + "    |    " + gameBoard[2][2]);
		System.out.println("         |          |         ");
	}
	
	public static void placeMarker(String player, int position){
		Boolean notAvailable = false; // check for the loop so if found or done will only execute once
		
		while(!notAvailable){// loop through the array|game board
			for(int row=0; row<3; row++){
				for(int col=0; col<3; col++){
					// find the spot the player wants to place their marker
					if(gameBoard[row][col] == position){
						// check if that spot is already taken
						checkCollision(player, row, col);
						notAvailable = true;
					}
				}
			}
		}
		
	}
	
	public static void checkCollision(String player, int row, int col){
		// if the space is blank
		if(gameMarkers[row][col] == 0){
			// check to see if player 1 is making the move
			if(player.equals("p1")){
				// if player one then place an "X" on the game board
				game[row][col] = "X";
				gameMarkers[row][col] = 1;
				p1gameMarkers[row][col] = 1;
				gameView();
			} else {
				// if player two then place an "O" on the game board
				game[row][col] = "O";
				gameMarkers[row][col] = 2;
				p2gameMarkers[row][col] = 1;
				gameView();
			}
		} else if(gameMarkers[row][col] == 1){ // if the space is not blank and occupied by player 1
			// tell the player he cannot make that move, and needs to choose another spot
			System.out.println("You cannot make that move.");
			if(player.equals("p1")){
				System.out.println("Player 1, You already occupy that space!!!");
				System.out.println("Please choose another spot!!!");
				// get the location were the player wants to place his marker
				int secondChance;
				secondChance = in.nextInt();
							
				// check to see if there is a winner or if that is the last max turn
				placeMarker(player, secondChance);
			} else if(player.equals("p2")){
				System.out.println("Player 2, Player 1 already occupies that space!!!");
				System.out.println("Please choose another spot!!!");
				// get the location were the player wants to place his marker
				int secondChance;
				secondChance = in.nextInt();
							
				// check to see if there is a winner or if that is the last max turn
				placeMarker(player, secondChance);
			}
		} else if(gameMarkers[row][col] == 2){ // if the space is not blank and occupied by player 2
			// tell the player he cannot make that move, and needs to choose another spot
			System.out.println("You cannot make that move.");
			if(player.equals("p1")){
				System.out.println("Player 1, Player 2 already occupies that space!!!");
				System.out.println("Please choose another spot!!!");
				// get the location were the player wants to place his marker
				int secondChance;
				secondChance = in.nextInt();
							
				// check to see if there is a winner or if that is the last max turn
				placeMarker(player, secondChance);
			} else if(player.equals("p2")){
				System.out.println("Player 2, You already occupy that space!!!");
				System.out.println("Please choose another spot!!!");
				// get the location were the player wants to place his marker
				int secondChance;
				secondChance = in.nextInt();
							
				// check to see if there is a winner or if that is the last max turn
				placeMarker(player, secondChance);
			}
		}
	}
	
	public static void gameView(){
		System.out.println("         |          |         ");
		System.out.println("    " + game[0][0] + "\t |     " + game[0][1] + "    |    " + game[0][2]);
		System.out.println("         |          |         ");
		System.out.println("------------------------------");
		System.out.println("         |          |         ");
		System.out.println("    " + game[1][0] + "\t |     " + game[1][1] + "    |    " + game[1][2]);
		System.out.println("         |          |         ");
		System.out.println("------------------------------");
		System.out.println("         |          |         ");
		System.out.println("    " + game[2][0] + "\t |     " + game[2][1] + "    |    " + game[2][2]);
		System.out.println("         |          |         ");
	}
	
	public static void winnerDecided(int[][] currentGame){
		// go through all the winning boards and check to see if there is a match
		for(int x=0; x<1; x++){ //board1
			boolean[] matches = new boolean[9];			// if the game board is a match to winning board then there is a winner
			int spot = 0;	// current index/spot of game board

			// loop through the current game's board
			for(int row=0; row<3; row++){
				for(int col=0; col<3; col++){
					// check to see if the current index in this loop is equal to the 
					// current index of the winning boards, current spot is true
					if(currentGame[row][col] == board1[row][col]){
						matches[spot] = true;
					} else { // if current index is not, then current spot is false
						matches[spot] = false;
					}

					spot++; //move to the next spot
				}
			}

			if(matches[0] == true){
				if(matches[1] == true){
					if(matches[2] == true){
						if(matches[3] == true){
							if(matches[4] == true){
								if(matches[5] == true){
									if(matches[6] == true){
										if(matches[7] == true){
											if(matches[8] == true){
												System.out.println("WINNER!!!");
												winner = true;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		for(int x=0; x<1; x++){ //board2
			boolean[] matches = new boolean[9];			// if the game board is a match to winning board then there is a winner
			int spot = 0;	// current index/spot of game board

			// loop through the current game's board
			for(int row=0; row<3; row++){
				for(int col=0; col<3; col++){
					// check to see if the current index in this loop is equal to the 
					// current index of the winning boards, current spot is true
					if(currentGame[row][col] == board2[row][col]){
						matches[spot] = true;
					} else { // if current index is not, then current spot is false
						matches[spot] = false;
					}

					spot++; //move to the next spot
				}
			}

			if(matches[0] == true){
				if(matches[1] == true){
					if(matches[2] == true){
						if(matches[3] == true){
							if(matches[4] == true){
								if(matches[5] == true){
									if(matches[6] == true){
										if(matches[7] == true){
											if(matches[8] == true){
												System.out.println("WINNER!!!");
												winner = true;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		for(int x=0; x<1; x++){ //board3
			boolean[] matches = new boolean[9];			// if the game board is a match to winning board then there is a winner
			int spot = 0;	// current index/spot of game board

			// loop through the current game's board
			for(int row=0; row<3; row++){
				for(int col=0; col<3; col++){
					// check to see if the current index in this loop is equal to the 
					// current index of the winning boards, current spot is true
					if(currentGame[row][col] == board3[row][col]){
						matches[spot] = true;
					} else { // if current index is not, then current spot is false
						matches[spot] = false;
					}

					spot++; //move to the next spot
				}
			}

			if(matches[0] == true){
				if(matches[1] == true){
					if(matches[2] == true){
						if(matches[3] == true){
							if(matches[4] == true){
								if(matches[5] == true){
									if(matches[6] == true){
										if(matches[7] == true){
											if(matches[8] == true){
												System.out.println("WINNER!!!");
												winner = true;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		for(int x=0; x<1; x++){ //board4
			boolean[] matches = new boolean[9];			// if the game board is a match to winning board then there is a winner
			int spot = 0;	// current index/spot of game board

			// loop through the current game's board
			for(int row=0; row<3; row++){
				for(int col=0; col<3; col++){
					// check to see if the current index in this loop is equal to the 
					// current index of the winning boards, current spot is true
					if(currentGame[row][col] == board4[row][col]){
						matches[spot] = true;
					} else { // if current index is not, then current spot is false
						matches[spot] = false;
					}

					spot++; //move to the next spot
				}
			}

			if(matches[0] == true){
				if(matches[1] == true){
					if(matches[2] == true){
						if(matches[3] == true){
							if(matches[4] == true){
								if(matches[5] == true){
									if(matches[6] == true){
										if(matches[7] == true){
											if(matches[8] == true){
												System.out.println("WINNER!!!");
												winner = true;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		for(int x=0; x<1; x++){ //board5
			boolean[] matches = new boolean[9];			// if the game board is a match to winning board then there is a winner
			int spot = 0;	// current index/spot of game board

			// loop through the current game's board
			for(int row=0; row<3; row++){
				for(int col=0; col<3; col++){
					// check to see if the current index in this loop is equal to the 
					// current index of the winning boards, current spot is true
					if(currentGame[row][col] == board5[row][col]){
						matches[spot] = true;
					} else { // if current index is not, then current spot is false
						matches[spot] = false;
					}

					spot++; //move to the next spot
				}
			}

			if(matches[0] == true){
				if(matches[1] == true){
					if(matches[2] == true){
						if(matches[3] == true){
							if(matches[4] == true){
								if(matches[5] == true){
									if(matches[6] == true){
										if(matches[7] == true){
											if(matches[8] == true){
												System.out.println("WINNER!!!");
												winner = true;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		for(int x=0; x<1; x++){ //board6
			boolean[] matches = new boolean[9];			// if the game board is a match to winning board then there is a winner
			int spot = 0;	// current index/spot of game board

			// loop through the current game's board
			for(int row=0; row<3; row++){
				for(int col=0; col<3; col++){
					// check to see if the current index in this loop is equal to the 
					// current index of the winning boards, current spot is true
					if(currentGame[row][col] == board6[row][col]){
						matches[spot] = true;
					} else { // if current index is not, then current spot is false
						matches[spot] = false;
					}

					spot++; //move to the next spot
				}
			}

			if(matches[0] == true){
				if(matches[1] == true){
					if(matches[2] == true){
						if(matches[3] == true){
							if(matches[4] == true){
								if(matches[5] == true){
									if(matches[6] == true){
										if(matches[7] == true){
											if(matches[8] == true){
												System.out.println("WINNER!!!");
												winner = true;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		for(int x=0; x<1; x++){ //board7
			boolean[] matches = new boolean[9];			// if the game board is a match to winning board then there is a winner
			int spot = 0;	// current index/spot of game board

			// loop through the current game's board
			for(int row=0; row<3; row++){
				for(int col=0; col<3; col++){
					// check to see if the current index in this loop is equal to the 
					// current index of the winning boards, current spot is true
					if(currentGame[row][col] == board7[row][col]){
						matches[spot] = true;
					} else { // if current index is not, then current spot is false
						matches[spot] = false;
					}

					spot++; //move to the next spot
				}
			}

			if(matches[0] == true){
				if(matches[1] == true){
					if(matches[2] == true){
						if(matches[3] == true){
							if(matches[4] == true){
								if(matches[5] == true){
									if(matches[6] == true){
										if(matches[7] == true){
											if(matches[8] == true){
												System.out.println("WINNER!!!");
												winner = true;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		for(int x=0; x<1; x++){ //board8
			boolean[] matches = new boolean[9];			// if the game board is a match to winning board then there is a winner
			int spot = 0;	// current index/spot of game board

			// loop through the current game's board
			for(int row=0; row<3; row++){
				for(int col=0; col<3; col++){
					// check to see if the current index in this loop is equal to the 
					// current index of the winning boards, current spot is true
					if(currentGame[row][col] == board8[row][col]){
						matches[spot] = true;
					} else { // if current index is not, then current spot is false
						matches[spot] = false;
					}

					spot++; //move to the next spot
				}
			}

			if(matches[0] == true){
				if(matches[1] == true){
					if(matches[2] == true){
						if(matches[3] == true){
							if(matches[4] == true){
								if(matches[5] == true){
									if(matches[6] == true){
										if(matches[7] == true){
											if(matches[8] == true){
												System.out.println("WINNER!!!");
												winner = true;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

	}

}
