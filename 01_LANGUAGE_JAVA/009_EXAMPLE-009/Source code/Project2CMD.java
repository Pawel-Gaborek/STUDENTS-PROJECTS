package org.example;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.abs;

public class Project2CMD extends JFrame{
	private boolean exit=false, newLoop=true;
	private BufferedReader newBuffer;
	private InputStreamReader newStream;
	private int number1, number2, numberOfrepetitions=0;
	private String numberBigger;


	public Project2CMD() {
		try
		{
			newStream = new InputStreamReader(System.in);
			newBuffer = new BufferedReader(newStream);

			while (!exit)
			{
				heading();
				newLoop=false;
				programOption();
			}
			System.exit(0);
		}
		catch (Exception Exception)
		{
			errorMessageOutput("Problem starting the program."+Exception);
			System.exit(1);
		}
	}

	private void heading()
	{
		if(newLoop)
		{
			System.out.print("================           ================\n");
			System.out.print("================ Project 2 ================\n");
			System.out.print("================           ================\n\n");
		}
	}

	private void programOption() throws IOException {

		System.out.print("1) About this program.\n");
		System.out.print("2) Run program - calculate the number of loops.\n");
		System.out.print("3) Exit program.\n\n");

		int option = Integer.parseInt(newBuffer.readLine());

		switch (option)
		{
			case 1:{
				errorMessageOutput("This programme was developed by Pawel Gaborek.");
				break;
			}
			case 2:{
				runProgram();
				numberOfrepetitions=0;
				break;
			}
			case 3:{
				errorMessageOutput("Thank you for yus this program.");
				exit=true;
				break;
			}
		}
	}

	private void runProgram(){
		try {
			System.out.print("\nEnter the first number: ");
			this.number1= Integer.parseInt(newBuffer.readLine());
			System.out.print("Enter the second number: ");
			this.number2= Integer.parseInt(newBuffer.readLine());

			if (number1 == number2) {
				throw new EqualNumbersException();
			}
			if(number1<0 || number2<0)
			{
				throw new ANegativeNumberException();
			}

			for (int i = 0; i < abs(number1 - number2); i++) {
				numberOfrepetitions++;
			}

			if (number1 > number2) {
				this.numberBigger = "first";
			}
			else
			{
				this.numberBigger = "second";
			}
			System.out.print("Bigger is the "+this.numberBigger+" number.\n");
			System.out.print("The number of loops is: "+numberOfrepetitions+"\n\n");
		}
		catch (NumberFormatException Exception)
		{
			errorMessageOutput("Incorrect format of the entered data.");
		}
		catch (IOException Exception)
		{
			errorMessageOutput("Error entering data.");
			throw new RuntimeException(Exception);
		}
		catch (EqualNumbersException Exception)
		{
			errorMessageOutput("The numbers are the same");
		}
		catch (ANegativeNumberException Exception)
		{
			errorMessageOutput("The numbers are negative");
		}
	}

	class EqualNumbersException extends Exception
	{
		public EqualNumbersException() {}
	}

	class ANegativeNumberException extends Exception
	{
		public ANegativeNumberException() {}
	}

	private void errorMessageOutput(String message) {
		System.out.print(message+"\n\n");
	}
}
