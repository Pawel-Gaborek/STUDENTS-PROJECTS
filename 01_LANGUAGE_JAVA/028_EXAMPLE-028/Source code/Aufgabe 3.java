package org.example;

import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args) {
        try{
            int number02 = 100/(Integer.parseInt(JOptionPane.showInputDialog("Please enter the number:")));
        }
        catch (NumberFormatException e)
        {
            System.out.println("You didn't provide a number! Format is not correct!");
            System.out.print(e);
        }
        catch (ArithmeticException e) {
            System.out.println("Divide null is not correct");
            System.out.println(e);
        }
        // Der Ausnahmehandler, der alle Ausnahmen behandelt, muss ganz am Ende stehen.
        catch(Exception e)
        {
            System.out.println("These are the remaining exceptions");
            System.out.println(e);
        }
    }
}