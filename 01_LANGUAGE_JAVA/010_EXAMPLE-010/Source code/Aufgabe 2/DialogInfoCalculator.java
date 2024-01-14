package com.example.calculator;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DialogInfoCalculator extends Stage{
    private DialogInfoControllerInfo mainController = new DialogInfoControllerInfo();
    public DialogInfoCalculator(Stage stage) {
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
        }
        catch (IOException e) {
            System.out.println("error "+e);
        }
    }
    public void setInformation(String title, String text, String infotext) {
        try{
            setTitle(title);
            mainController.setText(text);
            mainController.setInformationText(infotext);
        }
       catch (Exception e)
       {
           System.out.print("error" + e);
       }
    }
    public void dialogShow() {
        showAndWait();
    }
}
