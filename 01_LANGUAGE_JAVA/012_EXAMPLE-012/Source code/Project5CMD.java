package com.example.project5_v2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class Project5CMD {
	private boolean exit = false, newLoop = true;
	private BufferedReader newBuffer;
	private InputStreamReader newStream;
	private Project5WordsEditFile wordsFile;
	private Vector<String> words;
	private Vector<String> points;
	private Project5HighscoreList pointsList;
	private Project5Game game;

	public Project5CMD() {
		try {
			wordsFile = new Project5WordsEditFile();
			pointsList = new Project5HighscoreList();
			words = wordsFile.getWords();
			points = pointsList.get();
			newStream = new InputStreamReader(System.in);
			newBuffer = new BufferedReader(newStream);
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
			System.out.print("================ Project 5 ================\n");
			System.out.print("================           ================\n\n");
		}
	}

	private void programOption() throws IOException {
		try {
			System.out.print("\n1) About this program.\n");
			System.out.print("2) Hangman - run the game.\n");
			System.out.print("3) Hangman - enter words for the game.\n");
			System.out.print("4) Hangman - delete selected words in the game.\n");
			System.out.print("5) Hangman - Show the words in the game.\n");
			System.out.print("6) Hangman - Highscore list\n");
			System.out.print("7) Exit program.\n\n");

			int option = Integer.parseInt(newBuffer.readLine());
			if (option > 7) {
				throw new ToBigNumber();
			}

			if (option < 1) {
				throw new ToSmallNumber();
			}

			switch (option) {
				case 1: {
					errorMessageOutput("This programme was developed by Pawel Gaborek.\nThis is the implementation program for the Hangman game.\n");
					break;
				}
				case 2: {
					runGame();
					break;
				}
				case 3: {
					enterWordsForGame();
					break;
				}
				case 4: {
					deleteWords();
					break;
				}
				case 5: {
					schowWords();
					break;
				}
				case 6: {
					highscoreList();
					break;
				}
				case 7: {
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

	private void schowWords()
	{
		try
		{
			System.out.print("\nThe words in the hangman game are:\n\n");
			for(int i=0 ; i<words.size() ; i++)
			{
				System.out.print((i+1)+") "+words.get(i)+"   ");
			}
			System.out.print("\n");
		}
		catch (Exception Exception)
		{
			errorMessageOutput("Error.\n" + Exception);
		}
	}

	private void deleteWords()
	{
		try
		{
			System.out.print("\nBelow are the words to remove.\n" +
					"Select the word number to delete and confirm with enter.\n\n");
			for(int i=0 ; i<words.size() ; i++)
			{
				System.out.print((i+1)+") "+words.get(i)+"   ");
			}
			System.out.print("\n");
			int number = Integer.parseInt(newBuffer.readLine());
			if (number-1 > words.size()) {
				throw new ToBigNumber();
			}

			if (number < 1) {
				throw new ToSmallNumber();
			}

			wordsFile.deleteWord(words.get(number-1));
			words = wordsFile.getWords();
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
		catch (Exception Exception)
		{
			errorMessageOutput("Error.\n" + Exception);
		}
	}
	private void enterWordsForGame()
	{
		try
		{
			System.out.print("Enter a new word for the hangman game and confirm with the enter key:\n");
			String word = String.valueOf(newBuffer.readLine());
			wordsFile.addWord(word);
			words = wordsFile.getWords();
		}
		catch (Exception Exception)
		{
			errorMessageOutput("Error.\n" + Exception);
		}
	}

	private void runGame()
	{
		try
		{
			game = new Project5Game();
		}
		catch(Exception Exception)
		{
			errorMessageOutput("Error.\n" + Exception);
		}
	}

	private void highscoreList()
	{
		try
		{
			System.out.print("\nBelow is the list of results:\n");
			for(int i=0 ; i<points.size() ; i++)
			{
				System.out.print((i+1)+") "+points.get(i)+"\n");
			}
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