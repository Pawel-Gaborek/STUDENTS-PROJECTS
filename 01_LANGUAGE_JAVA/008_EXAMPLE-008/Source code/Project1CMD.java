package org.example;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Project1CMD extends JFrame{

	private double length, width, profit, tax, price, priceWithTaxAndProfit, area, pricePerMeter, taxValue = 0.19, profitValue = 0.05;
	private boolean exit=false, newLoop=true;
	private BufferedReader newBuffer;
	private InputStreamReader newStream;

	public Project1CMD() {
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
		if (newLoop) {
			System.out.print("================           ================\n");
			System.out.print("================ Project 1 ================\n");
			System.out.print("================           ================\n\n");
		}
	}

	private void programOption() throws IOException {

		System.out.print("1) About this program.\n");
		System.out.print("2) The default tax value is 19% - change the tax value.\n");
		System.out.print("3) The default margin value is 5% - change the profit value.\n");
		System.out.print("4) Run program - calculate the price of the plot.\n");
		System.out.print("5) Exit program.\n\n");

		int option = Integer.parseInt(newBuffer.readLine());

		switch (option)
		{
			case 1:{
				errorMessageOutput("This programme was developed by Pawel Gaborek.");
				break;
			}
			case 2:{
				changeTaxValue();
				break;
			}
			case 3:{
				changeMarginValue();
				break;
			}
			case 4:{
				getNumbers();
				break;
			}
			case 5:{
				errorMessageOutput("Thank you for yus this program.");
				exit=true;
				break;
			}
		}
	}

	private void changeMarginValue() throws IOException {
		System.out.print("\nEnter the profit value (in percent): ");
		this.taxValue=Float.parseFloat(newBuffer.readLine())*0.01;
	}

	private void changeTaxValue() throws IOException {
		System.out.print("\nEnter the tax value (in percent): ");
		this.profitValue=Float.parseFloat(newBuffer.readLine())*0.01;
	}

	private void getNumbers() {
		try {
			System.out.print("\nProvide a value for length: ");
			this.length=Float.parseFloat(newBuffer.readLine());
			System.out.print("Provide a value for width: ");
			this.width=Float.parseFloat(newBuffer.readLine());
			System.out.print("Enter the price per meter: ");
			this.pricePerMeter= Float.parseFloat(newBuffer.readLine());

			area = length*width;
			price = area*pricePerMeter;
			profit =  price*profitValue;
			tax = (price+profit)*taxValue;
			priceWithTaxAndProfit = price+profit+tax;

			System.out.print("\nArea of the building plot: "+roundNumber(area)+" m²");
			System.out.print("\nThe price per square meter is: "+roundNumber(pricePerMeter)+" €/m²");
			System.out.print("\nPrice without tax and margin: "+roundNumber(price)+" €");
			System.out.print("\nThe profit is: "+roundNumber(profit)+" €");
			System.out.print("\nThe tax amount is: "+roundNumber(tax)+" €");
			System.out.print("\nThe price with tax and profit is: "+roundNumber(priceWithTaxAndProfit)+" €\n\n");

			taxValue = 0.19;
			profitValue = 0.05;
			newLoop=true;
		}
		catch (NumberFormatException Exception)
		{
			errorMessageOutput("Incorrect format of the entered data.");
		}
		catch (IOException Exception) {
			errorMessageOutput("Error entering data.");
			throw new RuntimeException(Exception);
		}
		catch (Exception Exception)
		{
			errorMessageOutput("Incorrect format of the entered data.");
		}
	}

	private void errorMessageOutput(String message) {
		System.out.print(message+"\n\n");
	}


	private String roundNumber(double number) {
		DecimalFormat round = new DecimalFormat("0.##");
		return (round.format(number));
	}
}
