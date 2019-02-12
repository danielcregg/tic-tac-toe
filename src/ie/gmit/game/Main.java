package ie.gmit.game;

import java.util.Scanner; // Adding to take user input

public class Main {
	
	// Create Tic-Tac-Toe Board
					        // col1,col2,col3
	static char[][] board = { { '?', '?', '?' },   // row 1
					          { '?', '?', '?' },   // row 2
					          { '?', '?', '?' } }; // row 3
	
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		int row = 0;
		int column = 0;
		int inputCount = 0;
		final int MAX_INPUTS = 9;
		boolean validInput = true;
		
		System.out.println("Welcome to Tic-Tac-Toe");
		
		displayBoard();
		
		// Keep asking for inputs until we have a winner or all positions full
		while (inputCount < MAX_INPUTS) {
			inputCount++; // Count user input
			
			// Get user input and check if input in range and in empty position
			do {
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
					
			// Assign user ID (i.e. X or O) to board location (i.e. (row, column))
			board[row - 1][column - 1] = 'X';
			
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
					System.out.println("You Win!");
					break;
			}
		}
		
		// If we exit while loop we know all 9 positions are full and
		// there is no winner.
		if (inputCount == MAX_INPUTS) {
			System.out.println("Game is a draw.");
		}
		
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

} // End Main Class
