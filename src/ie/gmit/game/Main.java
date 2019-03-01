package ie.gmit.game;

import java.util.Scanner; // Adding to take user input

public class Main {
	
	static Scanner userInput = new Scanner(System.in); // Create Scanner Object
	static Scanner userInput2 = new Scanner(System.in); // Create Scanner Object
	// Create Tic-Tac-Toe Board
					        // col1,col2,col3
	static char[][] board = { { '7', '8', '9' },   // row 1
					          { '4', '5', '6' },   // row 2
					          { '1', '2', '3' } }; // row 3
	static int row = 0; // Store user row input
	static int column = 0; // Store user column input
	static int position = 0; // Store user position input
	static char currentTurn = 'X'; // Keep track of who's turn it is
	static char winner; // Record who won
	static boolean validInputChecker = false; // Used to check for valid user inputs
	static int validInputCounter = 0; // Keep track of current inputs for current game
	static boolean playAgain = false; // Used to check if user wants to play again
	
	static final int MAX_VALID_INPUTS = 9; // Max inputs of any game
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Tic-Tac-Toe");
		do {
			startNewGame();
			checkGameOutcome();
			System.out.println("Do you wish to play again? Y/N");
			String answer = userInput2.nextLine();
			playAgain = answer.equalsIgnoreCase("y");
		} while(playAgain);
		
		System.out.println("Game Over");
		userInput.close(); // Close Scanner object.
		userInput2.close(); // Close Scanner object.
	} // End Main
	
	static void startNewGame() {
		// Reset everything
		board[2][0] = '1';
		board[2][1] = '2';
		board[2][2] = '3';
		board[1][0] = '4';
		board[1][1] = '5';
		board[1][2] = '6';
		board[0][0] = '7';
		board[0][1] = '8';
		board[0][2] = '9';
		currentTurn = 'X'; // Keep track of who's turn it is
		validInputCounter = 0;
		// Keep asking for inputs until we have no winner and all positions are not full
		boolean noWinner = true;
		while (noWinner && validInputCounter < MAX_VALID_INPUTS) {

			getUserPositionChoice();

			// Update Board: Assign user ID (i.e. X or O) to board location (i.e. (row,
			// column))
			board[row - 1][column - 1] = currentTurn;

			validInputCounter++; // Count user input

			// Need to have minimum 5 inputs before winner can be declared
			if (validInputCounter >= 5) {
				if (checkIfPlayerWon()) { // Check for winner
					winner = currentTurn; // Record winner
					noWinner = false; // Set flag to indicate Winner is found
				} else { // If no winner found change turn
					changePlayerTurn();
				}
			} else {
				changePlayerTurn();
			}
		} // End while
	}
	
	static void checkGameOutcome() {
		// When game is over we know all 9 positions are full or someone has won
		if (validInputCounter == MAX_VALID_INPUTS) {
			System.out.println("Game is a draw.");
		} else {
			System.out.println("Player " + winner + " Wins!");
			displayBoard();
		}
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
	
	static void getUserPositionChoice() {
		validInputChecker = false;
		// Get user input and check if input in range and in empty position
		do {
			displayBoard();
			System.out.println("Player " + currentTurn + " turn. Select a position (1 - 9): ");
			
			position = userInput.nextInt();
			
			switch (position) {
				case 1:  row = 3;
						 column = 1;
						 validInputChecker = true;
						 break;
				case 2:  row = 3;
						 column = 2;
						 validInputChecker = true;
						 break;
				case 3:  row = 3;
						 column = 3;
						 validInputChecker = true;
						 break;
				case 4:  row = 2;
						 column = 1;
						 validInputChecker = true;
						 break;
				case 5:  row = 2;
						 column = 2;
						 validInputChecker = true;
						 break;
				case 6:  row = 2;
						 column = 3;
						 validInputChecker = true;
						 break;
				case 7:  row = 1;
						 column = 1;
						 validInputChecker = true;
						 break;
				case 8:  row = 1;
						 column = 2;
						 validInputChecker = true;
						 break;
				case 9:  row = 1;
						 column = 3;
						 validInputChecker = true;
						 break;
				default:
					System.out.print("Error: ");
					if (position < 1 || position > 9) {
						System.out.println("Position " + position + " does not exist. Please try again.");
						validInputChecker = false;
						continue;
					} // End if
			} // End Switch
			if (board[row - 1][column - 1] == 'X' || board[row - 1][column - 1] == 'O') {
				System.out.println("ERROR: This position is alread taken! Please try again.");
				validInputChecker = false;
			} // End If
		} while (validInputChecker == false); // End Do While
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
		if (currentTurn == 'X') {
			currentTurn = 'O';
		} else if (currentTurn == 'O') {
			currentTurn = 'X';
		}
	}
	
} // End Main Class
