package com.example.project_8;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import java.io.IOException;

public class info extends Stage{
    private infoController mainController = new infoController();
    private Timeline timerClose;
    public info(Stage stage) {
        super();
        initOwner(stage);
        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("info-view.fxml"));
        try {
            Parent root = mainLoader.load();
            mainController = mainLoader.getController();
            Scene mainScene = new Scene(root, 400, 300);
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

    public void setInformation(String text) {
        try{
            mainController.setInformation(text);
        }
       catch (Exception e)
       {
           System.out.print("error " + e);
       }
    }

    void showScene()
    {
        try {
            System.out.print("Asercja 1-m\n");
            this.showAndWait();
        }
        catch (Exception e)
        {
            System.out.print("error "+e);
        }
    }

    class TimerHandler implements EventHandler<ActionEvent> {
        @Override public void handle(ActionEvent arg0) {
            mainController.ok();
        }
    }
}
