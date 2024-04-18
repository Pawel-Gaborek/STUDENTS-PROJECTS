package org.example;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.text.DecimalFormat;

import static java.lang.Math.abs;
import static java.lang.Math.round;

public class Project2 extends JFrame{
	private JTextField number1, number2;
	private JButton runProgram, close, reset;
	private JLabel  numberBigger,numberOfRepetitions;


	class Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("close"))
			{
				System.exit(0);
			}
			if (e.getActionCommand().equals("run")) {
				run();
			}
			if (e.getActionCommand().equals("reset"))
			{
				reset();
			}
			if (e.getActionCommand().equals("about"))
			{
				infoMessage("This program calculates the number of loop repetitions. It was created by Paweł Gaborek.","About");
			}
		}
	}

	public Project2(String title, String lookAndFeel) {
		super(title);
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		}
		catch (Exception e) {
		}

		JPanel numbers, resultNumbers, buttons;
		//======
		numbers = numbers();
		resultNumbers = resultNumbers();
		buttons = buttons();
		//======
		menu();
		//======
		add(numbers,BorderLayout.NORTH);
		add(resultNumbers,BorderLayout.CENTER);
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

	private JPanel numbers() {
		JPanel tempPanel = new JPanel();
		number1 = new JTextField(10);
		number2 = new JTextField(10);
		//======
		tempPanel.setLayout(new GridLayout(3,1));
		tempPanel.add(new JLabel("Number 1:"));
		tempPanel.add(number1);
		tempPanel.add(new JLabel("repetitions."));
		//======
		tempPanel.add(new JLabel("Number 2: "));
		tempPanel.add(number2);
		tempPanel.add(new JLabel("repetitions."));
		//======
		tempPanel.add(new JLabel("Bigger is the "));
		numberBigger = new JLabel();
		tempPanel.add(numberBigger);
		tempPanel.add(new JLabel(" digit."));
		tempPanel.setBorder(new TitledBorder("Numbers"));
		return tempPanel;
	}

	private JPanel resultNumbers() {
		JPanel tempPanel = new JPanel();
		tempPanel.setLayout(new GridLayout(1,3));
		tempPanel.add(new JLabel("The number of repetitions is: "));
		numberOfRepetitions = new JLabel();
		tempPanel.add(numberOfRepetitions);
		tempPanel.add(new JLabel(" repetitions."));
		tempPanel.setBorder(new TitledBorder("Result of repetitions"));
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
		int number1=0, number2=0, numberOfrepetitions=0;
		try {
			number1 = Integer.valueOf(this.number1.getText());
			if(number1<0)
			{
				throw new NumberFormatException();
			}
		}
		catch (Exception NumberFormatException) {
			errorMessageInput(this.number1);
		}
		try {
			number2 = Integer.valueOf(this.number2.getText());
			if(number2<0)
			{
				throw new NumberFormatException();
			}
		}
		catch (Exception NumberFormatException) {
			errorMessageInput(this.number2);
		}
		try {
			if(number1==0 && number2==0)
			{
				throw new NumberFormatException();
			}
		}
		catch (Exception NumberFormatException) {
			errorMessageInput(null);
		}
		try {
			if (number1 == number2) {
				throw new Exception();
			}
			for (int i = 0; i < abs(number1 - number2); i++) {
				numberOfrepetitions++;
			}
			if (number1 > number2) {
				this.numberBigger.setText("first");
			}
			else
			{
				this.numberBigger.setText("second");
			}
			this.numberOfRepetitions.setText(Integer.toString(numberOfrepetitions));
		}
		catch (Exception e)
		{
			infoMessage("Provide numbers with different values.", "Error");
		}
	}

	
	private void errorMessageInput(JTextField input) {
		JOptionPane.showMessageDialog(this, "Your entry is not valid","Error", JOptionPane.ERROR_MESSAGE);
		input.requestFocus();
	}
	private void errorMessageOutput(JLabel output) {
		JOptionPane.showMessageDialog(this, "Output error","Error", JOptionPane.ERROR_MESSAGE);
		output.requestFocus();
	}

	private void infoMessage(String output, String title) {
		JOptionPane.showMessageDialog(this, output,title, JOptionPane.INFORMATION_MESSAGE);
	}

	private void reset()
	{
		number1.setText("0");
		number2.setText("0");
		numberBigger.setText("-");
		numberOfRepetitions.setText("0");
	}
}
