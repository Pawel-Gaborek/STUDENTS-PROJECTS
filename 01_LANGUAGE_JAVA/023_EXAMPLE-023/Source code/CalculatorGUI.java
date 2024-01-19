import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class CalculatorGUI extends JFrame{

    private JTextField field1, field2;
    private JButton calculate, close;
    private JButton changeLoyout;
    private JLabel result;
    String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
    private String[] calculateOption = {"addition", "subtraction", "multiplication", "division"};
    private JComboBox <String> auswahl = new JComboBox<String>(calculateOption);
    JPanel mainPanel = new JPanel();;
    private int numberLoyout=0;


    class Listener implements ActionListener {

        @Override public void actionPerformed(ActionEvent e) {
            Object trigger  = e.getSource();
            if (trigger instanceof JComboBox) {
                CalculatorGUI.this.result.setText(CalculatorGUI.this.calculate());
            }
            if (trigger instanceof JButton) {
                if (e.getActionCommand().equals("calculate"))
                {
                    CalculatorGUI.this.result.setText(CalculatorGUI.this.calculate());
                }
                if (e.getActionCommand().equals("close"))
                {
                    System.exit(0);
                }
                if (e.getActionCommand().equals("change"))
                {
                    CalculatorGUI.this.mainPanel.setLayout(CalculatorGUI.this.changeLoyout());
                    CalculatorGUI.this.mainPanel.revalidate();
                }
            }
        }
    }
    private LayoutManager changeLoyout() {
        numberLoyout++;
        if(numberLoyout == 1)
        {
            CalculatorGUI.this.setSize(150,280);
            mainPanel.setBackground(new Color(176, 192, 231));
            return new FlowLayout(FlowLayout.TRAILING,1,1);
        }
        if(numberLoyout == 2)
        {
            CalculatorGUI.this.setSize(500,150);
            mainPanel.setBackground(new Color(232, 181, 219));
            return new FlowLayout(FlowLayout.CENTER,1,1);
        }
        if(numberLoyout == 3)
        {
            CalculatorGUI.this.setSize(1200,100);
            mainPanel.setBackground(new Color(232, 204, 146));
            return new GridLayout(1,10, 1,1);
        }
        if(numberLoyout == 4)
        {
            numberLoyout = 0;
            CalculatorGUI.this.setSize(400,300);
            mainPanel.setBackground(new Color(101, 165, 102));
            return new GridLayout(5,2, 1,1);
        }
        return null;
    }

    private void panelFirst() {
        field1 = new JTextField(10);
        field2 = new JTextField(10);
        result = new JLabel("");
        mainPanel.add(new JLabel("Number 1: "));
        mainPanel.add(field1);
        mainPanel.add(new JLabel("Number 2: "));
        mainPanel.add(field2);
        mainPanel.add(new JLabel("Result: "));
        mainPanel.add(result);
    }

    private void panelSecond() {
        mainPanel.add(auswahl);
        Listener listener = new Listener();
        auswahl.addActionListener(listener);
    }

    private void panelThirdButtons() {
        close = new JButton(" Close ");
        close.setActionCommand("close");
        calculate = new JButton("Calculate");
        calculate.setActionCommand("calculate");
        changeLoyout = new JButton("Change Loyout");
        changeLoyout.setActionCommand("change");
        mainPanel.add(calculate);
        mainPanel.add(close);
        mainPanel.add(changeLoyout);
        Listener listener = new Listener();
        close.addActionListener(listener);
        calculate.addActionListener(listener);
        changeLoyout.addActionListener(listener);
    }

    public CalculatorGUI(String titel) {
        super(titel);
        try { UIManager.setLookAndFeel(lookAndFeel);
            panelFirst();
            panelSecond();
            panelThirdButtons();
            add(mainPanel);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            pack();
            setVisible(true);
        }
        catch (Exception e) {
            System.out.print("System exception: ");
            System.out.print(e);
        }
    }

    private String calculate() {
        double result = 0.0;
        boolean falseFlag = false;
        double number1 = Double.parseDouble(this.field1.getText());
        double number2 = Double.parseDouble(this.field2.getText());
        if (auswahl.getSelectedItem().toString().equals("addition"))
        {
            result = number1 + number2;
        }
        if (auswahl.getSelectedItem().toString().equals("subtraction"))
        {
            result = number1 - number2;
        }

        if (auswahl.getSelectedItem().toString().equals("multiplication"))
        {
            result = number1 * number2;
        }
        if (auswahl.getSelectedItem().toString().equals("division")) {
            if (number2 != 0.0) {
                result = number1 / number2;
            } else {
                falseFlag = true;
            }
        }
        return !falseFlag ? Double.toString(result) : "Is not correct";
    }
}
