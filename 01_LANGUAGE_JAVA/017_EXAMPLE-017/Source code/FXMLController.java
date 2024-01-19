package com.example.aufgabe4;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class FXMLController extends Stage {
    @FXML public ChoiceBox repeat = new ChoiceBox();
    @FXML private ChoiceBox speed = new ChoiceBox();
    @FXML private ChoiceBox widthCircle = new ChoiceBox();
    @FXML private ChoiceBox widthRectangle = new ChoiceBox();
    @FXML private Button pauseButton = new Button();
    private long speedLong;
    private int widthCircleInt, widthRectangleInt, repeatCycle;
    private show show;
    private Stage mainStage;
    private Pane mainPane;
    @FXML protected void close(ActionEvent event)
    {
        Platform.exit();
    }
    @FXML void initialize()
    {
        show = new show();
        setDefaultValue();
        start();
    }
    @FXML void setDefaultValue()
    {
        this.pauseButton.setText("Pause");
        this.speed.getItems().setAll("1","2","3","4","5","6","7","8","9","10","11","12","13","14");
        this.widthCircle.getItems().setAll("5","10","15","20","25","30","35","40");
        this.widthRectangle.getItems().setAll("5","10","15","20","25","30","35","40");
        this.repeat.getItems().setAll("1","2","3","4","5","6","7","8","9","10");
        this.speed.setValue("2");
        this.widthCircle.setValue("20");
        this.widthRectangle.setValue("20");
        this.repeat.setValue("10");
    }
    @FXML protected void speed()
    {
        speedLong=10000/Long.parseLong(speed.getValue().toString());
    }
    @FXML protected void widthCircle()
    {
        this.widthCircleInt=Integer.parseInt(widthCircle.getValue().toString());
    }
    @FXML protected void widthRectangle()
    {
        this.widthRectangleInt = Integer.parseInt(widthRectangle.getValue().toString());
    }
    @FXML protected void repeat() {
        this.repeatCycle = Integer.parseInt(repeat.getValue().toString());
    }
    public void start()
    {
        show.createFigure(this.widthCircleInt, this.widthRectangleInt, this.mainPane);
        show.animation(this.speedLong);
        show.play();
    }

    public void run()
    {
        this.show.widthRectangle(this.widthRectangleInt);
        this.show.widthCircle(this.widthCircleInt);
        this.show.speed(this.speedLong);
        this.show.repeat(this.repeatCycle);
        show.play();
    }
    public void stop()
    {
        this.show.stop();
    }
    public void pause()
    {
        if(this.pauseButton.getText()=="Pause")
        {
            this.pauseButton.setText("Run");
            this.show.pause();
        }
        else {
            this.pauseButton.setText("Pause");
            this.show.run();
        }
    }
    public void setStage(Stage mainStage)
    {
        this.mainStage = mainStage;
    }
    public void setPane(Pane pane)
    {
        this.mainPane = pane;
    }
}
