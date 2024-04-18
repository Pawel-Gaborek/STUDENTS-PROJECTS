import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Editor extends JApplet{
	private static final long serialVersionUID = 3215604333266961332L;
	private static String icons = "/Volumes/DOK/FERNAKADEMIE/17_JAVA-17B/01_KOD/Aufgabe_1/src/icons/";
	class MeinListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("neu"))
				dateiNeu();
			if (e.getActionCommand().equals("laden"))
				dateiLaden();
			if (e.getActionCommand().equals("speichern"))
				dateiSpeichern();
			if (e.getActionCommand().equals("beenden"))
				beenden();
		}
	}

	private JTextArea eingabeFeld;

	@Override
	public void init() {
		setLayout(new BorderLayout());
		eingabeFeld = new JTextArea();
		add(new JScrollPane(eingabeFeld), BorderLayout.CENTER);
		menu();
		add(symbolleiste(), BorderLayout.NORTH);
		setMinimumSize(new Dimension(1000,600));
		setVisible(true);
	}
	private void menu() {
		JMenuBar menue = new JMenuBar();
		JMenu dateiMenue = new JMenu("Datei");
		MeinListener listener = new MeinListener();
		JMenuItem dateiNeu = new JMenuItem();
		dateiNeu.setText("Neu");
		dateiNeu.setIcon(new ImageIcon(icons+"new24.gif"));
		dateiNeu.setAccelerator(KeyStroke.getKeyStroke('N',InputEvent.CTRL_DOWN_MASK));
		dateiNeu.setActionCommand("neu");
		dateiNeu.addActionListener(listener);
		dateiMenue.add(dateiNeu);
		JMenuItem dateiOeffnen = new JMenuItem();
		dateiOeffnen.setText("÷ffnen...");
		dateiOeffnen.setIcon(new ImageIcon(icons+"open24.gif"));
		dateiOeffnen.setAccelerator(KeyStroke.getKeyStroke('O',InputEvent.CTRL_DOWN_MASK));
		dateiOeffnen.setActionCommand("laden");
		dateiOeffnen.addActionListener(listener);
		dateiMenue.add(dateiOeffnen);
		dateiMenue.addSeparator();
		JMenuItem dateiSpeichern = new JMenuItem();
		dateiSpeichern.setText("Speichern...");
		dateiSpeichern.setIcon(new ImageIcon(icons+"save24.gif"));
		dateiSpeichern.setAccelerator(KeyStroke.getKeyStroke('S',InputEvent.CTRL_DOWN_MASK));
		dateiSpeichern.setActionCommand("speichern");
		dateiSpeichern.addActionListener(listener);
		dateiMenue.add(dateiSpeichern);
		dateiMenue.addSeparator();
		JMenuItem dateiBeenden = new JMenuItem();
		dateiBeenden.setText("Beenden");
		dateiBeenden.setActionCommand("beenden");
		dateiBeenden.addActionListener(listener);
		dateiMenue.add(dateiBeenden);
		menue.add(dateiMenue);
		this.setJMenuBar(menue);
	}
	private JToolBar symbolleiste() {
		JToolBar leiste = new JToolBar();
		MeinListener listener = new MeinListener();
		JButton dateiNeuButton = new JButton();
		dateiNeuButton.setActionCommand("neu");
		dateiNeuButton.setIcon(new ImageIcon(icons+"new24.gif"));
		dateiNeuButton.setToolTipText("Erstellt ein neues Dokument");
		dateiNeuButton.addActionListener(listener);
		leiste.add(dateiNeuButton);
		JButton dateiOeffnenButton = new JButton();
		dateiOeffnenButton.setActionCommand("laden");
		dateiOeffnenButton.setIcon(new ImageIcon(icons+"open24.gif"));
		dateiOeffnenButton.setToolTipText("÷ffnet ein vorhandenes Dokument");
		dateiOeffnenButton.addActionListener(listener);
		leiste.add(dateiOeffnenButton);
		JButton dateiSpeichernButton = new JButton();
		dateiSpeichernButton.setActionCommand("speichern");
		dateiSpeichernButton.setIcon(new ImageIcon(icons+"save24.gif"));
		dateiSpeichernButton.setToolTipText("Speichert das aktuelle Dokument");
		dateiSpeichernButton.addActionListener(listener);
		leiste.add(dateiSpeichernButton);
		return (leiste);
	}

	private void dateiNeu() {
		if(JOptionPane.showConfirmDialog(this, "Wollen Sie wirklich ein neues Dokument anlegen?","Neues Dokument", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			eingabeFeld.setText("");
	}

	private void dateiLaden() {
		EditorDialoge dialog = new EditorDialoge();
		File datei = dialog.oeffnenDialogZeigen();
		if (datei != null) {
			try {
				eingabeFeld.read(new FileReader(datei), null);
			}
			catch (IOException e) {
				JOptionPane.showMessageDialog(this, "Beim Laden hat es ein Problem gegeben.", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	private void dateiSpeichern() {
		EditorDialoge dialog = new EditorDialoge();
		File datei = dialog.speichernDialogZeigen();
		if (datei != null) {
			try {
				eingabeFeld.write(new FileWriter(datei));
			}
			catch (IOException e) {
				JOptionPane.showMessageDialog(this, "Beim Speichern hat es ein Problem gegeben.", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	private void beenden() {
		if(JOptionPane.showConfirmDialog(this, "Sind Sie sicher?","Anwendung schlieﬂen", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			System.exit(0);
	}
}

