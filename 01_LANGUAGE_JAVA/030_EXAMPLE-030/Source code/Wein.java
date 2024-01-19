import java.awt.*;
import java.text.NumberFormat;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Wein {
    private int alter;
    private double grundpreis;
    private double preisProFlasche;

    //der Standardkonstruktor
    public Wein() {
        //er ruft über this() den Konstruktor mit den
        // beiden Parametern auf und übergibt die
        // Standardwerte
        this(1, 10);
    }

    //der Konstruktor setzt das Alter
    //der Preis erhält einen Standardwert
    public Wein(int alter) {
        //er ruft ebenfalls über this den Konstruktor mit
        //den beiden Parametern auf
        if(alter <=0)
        {
            throw new IllegalArgumentException("Age must be grater than zero"+"\n");
        }
        else
        {
            this.alter=alter;
            this.grundpreis = 10;
        }
    }

    //der Konstruktor setzt den Preis
    //das Alter erhält einen Standardwert
    public Wein(double grundpreis) {
    //und dieser Konstruktor ruft auch den Konstruktor
    //mit den beiden Parametern auf
        if (grundpreis <= 9)
        {
            throw new IllegalArgumentException("Price must be grater than 9"+"\n");
        }
        else {
            this.alter = 1;
            this.grundpreis = grundpreis;
        }
    }

    //der Konstruktor setzt das Alter und den Grundpreis
    // er enthält jetzt Plausibilitätsprüfungen
    public Wein(int alter, double grundpreis) {
        //die Plausibilitätsprüfung für das Alter
        if (alter <= 0){
            throw new IllegalArgumentException("Age must be grater than zero"+"\n");
        }
        //sonst den Standardwert 1 setzen
        else{
            this.alter = alter;}
        //und auch für den Preis
        if (grundpreis <= 9){
            throw  new IllegalArgumentException("Price must be grater than 9"+"\n");
            }
        else{
            this.grundpreis = grundpreis;}
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Message");

        //first constructor
        try{
            Wein first_constructor = new Wein();
            JOptionPane.showMessageDialog(frame, "first_constructor Age: "+ Integer.toString ( first_constructor.alter));
            JOptionPane.showMessageDialog(frame, "first_constructor Price: "+ Double.toString ( first_constructor.grundpreis));
        }
        catch (Exception e){
            System.out.print(e);
        }

        //second constructor
        try{
            Wein second_constructor = new Wein(3);
            JOptionPane.showMessageDialog(frame, "second_constructor Age: "+ Integer.toString ( second_constructor.alter));
            JOptionPane.showMessageDialog(frame, "second_constructor Price: "+ Double.toString ( second_constructor.grundpreis));
        }
        catch (Exception e){
            System.out.print(e);
        }

        // third  constructor
        try{
            Wein third_constructor = new Wein(10.75);
            JOptionPane.showMessageDialog(frame, "third_constructor Age: "+ Integer.toString (third_constructor.alter));
            JOptionPane.showMessageDialog(frame, "third_constructor Price: "+ Double.toString (third_constructor.grundpreis));
        }
        catch (Exception e){
            System.out.print(e);
        }

        // fourth constructor
        try{
            Wein fourth_constructor = new Wein(3,17.65);
            JOptionPane.showMessageDialog(frame, "fourth_constructor Age: "+ Integer.toString (fourth_constructor.alter));
            JOptionPane.showMessageDialog(frame, "fourth_constructor Price: "+ Double.toString (fourth_constructor.grundpreis));
        }
        catch (Exception e){
            System.out.print(e);
        }
    }
}