package ie.gmit.game;

import java.util.Scanner; // Adding to take user input

public class Main {
	
	static Scanner userInput = new Scanner(System.in); // Create Scanner Object
	// Create Tic-Tac-Toe Board
					        // col1,col2,col3
	static char[][] board = { { '?', '?', '?' },   // row 1
					          { '?', '?', '?' },   // row 2
					          { '?', '?', '?' } }; // row 3
	static int row = 0; // Store user row input
	static int column = 0; // Store user column input
	static char turn = 'X'; // Keep track of who's turn it is
	static boolean validInput = true; // Used to check for valid user inputs
	
	public static void main(String[] args) {
		
		
		int inputCount = 0; // Keep track of current inputs
		final int MAX_INPUTS = 9; // Max inputs of any game
		
		
		
		System.out.println("Welcome to Tic-Tac-Toe");
		
		displayBoard();
		
		// Keep asking for inputs until we have a winner or all positions full
		while (inputCount < MAX_INPUTS) {
			inputCount++; // Count user input
			
			getUserPositionChoice();
			
			// Assign user ID (i.e. X or O) to board location (i.e. (row, column))
			board[row - 1][column - 1] = turn;
			
			displayBoard();
			
			// Add condition to break loop on win. Check for 3 similar items in
			// a line and check if one of them is not a '?'
			if ((board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][2] != '?') ||
				(board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][2] != '?') ||
				(board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][2] != '?') ||
				(board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[2][0] != '?') ||
				(board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[2][1] != '?') ||
				(board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[2][2] != '?') ||
				(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] != '?') ||
				(board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[0][2] != '?')) {
					System.out.println("Player " + turn + " Wins!");
					System.out.println("Game Over");
					break;
			} else {
				// If no winner change turn
				if (turn == 'X') {
					turn = 'O';
				} else if (turn == 'O') {
					turn = 'X';
				}
			}

		}
		
		// If we exit while loop we know all 9 positions are full and
		// there is no winner.
		if (inputCount == MAX_INPUTS) {
			System.out.println("Game is a draw.");
		}
		
		userInput.close(); // Close Scanner object.
		
	} // End Main Method

	static void getUserPositionChoice() {
		// Get user input and check if input in range and in empty position
		do {
			System.out.println("Player " + turn + " trun:");
			System.out.println("Select a row (1 - 3): ");
			row = userInput.nextInt();
			System.out.println("Select a column (1 - 3): ");
			column = userInput.nextInt();

			if (row < 1 || row > 3 || column < 1 || column > 3) {
				System.out.println("ERROR: Input out of bounds! Please try again.");
				validInput = false;
			} else if (board[row - 1][column - 1] != '?') {
				System.out.println("ERROR: This position is alread taken! Please try again.");
				validInput = false;
			} else {
				validInput = true;
			}
		} while (validInput == false);
	}
	
	static void displayBoard() {
		System.out.println(" -----------");
		System.out.println("| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |");
		System.out.println(" -----------");
	}

} // End Main Class
