package com.example.aufgabe4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class circleAndRectangle extends Application{
	@Override
	public void start(Stage Stage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/aufgabe4/fxml.fxml"));
		Parent root = loader.load();
		FXMLController FXMLController = loader.getController();
		FlowPane rootNode = new FlowPane(root);
		Scene Scene = new Scene(rootNode, 400, 270);

		FXMLController.setStage(Stage);
		FXMLController.setPane(rootNode);
		FXMLController.start();

		Stage.setTitle("Aufgabe 4");
		Stage.setScene(Scene);
		Stage.setResizable(false);
		Stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
