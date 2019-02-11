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
		
		System.out.println("Welcome to Tic-Tac-Toe");
		
		displayBoard();
		
		System.out.println("Select a row (1 - 3): ");
		row = userInput.nextInt();
		System.out.println("Select a column (1 - 3): ");
		column = userInput.nextInt();
		
		// Assign user ID (i.e. X or O) to board location (i.e. (row, column))
		board[row - 1][column - 1] = 'X';
		
		displayBoard();
		
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
