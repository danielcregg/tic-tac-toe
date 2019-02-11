package ie.gmit.game;

import java.util.Scanner; // Adding to take user input

public class Main {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);

		System.out.println("Welcome to Tic-Tac-Toe");
		
		System.out.println("Please enter a number: ");
		int x = userInput.nextInt();
		System.out.println(x);

		userInput.close();
		
	} // End Main Method

} // End Main Class
