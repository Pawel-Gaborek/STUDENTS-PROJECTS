package com.example.project5_v2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

public class Project5Game {
  	private StringBuilder hiddenWord;
  	private String newWord;
  	private int numberOfTries;
	private boolean exit = false, win = false, lost=false;
	private BufferedReader newBuffer;
	private InputStreamReader newStream;
	private Project5WordsEditFile wordsFile;
	private Vector<String> words;
	private Project5HighscoreList pointsList;
	private int pointsUser;
	private String userName;

	public Project5Game()
	{
		try {
			String charGet;
			wordsFile = new Project5WordsEditFile();
			pointsList = new Project5HighscoreList();
			words = wordsFile.getWords();
			numberOfTries = 10;

			newStream = new InputStreamReader(System.in);
			newBuffer = new BufferedReader(newStream);

			System.out.print("\nEnter your name: ");
			userName = String.valueOf(newBuffer.readLine());

			newWord();

			while (!exit) {

				System.out.print("\nEnter an alphabetic character: ");
				charGet = String.valueOf(newBuffer.readLine());
				check(charGet);
				whetherTheUserWon();
				System.out.print("\nSearched word: "+hiddenWord);
				System.out.print("\nRemaining number of attempts: "+numberOfTries);
				System.out.print("\nAmount of points: "+pointsUser+"\n");

				if (win) {
					System.out.print("\nCongratulations! You won! ");
					System.out.print("\nThe word you are looking for is: "+hiddenWord);
					System.out.print("\nThe number of points obtained is: "+pointsUser+"\n");
					pointsList.addResult(userName+" points: "+pointsUser);
				}
				if (lost)
				{
					System.out.print("\nUnfortunately, you lost. Maybe next time.\n");
				}
			}
		} catch (Exception Exception) {
			errorMessageOutput("Problem starting the program." + Exception);
		}
	}

	private void newWord() {
		int random = 0;
		random = (int)(Math.random() * words.size());
		newWord = new String(words.get(random));
		hiddenWord = new StringBuilder(newWord);
		for (int i = 0; i < newWord.length(); i++)
			hiddenWord.setCharAt(i, '*');
	}

	private void check(String string) {
		char charGet;
		int numberOfHits = 0;
		charGet = string.toString().charAt(0);
		numberOfHits = newWord.toLowerCase().indexOf(charGet);
		if (numberOfHits < 0) {
			numberOfTries--;
			pointsUser -= 1;
		}
		else {
			while (numberOfHits >= 0) {
				hiddenWord.setCharAt(numberOfHits, newWord.charAt(numberOfHits));
				numberOfHits++;
				numberOfHits = newWord.toLowerCase().indexOf(charGet,numberOfHits);
				pointsUser += 5;
			}
		}
	}

	private void whetherTheUserWon() {
		if (numberOfTries == 0) {
			lost = true;
			exit = true;
		}
		if (hiddenWord.toString().equals(newWord)) {
			win = true;
			exit = true;
		}
	}

	private void errorMessageOutput(String message) {
		System.out.print(message + "\n\n");
	}
}
