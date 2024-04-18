package org.example;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static java.lang.Math.abs;
import static java.lang.Math.round;

public class Project3 extends JFrame{
	private JTextField stringRead;
	private JButton runProgram, close, reset;
	private JLabel  analyzedText, numberOfVowelsIs, numberOfConsonantsIs, recognizedVowels, recognizedConsonants;
	String tempString = "";


	class Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("close"))
			{
				System.exit(0);
			}
			if (e.getActionCommand().equals("run"))
			{
				run();
			}
			if (e.getActionCommand().equals("reset"))
			{
				reset();
			}
			if (e.getActionCommand().equals("about"))
			{
				infoMessageErrorMessage("The program counts the number of vowels. It was created by Paweł Gaborek.","About",1,null, null);
			}
		}
	}

	public Project3(String title, String lookAndFeel) {
		super(title);
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		}
		catch (Exception e) {
		}

		JPanel readString, readResults, buttons;
		//======
		readString = readString();
		readResults = readResults();
		buttons = buttons();
		//======
		menu();
		//======
		add(readString,BorderLayout.NORTH);
		add(readResults,BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//======
		pack();
		//======
		setLocationByPlatform(true);
		setVisible(true);
		setResizable(false);
	}

	private void menu() {
		//I'M CREATING A MENU BAR
		Listener listener = new Listener();
		JMenuBar menu = new JMenuBar();
		//==========
		JMenu fileMenu = new JMenu("File");
		//==========
		JMenuItem about = new JMenuItem();
		about.setText("About this program");
		about.setAccelerator(KeyStroke.getKeyStroke('I', InputEvent.CTRL_DOWN_MASK));
		about.setActionCommand("about");
		about.addActionListener(listener);
		fileMenu.add(about);
		//==========
		fileMenu.addSeparator();
		//==========
		JMenuItem reset = new JMenuItem();
		reset.setText("Reset...");
		reset.setAccelerator(KeyStroke.getKeyStroke('R',InputEvent.CTRL_DOWN_MASK));
		reset.setActionCommand("reset");
		reset.addActionListener(listener);
		fileMenu.add(reset);
		//==========
		JMenuItem calculate = new JMenuItem();
		calculate.setText("Run program...");
		calculate.setAccelerator(KeyStroke.getKeyStroke('C',InputEvent.CTRL_DOWN_MASK));
		calculate.setActionCommand("run");
		calculate.addActionListener(listener);
		fileMenu.add(calculate);
		//==========
		fileMenu.addSeparator();
		//==========
		JMenuItem close = new JMenuItem();
		close.setText("Close");
		calculate.setAccelerator(KeyStroke.getKeyStroke('E',InputEvent.CTRL_DOWN_MASK));
		close.setActionCommand("close");
		close.addActionListener(listener);
		fileMenu.add(close);
		menu.add(fileMenu);
		this.setJMenuBar(menu);
	}

	private JPanel readString() {
		JPanel tempPanel = new JPanel();
		stringRead = new JTextField(20);
		tempPanel.setLayout(new GridLayout(3,1));
		tempPanel.add(new JLabel("Enter a string of characters:"));
		tempPanel.add(stringRead);
		tempPanel.setBorder(new TitledBorder("Read string"));
		return tempPanel;
	}

	private JPanel readResults() {
		JPanel tempPanel = new JPanel();
		tempPanel.setLayout(new GridLayout(5,2));
		tempPanel.add(new JLabel("The following text has been analyzed: "));
		analyzedText=new JLabel();
		tempPanel.add(analyzedText);

		tempPanel.add(new JLabel("The number of vowels is: "));
		numberOfVowelsIs = new JLabel();
		tempPanel.add(numberOfVowelsIs);

		tempPanel.add(new JLabel("The number of consonants is: "));
		numberOfConsonantsIs = new JLabel();
		tempPanel.add(numberOfConsonantsIs);

		tempPanel.add(new JLabel("The recognized vowels are: "));
		recognizedVowels = new JLabel();
		tempPanel.add(recognizedVowels);

		tempPanel.add(new JLabel("The recognized consonants are: "));
		recognizedConsonants = new JLabel();
		tempPanel.add(recognizedConsonants);

		tempPanel.setBorder(new TitledBorder("Vowel recognition score"));
		return tempPanel;
	}

	private JPanel buttons() {
		JPanel tempPanel = new JPanel();
		tempPanel.setLayout(new GridLayout(3,0));

		close = new JButton("Close");
		close.setActionCommand("close");
		runProgram = new JButton("Run program");
		runProgram.setActionCommand("run");
		reset = new JButton("Reset");
		reset.setActionCommand("reset");

		tempPanel.add(runProgram);
		tempPanel.add(reset);
		tempPanel.add(close);

		Listener listener = new Listener();

		close.addActionListener(listener);
		runProgram.addActionListener(listener);
		reset.addActionListener(listener);
		return tempPanel;
	}


	private void run() {
		String tempConsonants = "", tempVowels = "";
		int numberOfVowels = 0, numberOfConsonants = 0, j=0;
		String tempChar = "";

		try {
			tempString = stringRead.getText();
			analyzedText.setText(tempString);
			if(tempString.length() == 0)
			{
				throw new IOException();
			}
		}
		catch (IOException Exception) {
			infoMessageErrorMessage(null, null, 4, null, this.stringRead);
		}
		try{
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
			numberOfVowelsIs.setText(Integer.toString(numberOfVowels));
			numberOfConsonantsIs.setText(Integer.toString(numberOfConsonants));
			recognizedVowels.setText(tempVowels);
			recognizedConsonants.setText(tempConsonants);
		}
		catch (Exception Exception)
		{
			infoMessageErrorMessage("Error while counting characters.", "Error",3,null, null);
		}
	}

	
	private void errorMessageInput(JTextField input) {
		JOptionPane.showMessageDialog(this, "Your entry is not valid","Error", JOptionPane.ERROR_MESSAGE);
		input.requestFocus();
	}

	private void infoMessageErrorMessage(String output, String title, int option, JLabel outputJLabel, JTextField input) {
		switch(option) {
			case 1: {
				JOptionPane.showMessageDialog(this, output, title, JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			case 2: {
				JOptionPane.showMessageDialog(this, output, title, JOptionPane.ERROR_MESSAGE);
				outputJLabel.requestFocus();
				break;
			}
			case 3: {
				JOptionPane.showMessageDialog(this, output, title, JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			case 4: {
				JOptionPane.showMessageDialog(this, "Your entry is not valid", "Error", JOptionPane.ERROR_MESSAGE);
				input.requestFocus();
				break;
			}
		}
	}

	private void reset()
	{
		stringRead.setText("");
		numberOfVowelsIs.setText("");
		numberOfConsonantsIs.setText("");
		recognizedVowels.setText("");
		recognizedConsonants.setText("");
	}
}
