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
		
		System.out.println("Select a row (1 - 3): ");
		row = userInput.nextInt();
		System.out.println("Select a column (1 - 3): ");
		column = userInput.nextInt();

		System.out.println("Row: " + row + " Column: " + column);
		
		userInput.close(); // Close Scanner object.
		
	} // End Main Method

} // End Main Class
