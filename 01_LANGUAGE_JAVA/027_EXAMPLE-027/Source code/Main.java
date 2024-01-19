import java.text.NumberFormat;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        // a)	ein Argument wird in einem ungültigen Format übergeben.
        try{
            int number01 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number:"));
        }
        catch (NumberFormatException e)
        {
            System.out.println("You didn't provide a number! Format is not correct!");
            System.out.print(e);
        }

        // b)	ein Zugriff auf eine nicht vorhandene Klasse.
        try{
        String className = JOptionPane.showInputDialog("Please enter the class name:");
        Class.forName(className);
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not exist");
            System.out.println(e);
        }

        // c)	eine gescheiterte Umwandlung einer Zeichenkette in einen numerischen Wert.
        try{
            int number02 = Integer.valueOf(JOptionPane.showInputDialog("Please enter the number:"));
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Invalid conversion");
            System.out.println(e);
        }

        // d)	Zugriff auf einen ungültigen Index in einem Array.
        try{
            int[] temp=new int[4];
            temp[6]=Integer.parseInt(JOptionPane.showInputDialog("Please enter the number"));
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println("Index not exist");
            System.out.println(e);
        }

        // e)	für sämtliche echte Ausnahmen, die auftreten können.
        try
        {
            int number03 = Integer.parseInt("this ist number not string");
        }
        catch(Exception e)
        {
            System.out.println("These are the remaining exceptions");
            System.out.println(e);
        }
    }
}