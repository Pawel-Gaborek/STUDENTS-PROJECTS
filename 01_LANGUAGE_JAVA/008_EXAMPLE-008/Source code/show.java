package com.example.aufgabe4;

import javafx.animation.ScaleTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
public class show extends Stage {
    private ScaleTransition zoomRectangle, zoomCricle;
    private Rectangle rectangle;
    private Circle circle;
    public void createFigure(int widthCircleInt, int widthRectangleInt, Pane mainPane)
    {
        try {
            rectangle = new Rectangle(200 - widthRectangleInt, 200 - widthRectangleInt);
            rectangle.setStroke(Color.RED);
            rectangle.setStrokeWidth(widthRectangleInt);
            rectangle.setFill(Color.TRANSPARENT);
            circle = new Circle(100 - widthCircleInt/2);
            circle.setStroke(Color.BLUEVIOLET);
            circle.setStrokeWidth(widthCircleInt);
            circle.setFill(Color.TRANSPARENT);
            mainPane.getChildren().add(rectangle);
            mainPane.getChildren().add(circle);
        }
        catch (Exception e)
        {
            System.out.print("error "+e);
        }
    }
    public void speed(long speed)
    {
        try {
            zoomRectangle.setDuration(Duration.millis(speed));
            zoomCricle.setDuration(Duration.millis(speed));
        }
        catch (Exception e)
        {
            System.out.print("error "+e);
        }
    }
    public void widthCircle(int width)
    {
        try {
            this.circle.setRadius(100 - width/2);
            this.circle.setStrokeWidth(width);
        }
        catch (Exception e)
        {
            System.out.print("error "+e);
        }
    }
    public void widthRectangle(int width)
    {
        try {
            this.rectangle.setHeight(200 - width);
            this.rectangle.setWidth(200 - width);
            this.rectangle.setStrokeWidth(width);
        }
        catch (Exception e)
        {
            System.out.print("error "+e);
        }
    }
    public void animation(long speed)
    {
        try
        {
            zoomRectangle = new ScaleTransition(Duration.millis(speed), rectangle);
            zoomRectangle.setToY(0.01);
            zoomRectangle.setFromY(1);
            zoomRectangle.setToX(0.01);
            zoomRectangle.setFromX(1);
            zoomRectangle.setCycleCount(10);
            zoomRectangle.setAutoReverse(true);
            zoomCricle = new ScaleTransition(Duration.millis(speed), circle);
            zoomCricle.setFromY(0.01);
            zoomCricle.setToY(1);
            zoomCricle.setFromX(0.01);
            zoomCricle.setToX(1);
            zoomCricle.setCycleCount(10);
            zoomCricle.setAutoReverse(true);
        }
        catch (Exception e)
        {
            System.out.print("error "+e);
        }
    }
    public void play()
    {
        try
        {
            zoomRectangle.playFromStart();
            zoomCricle.playFromStart();
        }
        catch(Exception e)
        {
            System.out.print("error "+e);
        }
    }
    public void stop()
    {
        try
        {
            zoomRectangle.stop();
            zoomCricle.stop();
        }
        catch(Exception e)
        {
            System.out.print("error "+e);
        }
    }

    public void pause() {
        try
        {
            zoomRectangle.pause();
            zoomCricle.pause();
        }
        catch (Exception e)
        {
            System.out.print("error "+e);
        }
    }

    public void run() {
        try
        {
            zoomRectangle.play();
            zoomCricle.play();
        }
        catch (Exception e)
        {
            System.out.print("error "+e);
        }
    }

    public void repeat(int repeatCycle) {
        try
        {
            zoomRectangle.setCycleCount(repeatCycle);
            zoomCricle.setCycleCount(repeatCycle);
        }
        catch (Exception e)
        {
            System.out.print("error "+e);
        }
    }
}
