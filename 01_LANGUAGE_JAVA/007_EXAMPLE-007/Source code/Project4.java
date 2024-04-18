package org.example;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.IOException;

import static java.lang.Math.abs;
import static java.lang.Math.round;

public class Project4 extends JFrame{
	private JTextField number1, number2;
	private JButton hide, close, show, number1button, number2button;
	private JLabel multiplicationTables[][];
	private boolean isChecked=false, allValuesHide=false;

	class Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("close"))
			{
				System.exit(0);
			}
			if (e.getActionCommand().equals("hide"))
			{
				hideAllNumbers();
			}
			if (e.getActionCommand().equals("show"))
			{
				showAllNumbers();
			}
			if (e.getActionCommand().equals("checkMultiplication"))
			{
				checkMultiplication();
			}
			if (e.getActionCommand().equals("hideNumbers"))
			{
				hideCheckMultiplication();
			}
			if (e.getActionCommand().equals("about"))
			{
				infoMessageErrorMessage("The program shows the multiplication table. It was created by Paweł Gaborek.","About",1,null, null);
			}
		}
	}

	public Project4(String title, String lookAndFeel) {
		super(title);
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		}
		catch (Exception e) {
		}

		JPanel createPanelCheckButtons, createJPanel, buttons;
		//======
		createPanelCheckButtons = createPanelCheckButtons();
		createJPanel = createJPanel();
		buttons = buttons();
		//======
		menu();
		//======
		add(createPanelCheckButtons,BorderLayout.NORTH);
		add(createJPanel,BorderLayout.CENTER);
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
		JMenuItem close = new JMenuItem();
		close.setText("Close");
		close.setAccelerator(KeyStroke.getKeyStroke('E',InputEvent.CTRL_DOWN_MASK));
		close.setActionCommand("close");
		close.addActionListener(listener);
		fileMenu.add(close);
		menu.add(fileMenu);
		this.setJMenuBar(menu);
	}

	private void createMultiplicationTables()
	{
		multiplicationTables = new JLabel[11][11];
		for (int i=0 ; i<11 ; i++)
		{
			for (int j=0 ; j<11 ; j++)
			{
				multiplicationTables[i][j] = new JLabel();
			}
		}
	}

	private JPanel createJPanel(){
		JPanel tempPanel = new JPanel();
		tempPanel.setLayout(new GridLayout(11,11));

		createMultiplicationTables();

		for (int i=0 ; i<11 ; i++)
		{
			for (int j=0 ; j<11 ; j++)
			{
				tempPanel.add(multiplicationTables[i][j]);
			}
		}

		fillmultiplicationTables();
		tempPanel.setBorder(new TitledBorder("Multiplication table"));
		return tempPanel;
	}

	private void fillmultiplicationTables()
	{

		for (int i=0 ; i<11 ; i++)
		{
			multiplicationTables[0][i].setText(Integer.toString(i));
			multiplicationTables[i][0].setText(Integer.toString(i));
			multiplicationTables[0][i].setForeground(Color.red);
			multiplicationTables[i][0].setForeground(Color.red);
		}
		multiplicationTables[0][0].setText("");
		for (int i=1 ; i<11 ; i++)
		{
			for (int j=1 ; j<11 ; j++) {
				multiplicationTables[i][j].setText(Integer.toString(i*j));
			}
		}
	}

	private JPanel createPanelCheckButtons() {
		Listener listener = new Listener();
		JPanel tempPanel = new JPanel();
		tempPanel.setLayout(new GridLayout(3,2));
		tempPanel.add(new JLabel("First number"));
		tempPanel.add(new JLabel("Second number"));
		number1 = new JTextField(10);
		number2 = new JTextField(10);
		tempPanel.add(number1);
		tempPanel.add(number2);
		number1button = new JButton("Check multiplication");
		number1button.setActionCommand("checkMultiplication");

		number2button = new JButton("Hide numbers");
		number2button.setActionCommand("hideNumbers");

		tempPanel.add(number1button);
		tempPanel.add(number2button);

		number1button.addActionListener(listener);
		number2button.addActionListener(listener);
		tempPanel.setBorder(new TitledBorder("Multiplication check"));
		return tempPanel;
	}


	private JPanel buttons() {
		JPanel tempPanel = new JPanel();
		tempPanel.setLayout(new GridLayout(3,0));

		close = new JButton("Close");
		close.setActionCommand("close");
		hide = new JButton("Hide all values");
		hide.setActionCommand("hide");
		show = new JButton("Show all values");
		show.setActionCommand("show");

		tempPanel.add(hide);
		tempPanel.add(show);
		tempPanel.add(close);

		Listener listener = new Listener();

		close.addActionListener(listener);
		hide.addActionListener(listener);
		show.addActionListener(listener);
		return tempPanel;
	}



	private void hideCheckMultiplication()
	{
		int x=0,y=0;
		boolean error=false;
		try
		{
			if(!isChecked)
			{
				throw new Exception();
			}
		}
		catch (Exception Exception)
		{
			infoMessageErrorMessage("To cover the multiply check you must first enable the check.", "Error",4, null, null);
			error=true;
		}

		try
		{
			x = Integer.valueOf(number1.getText());
		}
		catch (NumberFormatException Exception)
		{
			infoMessageErrorMessage("Invalid value for X value.", "Error",3, null, number1);
			error=true;
		}
		try
		{
			y = Integer.valueOf(number2.getText());
		}
		catch (NumberFormatException Exception)
		{
			infoMessageErrorMessage("Invalid value for Y value.", "Error",3, null, number2);
			error=true;
		}

		try
		{
			if(error)
			{
				throw new IOException();
			}
			multiplicationTables[x][0].setForeground(Color.red);
			multiplicationTables[0][y].setForeground(Color.red);

			multiplicationTables[x][y].setForeground(Color.black);
			number1.setEnabled(true);
			number2.setEnabled(true);
			number1.setText("");
			number2.setText("");
			isChecked=false;
			if(allValuesHide == true)
			{
				multiplicationTables[x][y].setText("*");
			}
		}
		catch(IOException Exception)
		{
			infoMessageErrorMessage("The hide could not be performed.", "Error",4, null, null);
		}
	}

	private void checkMultiplication()
	{
		int x=0,y=0;
		boolean error=false;
		try
		{
			if(isChecked)
			{
				throw new Exception();
			}
		}
		catch (Exception Exception)
		{
			infoMessageErrorMessage("To check the multiplication result, first cover the previous check.", "Error",4, null, null);
			error=true;
		}

		try
		{
			x = Integer.valueOf(number1.getText());
		}
		catch (NumberFormatException Exception)
		{
			infoMessageErrorMessage("Invalid value for X value.", "Error",3, null, number1);
			error=true;
		}
		try
		{
			y = Integer.valueOf(number2.getText());
		}
		catch (NumberFormatException Exception)
		{
			infoMessageErrorMessage("Invalid value for Y value.", "Error",3, null, number2);
			error=true;
		}

		try
		{
			if(error)
			{
				throw new IOException();
			}
			multiplicationTables[x][0].setForeground(Color.blue);
			multiplicationTables[0][y].setForeground(Color.blue);
			multiplicationTables[x][y].setForeground(Color.blue);
			number1.setEnabled(false);
			number2.setEnabled(false);
			isChecked=true;
			if(allValuesHide == true)
			{
				multiplicationTables[x][y].setText(String.valueOf(x*y));
			}
		}
		catch(IOException Exception)
		{
			infoMessageErrorMessage("The check could not be performed.", "Error",4, null, null);
		}
	}

	private void hideAllNumbers() {
		try {
			for (int i = 1; i < 11; i++) {
				for (int j = 1; j < 11; j++) {
					multiplicationTables[i][j].setText("*");
				}
			}
			allValuesHide = true;
		}
		catch (Exception Exception)
		{
			infoMessageErrorMessage("Error.", "Error",4, null, null);
		}
	}

	private void showAllNumbers() {
		try
		{
			for (int i = 1; i < 11; i++) {
				for (int j = 1; j < 11; j++) {
					multiplicationTables[i][j].setText(Integer.toString(i * j));
				}
			}
			allValuesHide = false;
		}
		catch (Exception Exception)
		{
			infoMessageErrorMessage("Error.", "Error",4, null, null);
		}
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
				JOptionPane.showMessageDialog(this, output, title, JOptionPane.ERROR_MESSAGE);
				input.requestFocus();
				break;
			}
			case 4: {
				JOptionPane.showMessageDialog(this, output, title, JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
	}


}
