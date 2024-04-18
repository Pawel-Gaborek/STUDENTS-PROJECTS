package com.example.project_8;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;

public class gameController {

    @FXML private Label win;
    @FXML private Label status;
    @FXML ImageView cube1_a, cube1_b, cube2_a, cube2_b, cube2_c;
    private Image five = new Image("five.png");
    private Image four = new Image("four.png");
    private Image one = new Image("one.png");
    private Image six = new Image("six.png");
    private Image three = new Image("three.png");
    private Image two = new Image("two.png");
    private int currentWinningAmount = 100;
    private Timeline timer;
    private int checkInt=20;
    private info info, game = new info(new Stage());

    private boolean newGameReady=true;

    @FXML private void close() {
        Platform.exit();
    }

    @FXML private void about() {
        System.out.print("Asercja 0\n");
        info = new info(new Stage());
        info.setInformation("This game was implemented by Paweł Gaborek");
        info.showScene();
    }

    @FXML private void startThree() {
        if(newGameReady)
        {
            checkInt = 20;
            status.setText("The game costs 10 EU");
            newGameReady=false;
            for (int i = 20; i > 0; i--) {
                timer = new Timeline(new KeyFrame(Duration.millis(5000 / i), new TimerHandlerSecond()));
                timer.play();
            }
        }
    }

    @FXML private void startTwo() {
        if(newGameReady)
        {
            checkInt = 20;
            status.setText("The game costs 10 EU");
            newGameReady=false;
            for (int i = 20; i > 0; i--) {
                timer = new Timeline(new KeyFrame(Duration.millis(5000 / i), new TimerHandlerFirst()));
                timer.play();
            }
        }
    }

    @FXML private void newGame() {
        try{
            win.setText("100");
            currentWinningAmount = 100;
            cube1_a.setImage(five);
            cube1_b.setImage(four);
            cube2_a.setImage(one);
            cube2_b.setImage(six);
            cube2_c.setImage(three);
            status.setText("New game");
        }
        catch (Exception e)
        {
            System.out.print("Error"+e);
        }
    }

    @FXML private void gameInfo() {
        info = new info(new Stage());
        info.setInformation("This is a one-armed bandit game. The game display numbers " +
                "\nare collapsed into three labels. The player has a starting balance \n" +
                "of 100 EUR. Each game costs 10 EUR. If the player rolls two identical\n" +
                " dice, he wins EUR 20, and if he rolls three identical dice, he wins \n" +
                "EUR 100. The game ends when the player loses everything.");
        info.showScene();
    }

    private void checkFunctionFirst()
    {
        if(cube1_a.getImage() == cube1_b.getImage())
        {
            currentWinningAmount += 10;
            win.setText(Integer.toString(currentWinningAmount)+" EU");
            status.setText("Congratulations! You won!");
        }
        else{
            currentWinningAmount-=10;
            win.setText(Integer.toString(currentWinningAmount)+" EU");
            status.setText("Maybe next time");
            if(currentWinningAmount==0)
            {
                System.out.print("Asercja 1-l\n");
                game.setInformation("You have exhausted your money credit. Try again ;)");
                game.showScene();
                newGame();
                status.setText("New game");
            }
        }
    }


    class TimerHandlerFirst implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent arg0) {firstHashFunction();}
    }

    private void firstHashFunction()
    {
        int number1 = (int)(Math.random() * 7);
        int number2 = (int)(Math.random() * 7);

        if (number1==1){cube1_a.setImage(one);}
        else if (number1==2){cube1_a.setImage(two);}
        else if (number1==3){cube1_a.setImage(three);}
        else if (number1==4){cube1_a.setImage(four);}
        else if (number1==5){cube1_a.setImage(five);}
        else if (number1==6){cube1_a.setImage(six);}

        if (number2==1){cube1_b.setImage(one);}
        else if (number2==2){cube1_b.setImage(two);}
        else if (number2==3){cube1_b.setImage(three);}
        else if (number2==4){cube1_b.setImage(four);}
        else if (number2==5){cube1_b.setImage(five);}
        else if (number2==6){cube1_b.setImage(six);}

        checkInt--;

        if(checkInt==0)
        {
            checkFunctionFirst();
            newGameReady = true;
        }
    }

    private void checkFunctionSecond()
    {
        if((cube2_a.getImage() == cube2_b.getImage()) && (cube2_b.getImage() == cube2_c.getImage()))
        {
            currentWinningAmount += 90;
            win.setText(Integer.toString(currentWinningAmount)+" EU");
            status.setText("Congratulations! You won!");
        }
        else{
            currentWinningAmount -= 10;
            win.setText(Integer.toString(currentWinningAmount)+" EU");
            status.setText("Maybe next time");
            if(currentWinningAmount==0)
            {
                game.setInformation("You have exhausted your money credit. Try again ;)");
                game.showScene();
                newGame();
                status.setText("New game");
            }
        }
    }

    class TimerHandlerSecond implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent arg0) {secondHashFunction();}
    }

    private void secondHashFunction()
    {
        int number1 = (int)(Math.random() * 7);
        int number2 = (int)(Math.random() * 7);
        int number3 = (int)(Math.random() * 7);

        if (number1==1){cube2_a.setImage(one);}
        else if (number1==2){cube2_a.setImage(two);}
        else if (number1==3){cube2_a.setImage(three);}
        else if (number1==4){cube2_a.setImage(four);}
        else if (number1==5){cube2_a.setImage(five);}
        else if (number1==6){cube2_a.setImage(six);}

        if (number2==1){cube1_b.setImage(one);}
        else if (number2==2){cube2_b.setImage(two);}
        else if (number2==3){cube2_b.setImage(three);}
        else if (number2==4){cube2_b.setImage(four);}
        else if (number2==5){cube2_b.setImage(five);}
        else if (number2==6){cube2_b.setImage(six);}

        if (number3==1){cube2_c.setImage(one);}
        else if (number3==2){cube2_c.setImage(two);}
        else if (number3==3){cube2_c.setImage(three);}
        else if (number3==4){cube2_c.setImage(four);}
        else if (number3==5){cube2_c.setImage(five);}
        else if (number3==6){cube2_c.setImage(six);}

        checkInt--;

        if(checkInt==0)
        {
            checkFunctionSecond();
            newGameReady = true;
        }
    }
}