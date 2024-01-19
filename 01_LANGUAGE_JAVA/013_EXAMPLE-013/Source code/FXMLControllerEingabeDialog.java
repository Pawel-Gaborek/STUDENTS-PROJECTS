package com.example.aufgabe_111;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLControllerEingabeDialog {
	//die beiden Labels
	//die Bezeichner stammen aus dem FXML-Beschreibung
	@FXML private Label messageLabel, detailsLabel;
	//f�r das Eingabefeld
	@FXML private TextField eingabeName;

	//f�r die B�hne
	private Stage meineStage;
	//f�r die Eingabe
	private String eingabe;
	
	//die Methode zum Schlie�en
	@FXML protected void okKlick(ActionEvent event) {
		//den Text kopieren
		eingabe = eingabeName.getText();
		//die B�hne und damit das Fenster schlie�en
		meineStage.close();
	}

    //die Methode setzt die B�hne auf den �bergebenen Wert
	public void setStage(Stage meineStage) {
		this.meineStage = meineStage;
	}

	//die �berschrift setzen
	public void setUeberschrift(String ueberschrift) {
		messageLabel.setText(ueberschrift);	
	}

	//den Text setzen
	public void setInfotext(String infotext) {
		detailsLabel.setText(infotext);
	}	
	
	//die Eingabe beschaffen
	public String getEingabe() {
		return eingabe;
	}
}
