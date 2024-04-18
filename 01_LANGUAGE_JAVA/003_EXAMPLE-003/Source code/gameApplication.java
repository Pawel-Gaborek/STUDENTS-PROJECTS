package com.example.project_8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class gameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(gameApplication.class.getResource("game-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 685);
            stage.setTitle("One-armed bandit");
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e)
        {
            System.out.print("Error"+e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}