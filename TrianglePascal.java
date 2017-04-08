import java.util.Scanner;

import javax.swing.JOptionPane;

public class TrianglePascal {

	// Scanner
	public static Scanner input = new Scanner(System.in);
	public static String userInput;

	public static boolean isValid = false;

	// Method used to validate user input
	public static void validateUserInput(int checkNumber) {
		// checks if number is valid with simple if statments
		if (checkNumber <= 0 || checkNumber >= 21) {

			JOptionPane.showMessageDialog(null, "Please make sure the input is a value between (and including) 1 - 20");
			clearScreen();
		} else
			isValid = true;

	}

	// Method used to get the user\s input
	public static void getUserInput() throws InterruptedException {

		isValid = false;

		// Simple do/while loop to keep getting the input until condition is
		// true
		do {

			System.out.println("-------------------------");
			System.out.print("Enter the amount of rows: ");
			userInput = input.nextLine();

			try {
				int amountOfRows = Integer.parseInt(userInput);

				validateUserInput(amountOfRows);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Thats not an integer. Please enter an Integer.");
				clearScreen();
			}

		} while (!isValid);

		// calls method when condition is true to print the triangle
		printTriangle();

	}

	// Method to clear the screen
	private static void clearScreen() {
		for (int x = 0; x <= 15; x++) {
			System.out.println();
		}

	}

	// Method used to actually print the triangle
	public static void printTriangle() throws InterruptedException {

		//
		int amountOfRows = Integer.parseInt(userInput);
		amountOfRows--; // Take away 1 from the user input incase user enters 1
						// -- then 1 row prints not two

		// Loops through each row
		for (int currentRow = 0; currentRow <= amountOfRows; currentRow++) {

			// This loop prints out the required amount of tabs at the start of
			// a row
			for (int y = amountOfRows; y > 0; y--) {
				if (y > currentRow)
					System.out.print("\t");
			}

			// Thread.sleep used to clean up the user interface
			// Second loop calls a method to get the next number in the row +
			// tabs out the numbers
			Thread.sleep(90);
			for (int y = 0; y <= currentRow; y++) {

				System.out.print(getNumber(currentRow, y) + "\t\t");
			}
			System.out.println();
		}

		// Gets user input again so that the user can continue to enter new
		// amount of rows * BAZINGA *
		getUserInput();

	}

	// Main method is used to introduce the program and call the method to get
	// the user's input
	public static void main(String args[]) throws InterruptedException {
		System.out.println("     A Moujtabah Karim Program \u00a9");
		System.out.println();
		getUserInput();
	}

	// ** RECURSION IS USED HERE ** //
	// Method used to return the next number in the current row
	public static int getNumber(int currentRow, int y) {

		if (y == 0) {
			return 1;
		} else if (y == currentRow) {
			return 1;
		} else {
			// calls itself to return the next number in the current row
			return getNumber(currentRow - 1, y - 1) + getNumber(currentRow - 1, y);
		}

	}
}