package com.example.project_7;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javax.swing.*;
import java.util.Deque;
import java.util.ArrayDeque;
import javafx.stage.Stage;

public class CalculatorController {
    String copyPaste;
    Deque<String> stackAllValues = new ArrayDeque<String>();
    String arithmeticOperator = "";
    double number1=0.0, number2=0.0;
    private JLabel result = new JLabel();
    private boolean reset = false;
    private Double calculatedValue = 0.0;
    @FXML private Label labelResult = new Label();
    @FXML private Label mathematicalAction = new Label();

    @FXML private void buttonOne() {
        try
        {
            if(labelResult.getText()=="0")
            {
                labelResult.setText("1");
            }
            else
            {
                labelResult.setText(labelResult.getText()+"1");
            }
        }
        catch (Exception e)
        {
            inromationError("Error","The system encountered an error",String.valueOf(e));
        }
    }
    @FXML private void buttonTwo() {
        try {
            if (labelResult.getText() == "0")
            {
                labelResult.setText("2");
            } else {
                labelResult.setText(labelResult.getText() + "2");
            }
        }
        catch (Exception e)
        {
            inromationError("Error","The system encountered an error",String.valueOf(e));
        }
    }
    @FXML private void buttonThree() {
        try {
            if(labelResult.getText()=="0")
            {
                labelResult.setText("3");
            }
            else
            {
                labelResult.setText(labelResult.getText()+"3");
            }
        }
        catch (Exception e)
        {
            inromationError("Error","The system encountered an error",String.valueOf(e));
        }
    }
    @FXML private void buttonFour() {
        try {
            if(labelResult.getText()=="0")
            {
                labelResult.setText("4");
            }
            else{
                labelResult.setText(labelResult.getText()+"4");
            }
        }
        catch (Exception e)
        {
            inromationError("Error","The system encountered an error",String.valueOf(e));
        }
    }
    @FXML private void buttonFive() {
        try {
            if(labelResult.getText()=="0")
            {
                labelResult.setText("5");
            }
            else
            {
                labelResult.setText(labelResult.getText()+"5");
            }
        }
        catch (Exception e)
        {
            inromationError("Error","The system encountered an error",String.valueOf(e));
        }
    }
    @FXML private void buttonSix()
    {
        try
        {
            if(labelResult.getText()=="0")
            {
                labelResult.setText("6");
            }
            else
            {
                labelResult.setText(labelResult.getText()+"6");
            }
        }
        catch (Exception e)
        {
            inromationError("Error","The system encountered an error",String.valueOf(e));
        }
    }
    @FXML private void buttonSeven() {
        try {
            if(labelResult.getText()=="0")
            {
                labelResult.setText("7");
            }
            else{
                labelResult.setText(labelResult.getText()+"7");
            }
        }
        catch (Exception e)
        {
            inromationError("Error","The system encountered an error",String.valueOf(e));
        }
    }
    @FXML private void buttonEight() {
        try {
            if(labelResult.getText()=="0")
            {
                labelResult.setText("8");
            }
            else{
                labelResult.setText(labelResult.getText()+"8");
            }
        }
        catch (Exception e)
        {
            inromationError("Error","The system encountered an error",String.valueOf(e));
        }
    }
    @FXML private void buttonNine() {
        try {
            if(labelResult.getText()=="0")
            {
                labelResult.setText("9");
            }
            else{
                labelResult.setText(labelResult.getText()+"9");
            }
        }
        catch (Exception e)
        {
            inromationError("Error","The system encountered an error",String.valueOf(e));
        }
    }
    @FXML private void buttonZero() {
        try {
            if(labelResult.getText()!="0")
            {
                labelResult.setText(labelResult.getText()+"0");
            }
        }
        catch (Exception e)
        {
            inromationError("Error","The system encountered an error",String.valueOf(e));
        }
    }
    @FXML private void buttonComma() {
        try {
            if (!labelResult.getText().contains("."))
            {
                if (labelResult.getText().isEmpty())
                {
                    labelResult.setText(labelResult.getText()+"0.");
                }
                else
                {
                    labelResult.setText(labelResult.getText()+".");
                }
            }
        }
        catch (Exception e)
        {
            inromationError("Error","The system encountered an error",String.valueOf(e));
        }
    }
    @FXML private void reset() {
        try{
            labelResult.setText("0");
            mathematicalAction.setText("");
            stackAllValues.clear();
        }
        catch (Exception e)
        {
            inromationError("Error","The system encountered an error",String.valueOf(e));
        }
    }
    @FXML private void changePlusMinus() {
        try{
            if(Double.parseDouble(labelResult.getText())<0)
            {
                labelResult.setText(labelResult.getText().substring(1));
            }
            else
            {
                labelResult.setText("-"+labelResult.getText());
            }
        }
        catch (Exception e)
        {
            inromationError("Error","The system encountered an error",String.valueOf(e));
        }
    }

