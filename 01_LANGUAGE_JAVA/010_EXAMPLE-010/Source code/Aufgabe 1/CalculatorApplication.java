package com.example.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.application.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CalculatorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(CalculatorApplication.class.getResource("calculator-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Calculator");
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