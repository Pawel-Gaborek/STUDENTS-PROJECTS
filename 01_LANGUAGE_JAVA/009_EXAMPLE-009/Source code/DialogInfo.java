package com.example.aufgabe_22;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.lang.String;


//f¸r die Klassen Arrays und Collections

import javafx.animation.KeyFrame;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class DialogInfo extends Stage{
    private DialogInfoController mainController = new DialogInfoController();
    private Timeline timerClose;
    public DialogInfo(Stage stage) {
        super();
        initOwner(stage);
        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("InfoDialog.fxml"));
        try {
            Parent root = mainLoader.load();
            mainController = mainLoader.getController();
            Scene mainScene = new Scene(root, 400, 150);
            setScene(mainScene);
            initModality(Modality.WINDOW_MODAL);
            initStyle(StageStyle.UTILITY);
            mainController.setStage(this);
            timerClose = new Timeline(new KeyFrame(Duration.millis(10000),new TimerHandler()));
            timerClose.play();
        }
        catch (IOException e) {
            System.out.println("error "+e);
        }
    }

    public void setInformation(String userPoints, String computerPoints, String winner) {
        try{
            mainController.setInformation(userPoints,computerPoints,winner);
        }
       catch (Exception e)
       {
           System.out.print("error " + e);
       }
    }

    void showScene()
    {
        try {
            showAndWait();
        }
        catch (Exception e)
        {
            System.out.print("error "+e);
        }
    }

    class TimerHandler implements EventHandler<ActionEvent> {
        @Override
        //die Methode ruft die Methode karteSchliessen() auf
        public void handle(ActionEvent arg0) {
            Platform.exit();
        }
    }
}
