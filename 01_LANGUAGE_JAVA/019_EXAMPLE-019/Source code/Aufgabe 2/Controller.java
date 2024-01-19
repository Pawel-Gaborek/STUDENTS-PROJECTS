package com.example.calculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.stage.Stage;

public class Controller {
    @FXML protected void delete(ActionEvent actionEvent) {
        DialogInfoCalculator CalculatorInfoDialog = new DialogInfoCalculator(new Stage());
        CalculatorInfoDialog.setInformation("Question","Please decide", "Do you really want to delete the file?");
        CalculatorInfoDialog.dialogShow();
    }
}