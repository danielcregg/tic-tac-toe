package ie.gmit.game;

import java.util.Scanner; // Adding to take user input

public class Main {
	
	static Scanner userInput = new Scanner(System.in); // Create Scanner Object
	// Create Tic-Tac-Toe Board
					        // col1,col2,col3
	static char[][] board = { { '7', '8', '9' },   // row 1
					          { '4', '5', '6' },   // row 2
					          { '1', '2', '3' } }; // row 3
	static int row = 0; // Store user row input
	static int column = 0; // Store user column input
	static int position = 0; // Store user position input
	static char turn = 'X'; // Keep track of who's turn it is
	static boolean validInput = true; // Used to check for valid user inputs
	
	public static void main(String[] args) {
		
		int inputCount = 0; // Keep track of current inputs
		final int MAX_INPUTS = 9; // Max inputs of any game

		System.out.println("Welcome to Tic-Tac-Toe");
		
		displayBoard();
		
		// Keep asking for inputs until we have a winner or all positions full
		while (inputCount < MAX_INPUTS) {
			
			getUserPositionChoice();
			
			// Update Board: Assign user ID (i.e. X or O) to board location (i.e. (row, column))
			board[row - 1][column - 1] = turn;
			
			inputCount++; // Count user input
			
			displayBoard();
			
			if (checkIfPlayerWon()) {
				break; // If player wins break loop, declare victory and end game
			} else {
				changePlayerTurn();	
			}

		} // End while
		
		// If we exit while loop we know all 9 positions are full or someone has won
		if (inputCount == MAX_INPUTS) {
			System.out.println("Game is a draw.");
		} else {
			System.out.println("Player " + turn + " Wins!");
		}
		
		System.out.println("Game Over");
		
		userInput.close(); // Close Scanner object.
		
	} // End Main Method

	static void displayBoard() {
		System.out.println(" -----------");
		System.out.println("| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |");
		System.out.println(" -----------");
	}
	
	static void getUserPositionChoice() {
		// Get user input and check if input in range and in empty position
		do {
			System.out.println("Player " + turn + " trun:");
			System.out.println("Select a position (1 - 9): ");
			
			position = userInput.nextInt();
			
			switch (position) {
				case 1:  row = 3;
						 column = 1;
						 validInput = true;
						 break;
				case 2:  row = 3;
						 column = 2;
						 validInput = true;
						 break;
				case 3:  row = 3;
						 column = 3;
						 validInput = true;
						 break;
				case 4:  row = 2;
						 column = 1;
						 validInput = true;
						 break;
				case 5:  row = 2;
						 column = 2;
						 validInput = true;
						 break;
				case 6:  row = 2;
						 column = 3;
						 validInput = true;
						 break;
				case 7:  row = 1;
						 column = 1;
						 validInput = true;
						 break;
				case 8:  row = 1;
						 column = 2;
						 validInput = true;
						 break;
				case 9:  row = 1;
						 column = 3;
						 validInput = true;
						 break;
				default: System.out.print("Error: ");
						 if (position < 1 || position > 9) {
						 	 System.out.println("Input out of bounds! Please try again.");
						 	 validInput = false;
						 } // End If
				} // End Switch
			if (board[row - 1][column - 1] == 'X' || board[row - 1][column - 1] == 'Y') {
				System.out.println("ERROR: This position is alread taken! Please try again.");
				validInput = false;
			} // End If
		} while (validInput == false); //End Do While
		
	}
	
	static boolean checkIfPlayerWon() {
		boolean playerWon = false;
		// Add condition to break loop on win. Check for 3 similar items in
		// a line and check if one of them is not a '?'
		if ((board[0][0] == board[0][1] && board[0][1] == board[0][2] && (board[0][2] != 'X' || board[0][2] != 'Y')) ||
			(board[1][0] == board[1][1] && board[1][1] == board[1][2] && (board[0][2] != 'X' || board[0][2] != 'Y')) ||
			(board[2][0] == board[2][1] && board[2][1] == board[2][2] && (board[0][2] != 'X' || board[0][2] != 'Y')) ||
			(board[0][0] == board[1][0] && board[1][0] == board[2][0] && (board[0][2] != 'X' || board[0][2] != 'Y')) ||
			(board[0][1] == board[1][1] && board[1][1] == board[2][1] && (board[0][2] != 'X' || board[0][2] != 'Y')) ||
			(board[0][2] == board[1][2] && board[1][2] == board[2][2] && (board[0][2] != 'X' || board[0][2] != 'Y')) ||
			(board[0][0] == board[1][1] && board[1][1] == board[2][2] && (board[0][2] != 'X' || board[0][2] != 'Y')) ||
			(board[2][0] == board[1][1] && board[1][1] == board[0][2] && (board[0][2] != 'X' || board[0][2] != 'Y'))) {
			playerWon = true;
			return playerWon; // If player won return true
		} else {
			return playerWon; // If player did not win return false
		}
	}
	
	static void changePlayerTurn() {
		if (turn == 'X') {
			turn = 'O';
		} else if (turn == 'O') {
			turn = 'X';
		}
	}
	
} // End Main Class
