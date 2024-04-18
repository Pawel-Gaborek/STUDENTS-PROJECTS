package com.example.example_first;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

public class ListenAnzeige extends JDialog{
	//automatisch �ber Eclipse erzeugt
	private static final long serialVersionUID = -5140210296788483971L;

	//f�r die Schaltfl�che 
	private JButton ok;
	
	//die innere Klasse f�r den ActionListener
	class ListenListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//wurde auf OK geklickt?
			if (e.getActionCommand().equals("ok"))
				//dann Dialog schlie�en
				dispose();
		}
	}
	
	//der Konstruktor
	public ListenAnzeige(JFrame parent, boolean modal) {
		super(parent, modal);
		setTitle("Listenanzeige");
		setLayout(new FlowLayout(FlowLayout.CENTER));

		//die Daten lesen 
		lesen();
		//die Schaltfl�che
		ok = new JButton("OK");
		ok.setActionCommand("ok");
		ok.addActionListener(new ListenListener());
		add(ok);

		//Gr��e setzen und anzeigen

		//======
		//======
		//======BEARBEITUNG
		setSize(520,700);
		setVisible(true);
		
		//Standardoperation setzen
		//hier den Dialog ausblenden und l�schen
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	//die Methode liest die Daten ein und zeigt sie an
	private void lesen() {
		Connection verbindung;
		ResultSet ergebnisMenge;
		//ein Panel f�r die Anzeige
		JPanel panel = new JPanel();
		//das Layout f�r das Panel setzen
		panel.setLayout(new GridLayout(0,2));
		//ein Container mit Bildlaufleisten
		JScrollPane pane = new JScrollPane(panel);

		//======
		//======
		//======BEARBEITUNG
		pane.setPreferredSize(new Dimension(500,600));
		
		try{
			//======
			//======
			//======BEARBEITUNG
			String treiber = "com.mysql.cj.jdbc.Driver";
			String arg = "jdbc:mysql://serwer2309035.home.pl:3380/36948764_adressen?useSSL=false&serverTimezone=Europe/Warsaw";
			//Verbindung herstellen und Ergebnismenge beschaffen
			verbindung= MiniDBTools.oeffnenDB(treiber, arg);

			ergebnisMenge = MiniDBTools.liefereErgebnis(verbindung, "SELECT * FROM adressen");
			//solange Daten da sind
			while (ergebnisMenge.next()) {
				panel.add(new JLabel("ID-Nummer: "));
				//beim Lesen wird die Spaltennummer angegeben
				panel.add(new JLabel(Integer.toString(ergebnisMenge.getInt(1))));
				panel.add(new JLabel("Vorname:"));
				panel.add(new JLabel(ergebnisMenge.getString(2)));
				panel.add(new JLabel("Nachname:"));
				panel.add(new JLabel(ergebnisMenge.getString(3)));
				panel.add(new JLabel("Strasse:"));
				panel.add(new JLabel(ergebnisMenge.getString(4)));
				panel.add(new JLabel("PLZ:"));
				panel.add(new JLabel(ergebnisMenge.getString(5)));
				panel.add(new JLabel("Ort:"));
				panel.add(new JLabel(ergebnisMenge.getString(6)));
				panel.add(new JLabel("Telefon:"));
				panel.add(new JLabel(ergebnisMenge.getString(7)));
				panel.add(new JLabel("--------------"));
				panel.add(new JLabel("--------------"));
			}
			add(pane);
			
        	//Ergebnismenge und Verbindung schlie�en
	        ergebnisMenge.close();
        	verbindung.close();
        	//und das Datenbank-System auch

			//======
			//======
			//======BEARBEITUNG
			MiniDBTools.schliessenDB(arg);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Problem: \n" + e.toString());
		}
	}
}
