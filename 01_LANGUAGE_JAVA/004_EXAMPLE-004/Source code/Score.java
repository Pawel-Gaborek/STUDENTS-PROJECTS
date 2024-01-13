package com.example.aufgabe_111;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class Score extends Stage{
	//f�r die B�hne
	private Stage owner;
	//f�r den obersten Knoten
	private GridPane rootNode;
	
	//f�r die Punkte
	private int punkte;

	//f�r die Liste
	//f�r die eigentliche Liste
	private Listenelement [] bestenliste;
	//f�r die Anzahl der Eintr�ge
	private int anzahl;
	
	//f�r den Dateinamen
	private String dateiName;
	
	//die innere Klasse f�r ein Listenelement
	class Listenelement implements Comparable<Listenelement> {
		//die Instanzvariablen
		private int listePunkte;
		private String listeName;
		
		//der Konstruktor
		//er ruft die Methode setzeEintrag() auf
		public Listenelement(int listePunkte, String listeName) {
			setzeEintrag(listePunkte, listeName);
		}

		//die �berschriebene Vergleichsmethode
		//die R�ckgabewerte steuern die Sortierung
		@Override
		public int compareTo(Listenelement tempEintrag) {
			if (this.listePunkte < tempEintrag.listePunkte)
				return 1;
			if (this.listePunkte > tempEintrag.listePunkte)
				return -1;
			else
				return 0;
		}
		
		//die Methode setzt die Werte f�r einen Eintrag
		public void setzeEintrag(int listePunkte, String listeName) {
			this.listeName = listeName;
			this.listePunkte = listePunkte;
		}
		
		//die Methode liefert die Punkte
		public int getListePunkte() {
			return listePunkte;
		}
		
		//die Methode liefert den Namen
		public String getListeName() {
			return listeName;
		}
	}
	
	//der Konstruktor
	//er erh�lt das �bergeordnete Fenster zugewiesen
	public Score(Stage fenster) {
		//den Konstruktor der �bergeordneten Klasse aufrufen
		super();
		owner = fenster;
		//den Besitzer zuweisen
		initOwner(fenster);
		rootNode = new GridPane();
		//die Szene erzeugen
		//an den Konstruktor werden der oberste Knoten und die Gr��e �bergeben
		Scene meineScene = new Scene(rootNode, 300, 300);
		//die Szene setzen
		setScene(meineScene);
		//der Dialog soll modal angezeigt werden
		initModality(Modality.WINDOW_MODAL);
		//und nur ein Schlie�ensymbol haben
		initStyle(StageStyle.UTILITY);
		
		//die Punkte auf 0 setzen
		loeschePunkte();
		
		//die Bestenliste hat 10 Eintr�ge
		anzahl = 10;
		
		//eine neue Instanz f�r die Bestenliste erzeugen
		bestenliste = new Listenelement[anzahl];
		//die Elemente initialisieren
		for (int index = 0; index < anzahl; index++)
			bestenliste[index] = new Listenelement(0,"Nobody");
		
		//den Dateinamen setzen
		dateiName = "score.dat";

		//ist die Datei score.dat vorhanden?
		File dateiTest = new File(dateiName);
		//wenn ja, lesen wir die Daten ein
		if (dateiTest.exists() == true)
			datenLesen();
	}
	
	//den Dialog anzeigen
	public void dialogZeigen() {
	}
	
	//die Methode ver�ndert die Punkte
	//Sie erh�ht und verringert die aktuelle Punktzahl und gibt den aktuellen Wert zur�ck
	//das Verringern erfolgt durch die �bergabe eines negativen Wertes
	public int veraenderePunkte(int punkte) {
		this.punkte = this.punkte + punkte;
		return this.punkte;
	}
	
	//die Methode setzt die Punkte zur�ck auf 0
	//f�r das HangMan-Spiel wird die Methode nicht zwingend ben�tigt
	public void loeschePunkte() {
		punkte = 0;
	}
	
	//die Methode setzt einen neuen Eintrag in die Liste
	//wenn ein neuer Eintrag erfolgt, wird true geliefert, sonst fals
	public boolean neuerEintrag() {
		String tempName;
		//wenn die aktuelle Punktzahl gr��er ist als der letzte Eintrag
		//in der Liste, wir der letzte Eintrag �berschrieben und die Liste
		//neu sortiert
		if (punkte > bestenliste[anzahl-1].getListePunkte()){
			//den Namen beschaffen �ber einen eigenen Dialog
			//den Dialog erzeugen und anzeigen
			JavaFX_EingabeDialog meinDialog = new JavaFX_EingabeDialog(owner);
			meinDialog.setzeInfo("Gewonnen", "Herzlichen Gl�ckwunsch", "Geben Sie Ihren Namen ein");
			meinDialog.dialogZeigen();
			tempName = meinDialog.wertHolen();
			//wurde etwas eingegeben?
			if (tempName.isEmpty())
				tempName = "Max Mustermann";
			//den neuen Eintrag setzen
			bestenliste[anzahl-1].setzeEintrag(punkte, tempName);
			//die Liste sortieren
			Arrays.sort(bestenliste);
			//die sortierte Liste zur�ckschreiben
			datenSchreiben();
			return true;
		}
		else
			return false;
	}
	
	//die Methode zeigt die Liste an
	//dazu werden die einzelnen Eintr�ge geschrieben
	//und die Oberfl�che dann angezeigt
	public void listeZeigen() {
		//den Titel setzen
		setTitle("Bestenliste");
		//die �berschriften einf�gen
		rootNode.add(new Label("Punkte"), 0, 0);
		rootNode.add(new Label("Name"), 1, 0);
		//und jetzt die Eintr�ge aus der Liste
		for (int index = 0; index < anzahl; index++) {
			//erst die Punkte
			rootNode.add(new Label(Integer.toString(bestenliste[index].getListePunkte())), 0, index + 1);
			//dann der Name
			rootNode.add(new Label(bestenliste[index].getListeName()), 1, index + 1);
		}
		//anzeigen und abwarten
		showAndWait();
	}
	
	//die Methode schreibt die Bestenliste komplett in eine bin�re Datei score.dat
	public void datenSchreiben() {
		//die Datei zum Lesen und Schreiben �ffnen
		try (RandomAccessFile datei = new RandomAccessFile(dateiName,"rw")){
			//die Daten in die Datei schreiben
			for (int index = 0; index < anzahl; index++) {
				//erst die Punkte
				datei.writeInt(bestenliste[index].getListePunkte());
				//dann den Namen
				datei.writeUTF(bestenliste[index].getListeName());
			}
		} 
		catch (IOException e) {
				System.out.println("Beim Schreiben der Bestenliste ist ein Problem aufgetreten");
		}
	}

	//die Methode liest die Bestenliste komplett aus einer bin�re Datei score.dat
	public void datenLesen() {
		//zum leichteren Verarbeiten
		String tempName;
		int tempPunkte;
		//die Datei zum Lesen �ffnen
		try (RandomAccessFile datei = new RandomAccessFile(dateiName,"r")){
			//die Daten aus der Datei lesen
			for (int index = 0; index < anzahl; index++) {
				//erst die Punkte
				tempPunkte = datei.readInt();
				//dann den Namen
				tempName = datei.readUTF();
				//und nun zuweisen
				bestenliste[index].setzeEintrag(tempPunkte, tempName);
			}
		}
		catch (IOException e) {
			System.out.println("Beim Laden der Bestenliste ist ein Problem aufgetreten");
		}
	}
}
