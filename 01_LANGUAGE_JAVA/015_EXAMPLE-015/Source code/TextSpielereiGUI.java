import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextSpielereiGUI extends JFrame {
    private JLabel ausgabe;
    private JLabel label_with_text_size;
    private String text="Text size is: ";
    private JButton schaltflaecheGroesser, schaltflaecheKleiner;
    private int schriftGroesse;
    class MeinKompakterListener extends WindowAdapter implements ActionListener{
        @Override
        public void windowOpened(WindowEvent e) {
            String eingabe;
            eingabe = JOptionPane.showInputDialog("Geben Sie einen Text ein");
            ausgabe.setText( "Your text is: " + eingabe);
            pack();
            setSize(600,600);
        }

        @Override public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("bigger - >"))
            {
                schriftGroesse++;
            }
            if (e.getActionCommand().equals("< - smaller"))
            {
                schriftGroesse--;
            }
            label_with_text_size.setText(text+Integer.toString(schriftGroesse));
            ausgabe.setFont(new Font("Arial", Font.PLAIN,schriftGroesse));
            label_with_text_size.setFont(new Font("Arial", Font.PLAIN,20));
            pack();
            setSize(600,600);
        }
    }
    public TextSpielereiGUI(String titel) {

        super(titel);
        schaltflaecheGroesser = new JButton("< - smaller");
        schaltflaecheKleiner = new JButton("bigger - >");
        ausgabe = new JLabel();
        label_with_text_size = new JLabel();
        schriftGroesse = 10;
        ausgabe.setFont(new Font("Arial",Font.PLAIN,schriftGroesse));
        label_with_text_size.setFont(new Font("Arial",Font.PLAIN,20));
        label_with_text_size.setText(text+Integer.toString(schriftGroesse));
        setLayout(new GridLayout(2,2));
        add(schaltflaecheGroesser);
        add(schaltflaecheKleiner);
        add(label_with_text_size);
        add(ausgabe);
        MeinKompakterListener listener = new MeinKompakterListener();
        addWindowListener(listener);
        schaltflaecheGroesser.addActionListener(listener);
        schaltflaecheKleiner.addActionListener(listener);
        pack();
        this.setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

