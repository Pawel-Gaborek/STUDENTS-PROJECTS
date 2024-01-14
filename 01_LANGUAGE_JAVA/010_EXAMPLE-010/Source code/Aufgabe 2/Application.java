package com.example.calculator;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Aplication");
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e)
        {
            System.out.print("error" + e);
        }
    }
    public static void main(String[] args) {
        launch();
    }
}