package com.example.aufgabe1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FXMainCircle extends Application{
	@Override
	public void start(Stage Stage) throws Exception {
		FlowPane rootNode = new FlowPane();
		Canvas mainCanvas = new Canvas(400, 400);
		GraphicsContext gc = mainCanvas.getGraphicsContext2D();
		rootNode.getChildren().add(mainCanvas);
		Circle.CreateCircle(gc,100,100,200,200);
		Scene meineScene = new Scene(rootNode, 400, 400);
		Stage.setTitle("Circle - Aufgabe 1");
		Stage.setScene(meineScene);
		Stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
