package org.example;
import javax.swing.*;

public class Project4Main {
	public static void main(String[] args) {
		String  look;
		look = UIManager.getCrossPlatformLookAndFeelClassName();
		new Project4( "Multiplication table", look);
	}
}
