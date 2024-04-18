package com.example.project_7;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DialogInfoControllerInfo {
    @FXML private Label messageLabel, detailsLabel;
    private Stage mainStage;
    @FXML protected void okKlick(ActionEvent event) {
        mainStage.close();
    }
    public void setStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    public void setText(String text) {
        messageLabel.setText(text);
    }
    public void setInformationText(String infotext) {
        detailsLabel.setText(infotext);
    }
}
