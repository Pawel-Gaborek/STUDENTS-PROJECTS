package com.example.aufgabe_111;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Words extends Stage{
    private FXMLControllerWords controller;
    public Words(Stage stage) {
        super();
        initOwner(stage);
        FXMLLoader load = new FXMLLoader(getClass().getResource("sb_word_editor.fxml"));
        try {
            Parent root = load.load();
            controller = load.getController();
            Scene scene = new Scene(root, 600, 350);
            setScene(scene);
            initModality(Modality.WINDOW_MODAL);
            initStyle(StageStyle.UTILITY);
            controller.setStage(this);
        }
        catch (IOException e) {
            System.out.println("error: "+e);
        }
    }
    public void showWindow() {
        showAndWait();
    }
}
