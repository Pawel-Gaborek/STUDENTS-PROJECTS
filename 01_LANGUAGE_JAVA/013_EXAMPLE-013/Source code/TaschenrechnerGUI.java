import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TaschenrechnerGUI extends JFrame{
    private JTextField eingabe1, eingabe2;
    private JButton schaltflaecheBerechnen, schaltflaecheBeenden;
    private JLabel ausgabe;
    String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
    private String[] rechnerAuswahl = {"addition", "subtraktion", "multiplikation", "division"};
    private JComboBox <String> auswahl = new JComboBox<String>(rechnerAuswahl);
    JFrame frame = new JFrame("Message");

    class MeinListener implements ActionListener {

        @Override public void actionPerformed(ActionEvent e) {
            try {
                Object ausloeser = e.getSource();
                if (ausloeser instanceof JComboBox) {
                    TaschenrechnerGUI.this.ausgabe.setText(TaschenrechnerGUI.this.berechnen());
                }
                if (ausloeser instanceof JButton) {
                    if (e.getActionCommand().equals("Rechnen")) {
                        TaschenrechnerGUI.this.ausgabe.setText(TaschenrechnerGUI.this.berechnen());
                    }
                    if (e.getActionCommand().equals("Beenden")) {
                        System.exit(0);
                    }
                }
            }
            catch (Exception exception)
            {
                System.out.print("System exception: "+exception);
            }
        }
    }

    private JPanel panelEinAusErzeugen() {
        JPanel tempPanel = new JPanel();
        try{
            eingabe1 = new JTextField(10);
            eingabe2 = new JTextField(10);
            ausgabe = new JLabel("");
            tempPanel.setLayout(new GridLayout(0,2,10,10));
            tempPanel.add(new JLabel("Zahl 1:"));
            tempPanel.add(eingabe1);
            tempPanel.add(new JLabel("Zahl 2: "));
            tempPanel.add(eingabe2);
            tempPanel.add(new JLabel("Ergebnis: "));
            tempPanel.add(ausgabe);
            tempPanel.setBorder(new TitledBorder("Ein- und Ausgabe"));
        }
        catch (Exception e)
        {
            System.out.print("System exception: "+e);
        }
        return tempPanel;
    }

    private JPanel panelBerechnungErzeugen() {
        JPanel tempPanel = new JPanel();
        try{
            tempPanel.add(auswahl);
            MeinListener listener = new MeinListener();
            auswahl.addActionListener(listener);
            tempPanel.setBorder(new TitledBorder ("Operation: "));}
        catch (Exception e){
            System.out.print("System exception: "+e);
        }
        return tempPanel;
    }

    private JPanel panelButtonErzeugen() {
        JPanel tempPanel = new JPanel();
        try{
            schaltflaecheBeenden = new JButton(" Beenden ");
            schaltflaecheBeenden.setActionCommand("Beenden");
            schaltflaecheBerechnen = new JButton("Berechnen");
            schaltflaecheBerechnen.setActionCommand("Rechnen");
            tempPanel.setLayout(new FlowLayout (FlowLayout.LEFT,20,10));
            tempPanel.add(schaltflaecheBerechnen);
            tempPanel.add(schaltflaecheBeenden);
            MeinListener listener = new MeinListener();
            schaltflaecheBeenden.addActionListener(listener);
            schaltflaecheBerechnen.addActionListener(listener);}
        catch (Exception e){
            System.out.print("System exception: "+e);
        }
        return tempPanel;
    }

    public TaschenrechnerGUI(String titel) {
        super(titel);
        try { UIManager.setLookAndFeel(lookAndFeel);
            JPanel panelEinAus, panelBerechnung, panelButtons;
            panelEinAus = panelEinAusErzeugen();
            panelBerechnung = panelBerechnungErzeugen();
            panelButtons = panelButtonErzeugen();
            setLayout(new GridLayout(0,3));
            add(panelEinAus);
            add(panelBerechnung);
            add(panelButtons);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            pack(); setVisible(true);
        }
        catch(Exception e) {
            System.out.println("Was falsch gelaufen ist: "+e);}
    }

    private String berechnen() {
        double ergebnis = 0.0;
        boolean fehlerFlag = false;
        double zahl1;
        double zahl2;
        JFrame frame = new JFrame("Message");
        try{
            zahl1 = Double.parseDouble(this.eingabe1.getText());
            zahl2 = Double.parseDouble(this.eingabe2.getText());
            if (auswahl.getSelectedItem().toString().equals("addition"))
            {
                ergebnis = zahl1 + zahl2;
            }
            if (auswahl.getSelectedItem().toString().equals("subtraktion"))
            {
                ergebnis = zahl1 - zahl2;
            }
            if (auswahl.getSelectedItem().toString().equals("multiplikation"))
            {
                ergebnis = zahl1 * zahl2;
            }
            if (auswahl.getSelectedItem().toString().equals("division")) {
                if(zahl2==0.0)
                {
                    throw new ArithmeticException();
                }
                ergebnis = zahl1 / zahl2;
            }
        }
        catch(NumberFormatException e) {
            fehlerFlag=true;
            JOptionPane.showMessageDialog(frame, "Ungültiges Zeichenformat angegeben.\n"+e);
        }
        catch (ArithmeticException e){
            fehlerFlag = true;
            JOptionPane.showMessageDialog(frame, "Dividieren durch Null ist unmöglich.\n"+e);
        }
        catch(Exception e){
            fehlerFlag=true;
            JOptionPane.showMessageDialog(frame, "Die mathematische Aktion ist fehlgeschlagen, weil:\n"+e);
        }
        return !fehlerFlag ? Double.toString(ergebnis) : "Nicht definiert";
    }
}