    //===========================================
    //===========================================
    //===========================================
    //===========================================
    //===========================================

    //calculatedValue
    @FXML private void percent() {
        try
        {
            arithmeticOperator = "%";
            if(reset==true)
            {
                number1 = Double.parseDouble(labelResult.getText());
                reset=false;
            }
            mathematicalAction.setText("percent");
            labelResult.setText("0");
            result();
        }
        catch (Exception e)
        {
            inromationError("Error","The system encountered an error",String.valueOf(e));
        }
    }
    @FXML private void division() {
        try{
            arithmeticOperator = "/";
            if(reset==true)
            {
                number1 = Double.parseDouble(labelResult.getText());
                reset=false;
            }
            mathematicalAction.setText("division");
            labelResult.setText("0");
        }
        catch (Exception e)
        {
            inromationError("Error","The system encountered an error",String.valueOf(e));
        }
    }

    @FXML private void multiplication() {
        try{
            arithmeticOperator = "*";
            if(reset==true)
            {
                number1 = Double.parseDouble(labelResult.getText());
                reset=false;
            }
            mathematicalAction.setText("multiplication");
            labelResult.setText("0");
        }
        catch (Exception e)
        {
            inromationError("Error","The system encountered an error",String.valueOf(e));
        }
    }

    @FXML private void subtraction() {
        try{
            arithmeticOperator = "-";
            if(reset==true)
            {
                number1 = Double.parseDouble(labelResult.getText());
                reset=false;
            }
            mathematicalAction.setText("subtraction");
            labelResult.setText("0");
        }
        catch (Exception e)
        {
            inromationError("Error","The system encountered an error",String.valueOf(e));
        }
    }

    @FXML private void addition() {
        try{
            arithmeticOperator = "+";
            if(reset==true)
            {
                number1 = Double.parseDouble(labelResult.getText());
                reset=false;
            }
            mathematicalAction.setText("addition");
            labelResult.setText("0");
        }
        catch (Exception e)
        {
            inromationError("Error","The system encountered an error",String.valueOf(e));
        }
    }


    @FXML private void result() {
        try{
            mathematicalAction.setText("result");
            number2 = Double.parseDouble(labelResult.getText());
            if(arithmeticOperator=="+")
            {
                calculatedValue = number1 + number2;
            }
            else if(arithmeticOperator=="-")
            {
                calculatedValue = number1 - number2;
            }
            else if(arithmeticOperator=="*")
            {
                calculatedValue = number1 * number2;
            }
            else if(arithmeticOperator=="/")
            {
                calculatedValue = number1 / number2;
            }
            else if(arithmeticOperator=="%")
            {
                calculatedValue = calculatedValue * 0.01;
            }
            stackAllValues.addFirst(String.valueOf(calculatedValue));
            stackAllValues.addFirst(String.valueOf(number2));
            stackAllValues.addFirst(String.valueOf(number1));
            labelResult.setText(String.valueOf(calculatedValue));
            reset=true;
        }
        catch (ArithmeticException e)
        {
            labelResult.setText("division not null");
            inromationError("Error","The system division not null",String.valueOf(e));
        }
        catch (Exception e)
        {
            labelResult.setText("error");
            inromationError("Error","The system encountered an error",String.valueOf(e));
        }
    }

    @FXML protected void close()
    {
        Platform.exit();
    }
    @FXML protected void delete() {
        try {
            labelResult.setText(labelResult.getText().substring(0,labelResult.getText().length()-1));
        }
        catch (Exception e)
        {
            inromationError("Error","The system encountered an error",String.valueOf(e));
        }
    }
    @FXML protected void paste() {
        try {
            labelResult.setText(copyPaste);
        }
        catch (Exception e)
        {
            inromationError("Error","The system encountered an error",String.valueOf(e));
        }
    }
    @FXML protected void copy() {
        try {
            copyPaste = labelResult.getText();
        }
        catch (Exception e)
        {
            inromationError("Error","The system encountered an error",String.valueOf(e));
        }
    }
    @FXML protected void revert() {
        try {
            if(!stackAllValues.isEmpty())
            {
                labelResult.setText(stackAllValues.pop());
            }
        }
        catch (Exception e)
        {
            inromationError("Error","The system encountered an error",String.valueOf(e));
        }
    }
    @FXML protected void about() {
        DialogInfoCalculator CalculatorInfoDialog = new DialogInfoCalculator(new Stage());
        CalculatorInfoDialog.setInformation("Information","Aplication development Pawel Gaborek", "Aplication development Pawel Gaborek");
        CalculatorInfoDialog.dialogShow();
    }


    private void inromationError(String title, String text, String infotext) {
        DialogInfoCalculator CalculatorInfoDialog = new DialogInfoCalculator(new Stage());
        CalculatorInfoDialog.setInformation(title,text, infotext);
        CalculatorInfoDialog.dialogShow();
    }
}