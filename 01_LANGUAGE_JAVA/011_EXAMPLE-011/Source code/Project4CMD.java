package org.example;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Project4CMD {
	private String multiplicationTables[][];
	private boolean isHidden = false;
	private boolean exit = false, newLoop = true;
	private BufferedReader newBuffer;
	private InputStreamReader newStream;

	public Project4CMD() {
		try {
			newStream = new InputStreamReader(System.in);
			newBuffer = new BufferedReader(newStream);
			createMultiplicationTables();
			while (!exit) {
				heading();
				newLoop = false;
				programOption();
			}
			System.exit(0);
		} catch (Exception Exception) {
			errorMessageOutput("Problem starting the program." + Exception);
			System.exit(1);
		}
	}

	private void heading() {
		if (newLoop) {
			System.out.print("================           ================\n");
			System.out.print("================ Project 4 ================\n");
			System.out.print("================           ================\n\n");
		}
	}

	private void programOption() throws IOException {

		try {
			System.out.print("\n1) About this program.\n");
			System.out.print("2) Run program - Show the multiplication table.\n");
			System.out.print("3) Run program - Show hidden times table times table.\n");
			System.out.print("4) Check the multiplication result for selected numbers\n");
			System.out.print("5) Exit program.\n\n");

			int option = Integer.parseInt(newBuffer.readLine());
			if (option > 5) {
				throw new ToBigNumber();
			}

			if (option < 1) {
				throw new ToSmallNumber();
			}

			switch (option) {
				case 1: {
					errorMessageOutput("This programme was developed by Pawel Gaborek.");
					break;
				}
				case 2: {
					if (isHidden) {
						showValue();
					}
					showMultiplicationTables();
					break;
				}
				case 3: {
					if (!isHidden) {
						hideValue();
					}
					showMultiplicationTables();
					break;
				}
				case 4: {
					if (!isHidden) {
						hideValue();
					}
					showMultiplicationTables();
					checkTheValues();
					break;
				}
				case 5: {
					errorMessageOutput("Thank you for yus this program.");
					exit = true;
					break;
				}
			}
		}
		catch (ToBigNumber Exception) {
			errorMessageOutput("The number entered is too large.\n" + Exception);
		}
		catch (ToSmallNumber Exception) {
			errorMessageOutput("The given number is negative.\n" + Exception);
		}
		catch (NumberFormatException Exception) {
			errorMessageOutput("Invalid format.\n" + Exception);
		}
	}

	private void createMultiplicationTables() {
		multiplicationTables = new String[12][12];

		for (int i = 0; i < 12; i++) {
			if (i < 11) {
				multiplicationTables[i][0] = " " + String.valueOf(i - 1);
				multiplicationTables[0][i] = "   " + String.valueOf(i - 1);
			} else {
				multiplicationTables[i][0] = String.valueOf(i - 1);
				multiplicationTables[0][i] = "  " + String.valueOf(i - 1);
			}
			if (i > 1) {
				multiplicationTables[i][1] = "|";
				multiplicationTables[1][i] = "____";
			}
		}

		for (int i = 2; i < 12; i++) {
			for (int j = 2; j < 12; j++) {
				if ((i - 1) * (j - 1) < 10) {
					multiplicationTables[i][j] = "   " + String.valueOf((i - 1) * (j - 1));
				}
				if ((i - 1) * (j - 1) >= 10 && (i - 1) * (j - 1) < 100) {
					multiplicationTables[i][j] = "  " + String.valueOf((i - 1) * (j - 1));
				}
				if ((i - 1) * (j - 1) >= 100) {
					multiplicationTables[i][j] = " " + String.valueOf((i - 1) * (j - 1));
				}
			}
		}
		multiplicationTables[0][0] = "  ";
		multiplicationTables[0][1] = " ";
		multiplicationTables[1][0] = "  ";
		multiplicationTables[1][1] = " ";
	}

	private void showMultiplicationTables() {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				System.out.print(multiplicationTables[i][j]);
			}
			System.out.print("\n");
		}
	}

	private void showValue() {
		for (int i = 2; i < 12; i++) {
			for (int j = 2; j < 12; j++) {
				if ((i - 1) * (j - 1) < 10) {
					multiplicationTables[i][j] = "   " + String.valueOf((i - 1) * (j - 1));
				}
				if ((i - 1) * (j - 1) >= 10 && (i - 1) * (j - 1) < 100) {
					multiplicationTables[i][j] = "  " + String.valueOf((i - 1) * (j - 1));
				}
				if ((i - 1) * (j - 1) >= 100) {
					multiplicationTables[i][j] = " " + String.valueOf((i - 1) * (j - 1));
				}
			}
		}
		isHidden=false;
	}

	private void hideValue() {
		for (int i = 2; i < 12; i++) {
			for (int j = 2; j < 12; j++) {
				multiplicationTables[i][j] = "   " + "*";
			}
		}
		isHidden=true;
	}

	private void checkTheValues() {

		try {
			System.out.print("\nEnter a value for the X ordinate: ");
			int number2 = Integer.parseInt(newBuffer.readLine());
			System.out.print("\nEnter a value for the Y ordinate: ");
			int number1 = Integer.parseInt(newBuffer.readLine());
			System.out.print("\nThe board after checking:\n\n");

			if (number1>10 || number2>10)
			{
				throw new ToBigNumber();
			}
			if (number1<1 || number1<1)
			{
				throw new ToSmallNumber();
			}


			if (number1*number2<10)
			{
				multiplicationTables[number1+1][number2+1]="   "+String.valueOf( number1*number2);
			}
			if (number1*number2>10 && number1*number2<100)
			{
				multiplicationTables[number1+1][number2+1]="  "+String.valueOf( number1*number2);
			}
			if (number1*number2>=100)
			{
				multiplicationTables[number1+1][number2+1]=" "+String.valueOf( number1*number2);
			}
			showMultiplicationTables();

		}
		catch (ToBigNumber Exception) {
			errorMessageOutput("The number entered is too large.\n" + Exception);
		}
		catch (ToSmallNumber Exception) {
			errorMessageOutput("The given number is negative.\n" + Exception);
		}
		catch (NumberFormatException Exception)
		{
			errorMessageOutput("Invalid input data format.\n" + Exception);
		}
		catch (Exception Exception)
		{
			errorMessageOutput("Error.\n" + Exception);
		}
	}


	private void errorMessageOutput(String message) {
		System.out.print(message + "\n\n");
	}

	class ToBigNumber extends NumberFormatException {
		public ToBigNumber() {
		}
	}

	class ToSmallNumber extends NumberFormatException {
		public ToSmallNumber() {
		}
	}
}