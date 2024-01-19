package com.example.aufgabe_111;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HangmanFX extends Application{
	@Override
	public void start(Stage meineStage) throws Exception {
		//eine Instanz von FXMLLoader erzeugen
		FXMLLoader meinLoader = new FXMLLoader(getClass().getResource("sb_hangman.fxml"));
		//die Datei laden
		Parent root = meinLoader.load();
		//den Controller beschaffen
		FXMLController meinController = meinLoader.getController();
		//und die B�hne �bergeben
		meinController.setStage(meineStage);
		
		//die Szene erzeugen
		//an den Konstruktor werden der oberste Knoten und die Gr��e �bergeben
		Scene meineScene = new Scene(root, 600, 500);

		//den Titel �ber stage setzen
		meineStage.setTitle("Hangman");
		//die Szene setzen
		meineStage.setScene(meineScene);

		meineStage.setResizable(false);
		//und anzeigen
		meineStage.show();
		
		//hier muss noch die �bergabe erfolgen
		
		Score meinScore = new Score(meineStage);
		meinScore.listeZeigen();
		meinScore.neuerEintrag();
	}
	
	public static void main(String[] args) {
		//der Start
		launch(args);
	}
}
