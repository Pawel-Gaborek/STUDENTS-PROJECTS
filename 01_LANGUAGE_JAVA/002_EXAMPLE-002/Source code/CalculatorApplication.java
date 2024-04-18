package com.example.project_7;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class CalculatorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(CalculatorApplication.class.getResource("calculator-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Calculator");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException e)
        {
            inromationError("Error","Error input / output",String.valueOf(e));
        }
        catch (Exception e)
        {
            inromationError("Error","The system encountered an error",String.valueOf(e));
        }
    }
    public static void main(String[] args) {
        launch();
    }

    private void inromationError(String title, String text, String infotext) {
        DialogInfoCalculator CalculatorInfoDialog = new DialogInfoCalculator(new Stage());
        CalculatorInfoDialog.setInformation(title,text, infotext);
        CalculatorInfoDialog.dialogShow();
    }
}