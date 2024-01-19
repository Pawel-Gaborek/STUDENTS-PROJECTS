package com.example.aufgabe_22;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DialogInfoController {
    @FXML private Label labelPointsComputer, labelPointsUser, labelWinner;
    @FXML private Stage mainStage;
    @FXML protected void ok(ActionEvent actionEvent) {
        mainStage.close();
        Platform.exit();
    }
    private Timeline timerClose;
    public boolean close()
    {
        return mainStage.isShowing();
    }
    public void setStage(Stage mainStage) {
        this.mainStage = mainStage;
    }
    public void setInformation(String userPoints, String computerPoints, String winner) {
        try{
            labelPointsComputer.setText("Computer have a "+computerPoints+" points.");
            labelPointsUser.setText("Computer have a "+userPoints+" ponts.");
            labelWinner.setText(winner+" won the game.");
        }
        catch (Exception e)
        {
            System.out.print("error " + e);
        }
    }
}
