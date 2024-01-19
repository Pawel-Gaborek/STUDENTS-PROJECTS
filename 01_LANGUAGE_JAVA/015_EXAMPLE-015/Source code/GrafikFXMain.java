package com.example.aufgabe2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class GrafikFXMain extends Application{
	@Override
	public void start(Stage meineStage) throws Exception {
		FlowPane rootNode = new FlowPane();
		Canvas mainCanvas = new Canvas(400, 400);
		GraphicsContext gc = mainCanvas.getGraphicsContext2D();
		rootNode.getChildren().add(mainCanvas);
		Geometry.geometry(gc, 60, 60, 100, 100, 255,195,10, 15);
		Scene meineScene = new Scene(rootNode, 400, 400);
		meineStage.setTitle("Grafikspielereien");
		meineStage.setScene(meineScene);
		meineStage.show();
	}
	public static void main(String[] args) {
		//der Start
		launch(args);
	}
}
