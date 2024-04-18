package org.example;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

public class Project9 extends JFrame{
	private JTextField getArabic, getRoman;
	private JButton convertRomanButton, convertArabicButton, closeButton, resetButton;
	private JLabel romanAfterConversion, arabicAfterConversion;

	public Project9(String title, String lookAndFeel) {
		super(title);
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		}
		catch (Exception e) {
		}

		JPanel arabicToRoman, romanToArabic, result;
		arabicToRoman = arabicToRoman();
		romanToArabic = romanToArabic();

		result = result();
		menu();
		add(arabicToRoman,BorderLayout.NORTH);
		add(romanToArabic,BorderLayout.CENTER);
		add(result, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationByPlatform(true);
		setVisible(true);
		setResizable(false);
	}

	class Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("about"))
			{
				infoMessage("The program converting Arabic numbers to Roman numbers was implemented by Paweł Gaborek..","About");
			}
			if (e.getActionCommand().equals("reset"))
			{
				reset();
			}
			if (e.getActionCommand().equals("corvertToArabic")) {
				corvertToArabic();
			}
			if (e.getActionCommand().equals("corvertToRoman")) {
				corvertToRoman();
			}

			if (e.getActionCommand().equals("close"))
			{
				System.exit(0);
			}
		}
	}

	private void menu() {
		Listener listener = new Listener();
		JMenuBar menu = new JMenuBar();

		JMenu fileMenu = new JMenu("File");

		JMenuItem about = new JMenuItem();
		about.setText("About this program");
		about.setAccelerator(KeyStroke.getKeyStroke('I', InputEvent.CTRL_DOWN_MASK));
		about.setActionCommand("about");
		about.addActionListener(listener);
		fileMenu.add(about);

		fileMenu.addSeparator();

		JMenuItem reset = new JMenuItem();
		reset.setText("Reset...");
		reset.setAccelerator(KeyStroke.getKeyStroke('N',InputEvent.CTRL_DOWN_MASK));
		reset.setActionCommand("reset");
		reset.addActionListener(listener);
		fileMenu.add(reset);

		JMenuItem romanToArabic = new JMenuItem();
		romanToArabic.setText("Roman to Arabic...");
		romanToArabic.setAccelerator(KeyStroke.getKeyStroke('R',InputEvent.CTRL_DOWN_MASK));
		romanToArabic.setActionCommand("corvertToArabic");
		romanToArabic.addActionListener(listener);
		fileMenu.add(romanToArabic);

		JMenuItem arabicToRoman = new JMenuItem();
		arabicToRoman.setText("Arabic to Roman...");
		arabicToRoman.setAccelerator(KeyStroke.getKeyStroke('A',InputEvent.CTRL_DOWN_MASK));
		arabicToRoman.setActionCommand("corvertToRoman");
		arabicToRoman.addActionListener(listener);
		fileMenu.add(arabicToRoman);
		fileMenu.addSeparator();

		JMenuItem close = new JMenuItem();
		close.setText("Close");
		close.setAccelerator(KeyStroke.getKeyStroke('C',InputEvent.CTRL_DOWN_MASK));
		close.setActionCommand("close");
		close.addActionListener(listener);
		fileMenu.add(close);
		menu.add(fileMenu);
		this.setJMenuBar(menu);
	}

	private JPanel arabicToRoman() {
		JPanel tempPanel = new JPanel();
		tempPanel.setLayout(new GridLayout(0,2));
		getArabic = new JTextField(10);
		arabicAfterConversion = new JLabel();

		tempPanel.add(new JLabel("Enter an Arabic numeral:"));
		tempPanel.add(getArabic);
		tempPanel.add(new JLabel("Arabic after conversion: "));
		tempPanel.add(arabicAfterConversion);

		tempPanel.setBorder(new TitledBorder("Arabic to Roman"));
		return tempPanel;
	}

	private JPanel romanToArabic() {
		JPanel tempPanel = new JPanel();
		tempPanel.setLayout(new GridLayout(0,2));
		getRoman = new JTextField(10);
		romanAfterConversion = new JLabel();

		tempPanel.add(new JLabel("Enter an Roman numeral:"));
		tempPanel.add(getRoman);
		tempPanel.add(new JLabel("Roman after conversion: "));
		tempPanel.add(romanAfterConversion);

		tempPanel.setBorder(new TitledBorder("Roman to Arabic"));
		return tempPanel;
	}

	private JPanel result() {
		JPanel tempPanel = new JPanel();
		closeButton = new JButton("Close");
		closeButton.setActionCommand("close");
		resetButton = new JButton("Reset");
		resetButton.setActionCommand("reset");
		convertRomanButton = new JButton("Convert to Roman");
		convertRomanButton.setActionCommand("corvertToRoman");
		convertArabicButton = new JButton("Convert to Arabic");
		convertArabicButton.setActionCommand("corvertToArabic");

		tempPanel.setLayout(new GridLayout(2,2));

		tempPanel.add(convertRomanButton);
		tempPanel.add(convertArabicButton);
		tempPanel.add(resetButton);
		tempPanel.add(closeButton);

		Listener listener = new Listener();

		convertRomanButton.addActionListener(listener);
		convertArabicButton.addActionListener(listener);
		resetButton.addActionListener(listener);
		closeButton.addActionListener(listener);
		return tempPanel;
	}

	private void corvertToRoman() {
		try
		{
			int number = Integer.parseInt(getArabic.getText());
			if(number>4999)
			{
				throw new ToBigNumberException();
			}
			if(number<1)
			{
				throw new ToSmallNumberException();
			}
			if (getArabic.getText().isEmpty())
			{
				throw new EmptyField();
			}


			char[] numberArray = getArabic.getText().toUpperCase().toCharArray();
			if (getArabic.getText().length()==4)
			{
				arabicAfterConversion.setText(thousandthNumber(String.valueOf(numberArray[0])) + hundredthNumber(String.valueOf(numberArray[1])) + decimalNumber(String.valueOf(numberArray[2])) + number(String.valueOf(numberArray[3])));
			}
			else if (getArabic.getText().length()==3)
			{
				arabicAfterConversion.setText(hundredthNumber(String.valueOf(numberArray[0])) + decimalNumber(String.valueOf(numberArray[1])) + number(String.valueOf(numberArray[2])));
			}
			else if (getArabic.getText().length()==2) {
				arabicAfterConversion.setText(decimalNumber(String.valueOf(numberArray[0])) + number(String.valueOf(numberArray[1])));
			}
			else if (getArabic.getText().length()==1)
			{
				arabicAfterConversion.setText(number(String.valueOf(numberArray[0])));
			}
		}

		catch (ToBigNumberException Exception)
		{
			infoMessage("The number is too large", "Error");
		}
		catch (ToSmallNumberException Exception)
		{
			infoMessage("The number is too small", "Error");
		}
		catch (NumberFormatException Exception)
		{
			infoMessage("The value provided is not a number", "Error");
		}
		catch (EmptyField Exception)
		{
			infoMessage("You have not entered any value", "Error");
		}
		catch (nullNumberError Exception)
		{
			infoMessage("Not null", "Error");
		}
		catch (Exception Exception)
		{
			infoMessage("Something went wrong\n"+Exception, "Error");
		}
	}


	private String thousandthNumber(String number) throws nullNumberError {
		if (Integer.parseInt(number)==1){
			return  "M";
		}
		else if (Integer.parseInt(number)==2){
			return  "MM";
		}
		else if (Integer.parseInt(number)==3){
			return  "MMM";
		}
		else if (Integer.parseInt(number)==4){
			return  "MMMM";
		}
		else if (Integer.parseInt(number)==0){
			throw new nullNumberError();
		}
		return null;
	}
	private String hundredthNumber(String number) throws nullNumberError {
		if (Integer.parseInt(number)==1){
			return  "C";
		}
		else if (Integer.parseInt(number)==2){
			return  "CC";
		}
		else if (Integer.parseInt(number)==3){
			return  "CCC";
		}
		else if (Integer.parseInt(number)==4){
			return  "CD";
		}
		else if (Integer.parseInt(number)==5){
			return  "D";
		}
		else if (Integer.parseInt(number)==6){
			return  "DC";
		}
		else if (Integer.parseInt(number)==7){
			return  "DCC";
		}
		else if (Integer.parseInt(number)==8){
			return  "DCCC";
		}
		else if (Integer.parseInt(number)==9){
			return  "CM";
		}
		else if (Integer.parseInt(number)==0){
			throw new nullNumberError();
		}
		return null;
	}

	private String decimalNumber(String number) throws nullNumberError {
		if (Integer.parseInt(number)==1){
			return  "X";
		}
		else if (Integer.parseInt(number)==2){
			return  "XX";
		}
		else if (Integer.parseInt(number)==3){
			return  "XXX";
		}
		else if (Integer.parseInt(number)==4){
			return  "XL";
		}
		else if (Integer.parseInt(number)==5){
			return  "L";
		}
		else if (Integer.parseInt(number)==6){
			return  "LX";
		}
		else if (Integer.parseInt(number)==7){
			return  "LXX";
		}
		else if (Integer.parseInt(number)==8){
			return  "LXXX";
		}
		else if (Integer.parseInt(number)==9){
			return  "XC";
		}
		else if (Integer.parseInt(number)==0){
			throw new nullNumberError();
		}
		return null;
	}

	private String  number(String number) throws nullNumberError {
		if (Integer.parseInt(number)==1){
			return  "I";
		}
		else if (Integer.parseInt(number)==2){
			return  "II";
		}
		else if (Integer.parseInt(number)==3){
			return  "III";
		}
		else if (Integer.parseInt(number)==4){
			return  "IV";
		}
		else if (Integer.parseInt(number)==5){
			return  "V";
		}
		else if (Integer.parseInt(number)==6){
			return  "VI";
		}
		else if (Integer.parseInt(number)==7){
			return  "VII";
		}
		else if (Integer.parseInt(number)==8){
			return  "VIII";
		}
		else if (Integer.parseInt(number)==9){
			return  "IX";
		}
		else if (Integer.parseInt(number)==0){
			throw new nullNumberError();
		}
		return null;
	}

	private void corvertToArabic() {
		try
		{
			char[] arrayNumber = getRoman.getText().toUpperCase().toCharArray();
			String romanNumbers = "IVXLCDM";
			for (int j=0 ;j< getRoman.getText().length(); j++)
			{
				if (!romanNumbers.contains(String.valueOf(arrayNumber[j])))
				{
					throw new NotRomanNumber();
				}
			}
			if (getRoman.getText().isEmpty())
			{
				throw new EmptyField();
			}
			romanAfterConversion.setText(arabicNumber(getRoman.getText()));
		}
		catch (NumberFormatException Exception)
		{
			infoMessage("This is not a Roman numeral", "Error");
		}
		catch (EmptyField Exception)
		{
			infoMessage("You have not entered any value", "Error");
		}
		catch (Exception Exception)
		{
			infoMessage("Something went wrong\n"+Exception, "Error");
		}
	}


	private String arabicNumber(String numberToFuction)
	{
		try
		{
			String number = numberToFuction;
			int numberArabic=0;

			if (number.contains("MMMM"))
			{
				numberArabic += 4000;
				number=number.substring(4);
			}
			else if (number.contains("MMM")){
				System.out.print("Asercja 2a");
				numberArabic += 3000;
				number=number.substring(3);
			}
			else if (number.contains("MM")){
				numberArabic += 2000;
				number=number.substring(2);
			}
			else if (number.contains("M")){
				numberArabic += 1000;
				number=number.substring(1);
			}



			if (number.contains("DCCC")){
				numberArabic += 800;
				number=number.substring(4);
			}
			else if (number.contains("DCC")){
				numberArabic += 700;
				number=number.substring(3);
			}
			else if (number.contains("CCC")){
				numberArabic += 300;
				number=number.substring(3);
			}
			else if (number.contains("CM")){
				numberArabic += 900;
				number=number.substring(2);
			}
			else if (number.contains("DC")){
				numberArabic += 600;
				number=number.substring(2);
			}
			else if (number.contains("CD")){
				numberArabic += 400;
				number=number.substring(2);
			}
			else if (number.contains("CC")){
				numberArabic += 200;
				number=number.substring(2);
			}
			else if (number.contains("D")){
				numberArabic += 500;
				number=number.substring(1);
			}
			else if (number.contains("C")){
				numberArabic += 100;
				number=number.substring(1);
			}



			if (number.contains("LXXX")){
				numberArabic += 80;
				number=number.substring(4);
			}
			else if (number.contains("LXX")){
				numberArabic += 70;
				number=number.substring(3);
			}
			else if (number.contains("XXX")){
				numberArabic += 30;
				number=number.substring(3);
			}
			else if (number.contains("XC")){
				numberArabic += 90;
				number=number.substring(2);
			}
			else if (number.contains("LX")){
				numberArabic += 60;
				number=number.substring(2);
			}
			else if (number.contains("XL")){
				numberArabic += 40;
				number=number.substring(2);
			}
			else if (number.contains("XX")){
				numberArabic += 20;
				number=number.substring(2);
			}
			else if (number.contains("L")){
				numberArabic += 50;
				number=number.substring(1);
			}
			else if (number.contains("X")){
				numberArabic += 10;
				number=number.substring(1);
			}



			if (number.contains("VIII")){
				numberArabic += 8;
				number=number.substring(4);
			}
			else if (number.contains("III")){
				numberArabic += 3;
				number=number.substring(3);
			}
			else if (number.contains("VII")){
				numberArabic += 7;
				number=number.substring(3);
			}
			else if (number.contains("IX")){
				numberArabic += 9;
				number=number.substring(2);
			}
			else if (number.contains("VI")){
				numberArabic += 6;
				number=number.substring(2);
			}
			else if (number.contains("IV")){
				numberArabic += 4;
				number=number.substring(2);
			}
			else if (number.contains("II")){
				numberArabic += 2;
				number=number.substring(2);
			}
			else if (number.contains("V")){
				numberArabic += 5;
				number=number.substring(1);
			}
			else if (number.contains("I")){
				numberArabic += 1;
				number=number.substring(1);
			}

			if (number.length()>0)
			{
				throw new IncorrectOrderOfRomanNumeralSigns();
			}
			return String.valueOf(numberArabic);
		}
		catch (IncorrectOrderOfRomanNumeralSigns Exception)
		{
			infoMessage("Incorrect order of Roman numeral signs\n"+Exception, "Error");
			return null;
		}
	}

	private void reset()
	{
		getRoman.setText("");
		getArabic.setText("");
		romanAfterConversion.setText("");
		arabicAfterConversion.setText("");
	}

	private void infoMessage(String output, String title) {
		JOptionPane.showMessageDialog(this, output,title, JOptionPane.INFORMATION_MESSAGE);
	}

	class ToBigNumberException extends Exception
	{
		public ToBigNumberException()
		{

		}
	}

	class ToSmallNumberException extends NumberFormatException
	{
		public ToSmallNumberException()
		{

		}
	}

	class NotRomanNumber extends NumberFormatException
	{
		public NotRomanNumber()
		{

		}
	}

	class IncorrectOrderOfRomanNumeralSigns extends Exception {
		public IncorrectOrderOfRomanNumeralSigns()
		{

		}
	}

	class EmptyField extends Exception {
		public EmptyField()
		{

		}
	}
	class nullNumberError extends Exception {
		public nullNumberError()
		{

		}
	}
}
