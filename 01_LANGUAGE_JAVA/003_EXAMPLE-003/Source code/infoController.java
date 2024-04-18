package com.example.project_8;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

public class infoController {
    @FXML private Stage mainStage;
    @FXML private Label textLabel = new Label();
    @FXML protected void ok() {
        mainStage.close();
    }
    public void setStage(Stage mainStage) {
        this.mainStage = mainStage;
    }
    public void setInformation(String text) {
        try{
            textLabel.setText(text);
        }
        catch (Exception e)
        {
            System.out.print("error " + e);
        }
    }
}
