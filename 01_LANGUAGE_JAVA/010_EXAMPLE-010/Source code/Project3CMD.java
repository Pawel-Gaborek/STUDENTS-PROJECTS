package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Project3CMD {
	String tempString = "";
	private boolean exit=false, newLoop=true;
	private BufferedReader newBuffer;
	private InputStreamReader newStream;


	public Project3CMD() {
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
			System.out.print("================ Project 3 ================\n");
			System.out.print("================           ================\n\n");
		}
	}
	private void programOption() throws IOException {

		System.out.print("1) About this program.\n");
		System.out.print("2) Run program - calculating the number of consonants and vowels.\n");
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
				break;
			}
			case 3:{
				errorMessageOutput("Thank you for yus this program.");
				exit=true;
				break;
			}
		}
	}



	private void runProgram() {
		try{
			String tempConsonants = "", tempVowels = "";
			int numberOfVowels = 0, numberOfConsonants = 0, j=0;
			String tempChar = "";

			System.out.print("Enter a string of characters to calculate the number of vowels and consonants: ");
			tempString = String.valueOf(newBuffer.readLine());

			if(tempString.length() == 0)
			{
				throw new IOException();
			}
			for (int i=0 ; i<tempString.length() ; i++)
			{
				tempChar = String.valueOf(tempString.charAt(i));
				switch(tempChar) {
					case "a": {
						tempVowels += String.valueOf(tempString.charAt(i));
						numberOfVowels++;
						break;
					}
					case "A": {
						tempVowels += String.valueOf(tempString.charAt(i));
						numberOfVowels++;
						break;
					}
					case "e": {
						tempVowels += String.valueOf(tempString.charAt(i));
						numberOfVowels++;
						break;
					}
					case "E": {
						tempVowels += String.valueOf(tempString.charAt(i));
						numberOfVowels++;
						break;
					}
					case "i": {
						tempVowels += String.valueOf(tempString.charAt(i));
						numberOfVowels++;
						break;
					}
					case "I": {
						tempVowels += String.valueOf(tempString.charAt(i));
						numberOfVowels++;
						break;
					}
					case "o": {
						tempVowels += String.valueOf(tempString.charAt(i));
						numberOfVowels++;
						break;
					}
					case "O": {
						tempVowels += String.valueOf(tempString.charAt(i));
						numberOfVowels++;
						break;
					}
					case "u": {
						tempVowels += String.valueOf(tempString.charAt(i));
						numberOfVowels++;
						break;
					}
					case "U": {
						tempVowels += String.valueOf(tempString.charAt(i));
						numberOfVowels++;
						break;
					}
					case "ä": {
						tempVowels += String.valueOf(tempString.charAt(i));
						numberOfVowels++;
						break;
					}
					case "Ä": {
						tempVowels += String.valueOf(tempString.charAt(i));
						numberOfVowels++;
						break;
					}
					case "ü": {
						tempVowels += String.valueOf(tempString.charAt(i));
						numberOfVowels++;
						break;
					}
					case "Ü": {
						tempVowels += String.valueOf(tempString.charAt(i));
						numberOfVowels++;
						break;
					}
					case "ö": {
						tempVowels += String.valueOf(tempString.charAt(i));
						numberOfVowels++;
						break;
					}
					case "Ö": {
						tempVowels += String.valueOf(tempString.charAt(i));
						numberOfVowels++;
						break;
					}
					default:
					{
						tempConsonants += String.valueOf(tempString.charAt(i));
						numberOfConsonants++;
						break;
					}
				}
			}
			System.out.print("The number of vowels is: "+numberOfVowels+"\n");
			System.out.print("The number of consonants is: "+numberOfConsonants+"\n\n");
		}
		catch (IOException Exception) {
			errorMessageOutput("Input output error"+Exception);
		}
		catch (NumberFormatException Exception)
		{
			errorMessageOutput("The format of the entered roof is incorrect"+Exception);
		}
		catch (Exception Exception)
		{
			errorMessageOutput("Error while counting characters.");
		}
	}
	private void errorMessageOutput(String message) {
		System.out.print(message+"\n\n");
	}
}
