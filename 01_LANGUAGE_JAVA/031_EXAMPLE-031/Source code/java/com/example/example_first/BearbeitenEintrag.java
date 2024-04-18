package com.example.example_first;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;

public class BearbeitenEintrag extends JDialog {
	//automatisch �ber Eclipse erzeugt
	private static final long serialVersionUID = 2674865770208476234L;
	
	//f�r die Eingabefelder
	private JTextField name, nachname, strasse, plz, ort, telefon;
	//f�r die Anzeige
	private JLabel nummer;
	private JLabel from;

	//======
	//======
	//======BEARBEITUNG
	private JLabel numberRecords;
	private JLabel number;

	//f�r die Aktionen
	private MeineAktionen loeschenAct, vorAct, zurueckAct, startAct, endeAct, aktualisierenAct;
	
	//f�r die Verbindung
	private Connection verbindung;
	private ResultSet ergebnisMenge;
	
	//f�r die Abfrage
	private String sqlAbfrage;
	
	//eine innere Klasse f�r die Aktionen
	class MeineAktionen extends AbstractAction {
		//automatisch �ber Eclipse erg�nzt
		private static final long serialVersionUID = 8673560298548765044L;

		//der Konstruktor 
		public MeineAktionen(String text, ImageIcon icon, String beschreibung, KeyStroke shortcut, String actionText) {
			//den Konstruktor der �bergeordneten Klasse mit dem Text und dem Icon aufrufen
			super(text, icon);
			//die Beschreibung setzen f�r den Bildschirmtipp
			putValue(SHORT_DESCRIPTION, beschreibung);
			//den Shortcut
			putValue(ACCELERATOR_KEY, shortcut);
			//das ActionCommand
			putValue(ACTION_COMMAND_KEY, actionText);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("vor"))
				ganzVor();
			if (e.getActionCommand().equals("zurueck"))
				ganzZurueck();
			if (e.getActionCommand().equals("einenvor"))
				einenVor();
			if (e.getActionCommand().equals("einenzurueck"))
				einenZurueck();
			if (e.getActionCommand().equals("loeschen"))
				loeschen();
			if (e.getActionCommand().equals("aktualisieren"))
				aktualisieren();
		}
	}
	
	//die innere Klasse f�r die Fenster-Ereignisse
	class FensterListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			super.windowClosing(e);
			//======
			//======
			//======BEARBEITUNG
			String arg = "jdbc:mysql://serwer2309035.home.pl:3380/36948764_adressen?useSSL=false&serverTimezone=Europe/Warsaw";
			//die Datenbankverbindung trennen
			//ergebnisMenge und verbindung sind Variablen der �u�eren Klasse 
			try {
				BearbeitenEintrag.this.ergebnisMenge.close();
				BearbeitenEintrag.this.verbindung.close();

				//======
				//======
				//======BEARBEITUNG
				MiniDBTools.schliessenDB(arg);
			}
			catch(Exception exc) {
				JOptionPane.showMessageDialog(null, "Problem: \n" + exc.toString());
			}
		}
	}
	
	//der Konstruktor der Klasse BearbeitenEintrag
	public BearbeitenEintrag(JFrame parent, boolean modal) {
		super(parent, modal);
		//======
		//======
		//======BEARBEITUNG
		String url_icons = "/Volumes/DOK/FERNAKADEMIE/16_JAVA-16B/01_KOD/Example_first/Example_first/src/main/resources/com/example/example_first/icons/";
		setTitle("Eintraege bearbeiten");

		//wir nehmen ein Borderlayout
		setLayout(new BorderLayout(40,40));
		//die Aktionen erstellen
		loeschenAct = new MeineAktionen("Datensatz l�schen", 
				new ImageIcon(url_icons+"Delete24.gif"),
				"L�scht den aktuellen Datensatz", 
				null,
				"loeschen");
		vorAct = new MeineAktionen("Einen Datensatz weiter", 
				new ImageIcon(url_icons+"Forward24.gif"),
				"Bl�ttert einen Datensatz weiter", 
				null, 
				"einenvor");
		zurueckAct = new MeineAktionen("Einen Datensatz zur�ck", 
				new ImageIcon(url_icons+"Back24.gif"),
				"Bl�ttert einen Datensatz zur�ck", 
				null, 
				"einenzurueck");
		startAct = new MeineAktionen("Zum ersten Datensatz",
				new ImageIcon(url_icons+"Front24.gif"),
				"Geht zum ersten Datensatz", 
				null, 
				"vor");
		endeAct = new MeineAktionen("Zum letzten Datensatz", 
				new ImageIcon(url_icons+"End24.gif"),
				"Geht zum letzten Datensatz", 
				null, 
				"zurueck");
		aktualisierenAct = new MeineAktionen("�nderungen speichern", 
				new ImageIcon(url_icons+"Save24.gif"),
				"Speichert �nderungen am aktuellen Datensatz", 
				null, 
				"aktualisieren");
		
		//die Symbolleiste oben einf�gen
		add(symbolleiste(), BorderLayout.NORTH);

		//die Oberfl�che erstellen und einf�gen
		add(initGui(), BorderLayout.CENTER);

		//======
		//======
		//======BEARBEITUNG
		add(allRecords(),BorderLayout.EAST);

		//zuerst nehmen wir alle Eintr�ge aus der Tabelle adressen
		sqlAbfrage = "SELECT * FROM adressen";
		//diese Abfrage w�hlt nur alle M�llers aus
		//sqlAbfrage = "SELECT * FROM adressen WHERE nachname = 'M�ller'";
		
		//die Datenbankverbindung herstellen
		initDB();
		
		//die Verbindung mit dem Listener des Fensters herstellen
		addWindowListener(new FensterListener());
		
		//packen und anzeigen
		pack();
		setVisible(true);
		//Standardoperation setzen
		//hier den Dialog ausblenden und l�schen
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	//======
	//======
	//======BEARBEITUNG
	private JPanel allRecords() {
		JPanel JPanel = new JPanel();
		JPanel.setLayout(new GridLayout(0,4));
		JPanel.add(new JLabel("Record: "));
		number = new JLabel();
		JPanel.add(number);
		from = new JLabel();
		from.setText("from");
		JPanel.add(from);
		numberRecords = new JLabel();
		JPanel.add(numberRecords);
		return JPanel;
	}
	
	//f�gt die Felder in ein Panel ein und liefert das Panel zur�ck
	private JPanel initGui() {
		JPanel tempPanel = new JPanel();
		//im GridLayout mit zwei Spalten
		tempPanel.setLayout(new GridLayout(0,2));
		//f�r die Nummer (nur Anzeige)
		tempPanel.add(new JLabel("ID-Nummer:"));
		nummer = new JLabel();
		tempPanel.add(nummer);
		//f�r die anderen Felder
		tempPanel.add(new JLabel("Vorname:"));
		name = new JTextField();
		tempPanel.add(name);
		tempPanel.add(new JLabel("Nachname:"));
		nachname = new JTextField();
		tempPanel.add(nachname);
		tempPanel.add(new JLabel("Strasse:"));
		strasse = new JTextField();
		tempPanel.add(strasse);
		tempPanel.add(new JLabel("PLZ:"));
		plz = new JTextField();
		tempPanel.add(plz);
		tempPanel.add(new JLabel("Ort:"));
		ort = new JTextField();
		tempPanel.add(ort);
		tempPanel.add(new JLabel("Telefon:"));
		telefon = new JTextField();
		tempPanel.add(telefon);
		//zur�ckgeben
		return tempPanel;
	}
	
	//die Symbolleiste erzeugen und zur�ckgeben
	private JToolBar symbolleiste() {
		JToolBar leiste = new JToolBar();
		//die Symbole �ber die Aktionen einbauen
		leiste.add(loeschenAct);
		leiste.add(aktualisierenAct);
		//Abstand einbauen
		leiste.addSeparator();
		leiste.add(startAct);
		leiste.add(zurueckAct);
		leiste.add(vorAct);
		leiste.add(endeAct);
		
		//die komplette Leiste zur�ckgeben
		return (leiste);
	}
	
	//die Verbindung zur Datenbank herstellen
	private void initDB() {
		try{
			//Verbindung herstellen und Ergebnismenge beschaffen

			//======
			//======
			//======BEARBEITUNG
			String treiber = "com.mysql.cj.jdbc.Driver";
			String arg = "jdbc:mysql://serwer2309035.home.pl:3380/36948764_adressen?useSSL=false&serverTimezone=Europe/Warsaw";

			verbindung= MiniDBTools.oeffnenDB(treiber, arg);
			ergebnisMenge = MiniDBTools.liefereErgebnis(verbindung, sqlAbfrage);
			if (ergebnisMenge.next())
				datenLesen();
			howManyrecords();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Problem: \n" + e.toString());
		}
	}

	//die Methode liest die Daten und schreibt sie in die Felder
	private void datenLesen() {
		try {
			nummer.setText(Integer.toString(ergebnisMenge.getInt(1)));
			name.setText(ergebnisMenge.getString(2));
			nachname.setText(ergebnisMenge.getString(3));
			strasse.setText(ergebnisMenge.getString(4));
			plz.setText(ergebnisMenge.getString(5));
			ort.setText(ergebnisMenge.getString(6));
			telefon.setText(ergebnisMenge.getString(7));
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Problem: \n" + e.toString());
		}
	}

	//die Methode geht zum ersten Datensatz
	private void ganzVor() {
		try {
			//ganz nach vorne gehen
			if (Integer.parseInt(numberRecords.getText())>1)
			{
				ergebnisMenge.first();
				datenLesen();
				howManyrecords();
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Problem: \n" + e.toString());
		}
	}

	//die Methode geht zum letzten Datensatz
	private void ganzZurueck() {
		try {
			//ganz nach hinten gehen
			if (Integer.parseInt(numberRecords.getText())>1)
			{
				ergebnisMenge.last();
				datenLesen();
				howManyrecords();
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Problem: \n" + e.toString());
		}
	}

	//die Methode geht einen Datensatz weiter
	private void einenVor() {
		try {
			if(ergebnisMenge.getRow()<Integer.parseInt(numberRecords.getText()))
			{
				if (ergebnisMenge.next())
				{
					datenLesen();
					howManyrecords();
				}
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Problem: \n" + e.toString());
		}
	}
	
	//die Methode geht einen Datensatz zur�ck
	private void einenZurueck() {
		try{
			if (ergebnisMenge.getRow() > 1)
			{
				if (ergebnisMenge.previous())
				{
					datenLesen();
					howManyrecords();
				}
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Problem: \n" + e.toString());
		}
	}
	
	//die Methode l�scht einen Datensatz
	private void loeschen() {
		try {
			//wir m�ssen uns merken, wo wir sind
			int position;
			position = ergebnisMenge.getRow();
			//den Eintrag l�schen
			ergebnisMenge.deleteRow();
        	//Ergebnismenge schlie�en
	        ergebnisMenge.close();
	        // und neu �ffnen
			ergebnisMenge = MiniDBTools.liefereErgebnis(verbindung, sqlAbfrage);
			
			//und wieder zur "alten" Position gehen
			ergebnisMenge.absolute(position);
			//stehen wir jetzt hinter dem letzten?
			if (ergebnisMenge.isAfterLast())
				//dann zum letzten gehen
				ergebnisMenge.last();
			//die Daten neu lesen
			datenLesen();
			howManyrecords();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Problem: \n" + e.toString());
		}
	}

	//die Methode aktualisiert einen Eintrag
	private void aktualisieren() {
		try {
			//wir m�ssen uns merken, wo wir sind
			int position;
			position = ergebnisMenge.getRow();
			
			//die Daten aktualisieren
        	ergebnisMenge.updateString(2, name.getText());
        	ergebnisMenge.updateString(3, nachname.getText());
        	ergebnisMenge.updateString(4, strasse.getText());
        	ergebnisMenge.updateString(5, plz.getText());
        	ergebnisMenge.updateString(6, ort.getText());
        	ergebnisMenge.updateString(7, telefon.getText());   	
        	//den Datensatz aktualisieren
        	ergebnisMenge.updateRow();
        	//Ergebnismenge schlie�en
	        ergebnisMenge.close();
	        // und neu �ffnen
			ergebnisMenge = MiniDBTools.liefereErgebnis(verbindung, sqlAbfrage);
			//und wieder zur "alten" Position gehen
			ergebnisMenge.absolute(position);
			//die Daten neu lesen
			datenLesen();
			howManyrecords();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Problem: \n" + e.toString());
		}
	}

	//======
	//======
	//======BEARBEITUNG
	private void howManyrecords() {
		ResultSet result;
		int size = 0;
		String temp="";
		try{
			result = MiniDBTools.liefereErgebnis(verbindung, "SELECT * FROM adressen");
			while (result.next()) {
				size++;
			}
			number.setText(Integer.toString(ergebnisMenge.getRow()));
			numberRecords.setText(Integer.toString(size));
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Error: \n" + e.toString());
		}
	}
}
