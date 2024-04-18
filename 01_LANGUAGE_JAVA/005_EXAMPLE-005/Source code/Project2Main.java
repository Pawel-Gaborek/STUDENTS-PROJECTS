package org.example;
import javax.swing.*;

public class Project2Main {
	public static void main(String[] args) {
		String  look;
		look = UIManager.getCrossPlatformLookAndFeelClassName();
		new Project2( "Program number of iterations", look);
	}
}
