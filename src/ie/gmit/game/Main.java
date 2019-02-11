package ie.gmit.game;

import java.util.Scanner; // Adding to take user input

public class Main {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		// Create Tic-Tac-Toe Board
						 // col1,col2,col3
		char[][] board = { { '?', '?', '?' },   // row 1
						   { '?', '?', '?' },   // row 2
						   { '?', '?', '?' } }; // row 3
		int row = 0;
		int column = 0;
		
		System.out.println("Welcome to Tic-Tac-Toe");
		
		// Print Board
		for (int i = 0; i < board.length; i++) {
			System.out.print("\t"); // Add tab to shift board display right.
			System.out.println(board[i]);
		}
		
		System.out.println("Select a row (1 - 3): ");
		row = userInput.nextInt();
		System.out.println("Select a column (1 - 3): ");
		column = userInput.nextInt();
		
		// Assign user ID (i.e. X or O) to board location (i.e. (row, column))
		board[row - 1][column - 1] = 'X';
		
		// Print Board
		for (int i = 0; i < board.length; i++) {
			System.out.print("\t"); // Add tab to shift board display right.
			System.out.println(board[i]);
		}
		
		userInput.close(); // Close Scanner object.
		
	} // End Main Method

} // End Main Class
