import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

public class MoveWindow extends JFrame {
    private JButton left, right;
    private JButton up, down;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    class Listener extends WindowAdapter implements ActionListener{
        @Override public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("right - ⮕"))
            {
                if(!(getX()+200>screenSize.width)) {
                    setLocation(getX() + 10, getY());}}
            if (e.getActionCommand().equals("⬅ - left"))
            {
                if(!(getX()<0))
                {
                    setLocation(getX() - 10, getY());}}
            if (e.getActionCommand().equals("⬆- up"))
            {
                if(getY()>0)
                {
                    setLocation(getX(), getY()-10);}}
            if (e.getActionCommand().equals("⬇ - down"))
            {
                if(!(getY()+200>screenSize.height)) {
                    setLocation(getX(), getY() + 10);}}
            pack();
            setSize(200,200);
        }
    }
    public MoveWindow(String title) {
        super(title);
        setLayout(new BorderLayout(25,25));
        setLocation(screenSize.width/2-100, screenSize.height/2-100);
        setLocationByPlatform(true);

        left= new JButton("⬅ - left");
        right = new JButton("right - ⮕");
        up = new JButton("⬆- up");
        down = new JButton("⬇ - down");

        add(left,BorderLayout.WEST);
        add(right,BorderLayout.EAST);
        add(up,BorderLayout.NORTH);
        add(down,BorderLayout.SOUTH);

        Listener listener = new Listener();
        addWindowListener(listener);
        left.addActionListener(listener);
        right.addActionListener(listener);
        up.addActionListener(listener);
        down.addActionListener(listener);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.setSize(200,200);
    }
}

