package org.example;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.text.DecimalFormat;

import static java.lang.Math.round;

public class Project6 extends JFrame{
	private JTextField width, length, commission, tax, price;
	private JRadioButton taxDefault, taxOwnValue, commissionDefault, commissionOwnValue;
	private JButton calculateButton, closeButton, resetButton;
	private JLabel priceWithTax, commissionValue, taxValue, area, priceNotTaxAndCommision, priceWithCommision;


	class Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("close"))
			{
				System.exit(0);
			}
			if (e.getActionCommand().equals("calculate")) {
				calculate();
			}
			if (e.getActionCommand().equals("reset"))
			{
				reset();
			}
			if (e.getActionCommand().equals("about"))
			{
				infoMessage("The program that calculates the price for a plot was authored by Pawel Gaborek.","About");
			}
			if (e.getActionCommand().equals("commission")) {
				if(!commissionDefault.isSelected())
				{
					commissionDefault.setSelected(false);
					commissionOwnValue.setSelected(true);
					commission.setEnabled(true);
				}
				else
				{
					commissionDefault.setSelected(true);
					commissionOwnValue.setSelected(false);
					commission.setEnabled(false);
				}
			}
			if (e.getActionCommand().equals("tax")) {
				if(taxDefault.isSelected())
				{
					taxDefault.setSelected(true);
					taxOwnValue.setSelected(false);
					tax.setEnabled(false);
				}
				else
				{
					taxDefault.setSelected(false);
					taxOwnValue.setSelected(true);
					tax.setEnabled(true);
				}
			}
		}
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
		calculate.setText("Calculate...");
		calculate.setAccelerator(KeyStroke.getKeyStroke('C',InputEvent.CTRL_DOWN_MASK));
		calculate.setActionCommand("calculate");
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

	public Project6(String title, String lookAndFeel) {
		super(title);
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		}
		catch (Exception e) {
		}
		//======
		JPanel plotArea, commission, result, tax, price;
		plotArea = plotArea();
		commission = commission();
		tax = tax();
		price = price();
		result = result();
		menu();
		add(plotArea,BorderLayout.NORTH);
		add(commission,BorderLayout.WEST);
		add(tax,BorderLayout.CENTER);
		add(price,BorderLayout.EAST);
		add(result, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationByPlatform(true);
		setVisible(true);
		setResizable(false);
	}

	private JPanel plotArea() {
		JPanel tempPanel = new JPanel();
		width = new JTextField(10);
		length = new JTextField(10);
		//======
		tempPanel.setLayout(new GridLayout(0,3));
		tempPanel.add(new JLabel("Width:"));
		tempPanel.add(width);
		tempPanel.add(new JLabel("m"));
		//======
		tempPanel.add(new JLabel("Length: "));
		tempPanel.add(length);
		tempPanel.add(new JLabel("m"));
		//======
		tempPanel.add(new JLabel("Building plot area: "));
		area = new JLabel();
		tempPanel.add(area);
		tempPanel.add(new JLabel("m²"));
		tempPanel.setBorder(new TitledBorder("Plot area"));
		return tempPanel;
	}

	private JPanel commission() {
		Listener listener = new Listener();

		JPanel tempPanel = new JPanel();
		commissionDefault = new JRadioButton("5%");
		commissionDefault.setActionCommand("commission");
		commissionDefault.addActionListener(listener);

		commissionOwnValue = new JRadioButton("Own value");
		commissionOwnValue.setActionCommand("commission");
		commissionOwnValue.addActionListener(listener);

		commission = new JTextField(10);
		commission.setEnabled(false);
		ButtonGroup gruppe = new ButtonGroup();
		gruppe.add(commissionDefault);
		gruppe.add(commissionOwnValue);
		commissionDefault.setSelected(true);
		commissionOwnValue.setSelected(false);
		tempPanel.setLayout(new GridLayout(0,1));
		tempPanel.add(commissionDefault);
		tempPanel.add(commissionOwnValue);
		tempPanel.add(commission);
		tempPanel.setBorder(new TitledBorder("Commission"));
		return tempPanel;
	}


	private JPanel tax() {
		Listener listener = new Listener();

		JPanel tempPanel = new JPanel();
		taxDefault = new JRadioButton("19%");
		taxOwnValue = new JRadioButton("Own value");
		taxDefault.setActionCommand("tax");
		taxDefault.addActionListener(listener);
		taxOwnValue.setActionCommand("tax");
		taxOwnValue.addActionListener(listener);

		tax = new JTextField(10);
		tax.setEnabled(false);
		ButtonGroup gruppe = new ButtonGroup();
		gruppe.add(taxDefault);
		gruppe.add(taxOwnValue);
		taxDefault.setSelected(true);
		taxOwnValue.setSelected(false);
		tempPanel.setLayout(new GridLayout(0,1));
		tempPanel.add(taxDefault);
		tempPanel.add(taxOwnValue);
		tempPanel.add(tax);
		tempPanel.setBorder(new TitledBorder("Tax"));
		return tempPanel;
	}

	private JPanel price() {
		JPanel tempPanel = new JPanel();
		price = new JTextField(10);
		tempPanel.setLayout(new GridLayout(0,1));
		price.setSize(56,1);
		tempPanel.add(price);
		tempPanel.add(new JLabel("€"));
		tempPanel.setBorder(new TitledBorder("Price per m²"));
		return tempPanel;
	}


	private JPanel result() {
		JPanel tempPanel = new JPanel();
		closeButton = new JButton("Close");
		closeButton.setActionCommand("close");
		calculateButton = new JButton("Calculate");
		calculateButton.setActionCommand("calculate");
		resetButton = new JButton("Reset");
		resetButton.setActionCommand("reset");
		tempPanel.setLayout(new GridLayout(7,2));
		priceWithTax = new JLabel();
		commissionValue = new JLabel();
		taxValue = new JLabel();
		priceNotTaxAndCommision = new JLabel();
		priceWithCommision = new JLabel();


		tempPanel.add(new JLabel("Area multiplied by price m²: "));
		tempPanel.add(priceNotTaxAndCommision);

		tempPanel.add(new JLabel("Commision: "));
		tempPanel.add(commissionValue);


		tempPanel.add(new JLabel("Price with commision: "));
		tempPanel.add(priceWithCommision);

		tempPanel.add(new JLabel("Tax: "));
		tempPanel.add(taxValue);

		tempPanel.add(new JLabel("Price with tax and commision: "));
		tempPanel.add(priceWithTax);

		tempPanel.add(calculateButton);
		tempPanel.add(closeButton);
		tempPanel.add(resetButton);

		Listener listener = new Listener();
		closeButton.addActionListener(listener);
		calculateButton.addActionListener(listener);
		resetButton.addActionListener(listener);
		return tempPanel;
	}


	private void calculate() {
		double lengthValue = 0, widthValue = 0, pricePerMeter = 0, areaSurfaceValue = 0, commissionPercent = 0.05, taxPercent = 0.19;
		double priceTax, priceCommission, priceWithTaxAndCommision, priceArea, priceNotTax;
		try {
			lengthValue = Double.parseDouble(length.getText());
		}
		catch (Exception NumberFormatException) {
			errorMessageInput(length);
		}
		try {
			widthValue = Double.parseDouble(width.getText());
		}
		catch (Exception NumberFormatException) {
			errorMessageInput(width);
		}
		try {
			pricePerMeter = Double.parseDouble(price.getText());
		}
		catch (Exception NumberFormatException) {
			errorMessageInput(price);
		}
		try {
			if (commissionDefault.isSelected())
			{
				commissionPercent = 0.05;
			}
			else
			{
				commissionPercent = Double.valueOf(commission.getText())*0.01;
			}
		}
		catch (Exception e)
		{
			errorMessageInput(price);
		}
		try
		{
			if (taxDefault.isSelected())
			{
				taxPercent = 0.19;
			}
			else
			{
				taxPercent = Double.valueOf(tax.getText())*0.01;
			}
		}
		catch (Exception e)
		{
			errorMessageInput(tax);
		}

		try {
			areaSurfaceValue = lengthValue*widthValue;
			priceArea = areaSurfaceValue*pricePerMeter;
			priceCommission = priceArea*commissionPercent;
			priceTax = (priceArea+priceCommission)*taxPercent;
			priceNotTax = priceArea+priceCommission;
			priceWithTaxAndCommision = priceNotTax+priceTax;
			area.setText(roundNumber(areaSurfaceValue));
			priceNotTaxAndCommision.setText(roundNumber(priceArea)+" €");
			commissionValue.setText(roundNumber(priceCommission)+" €");
			priceWithCommision.setText(roundNumber(priceNotTax)+" €");
			priceWithTax.setText(roundNumber(priceWithTaxAndCommision)+" €");
			taxValue.setText(roundNumber(priceTax)+" €");
		}
		catch (Exception e)
		{
			errorMessageOutput(priceWithTax);
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
		width.setText("0.00");
		length.setText("0.00");
		commission.setText("0.00");
		tax.setText("0");
		price.setText("0.00");
		priceWithTax.setText("0.00 €");
		commissionValue.setText("0.00 €");
		taxValue.setText("0.00 €");
		area.setText("0.00");
		priceNotTaxAndCommision.setText("0.00 €");
		priceWithCommision.setText("0.00 €");
	}

	private String roundNumber(double number) {
		DecimalFormat round = new DecimalFormat("0.##");
		return (round.format(number));
	}
}
