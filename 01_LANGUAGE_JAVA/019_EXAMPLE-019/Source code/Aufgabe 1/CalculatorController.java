package com.example.calculator;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javax.swing.*;
import java.util.Deque;
import java.util.ArrayDeque;

import javafx.stage.Stage;

public class CalculatorController {
    String copyPaste;
    Deque<String> stack = new ArrayDeque<String>();
    Deque<String> stackAllValues = new ArrayDeque<String>();
    private JLabel result = new JLabel();
    @FXML private Label labelResult = new Label();
    @FXML private Label mathematicalAction = new Label();

    @FXML private void buttonOne() {
        if(labelResult.getText()=="0")
        {
            labelResult.setText("1");
        }
        else
        {
            labelResult.setText(labelResult.getText()+"1");
        };
    }
    @FXML private void buttonTwo() {
        if (labelResult.getText() == "0") {
            labelResult.setText("2");
        } else {
            labelResult.setText(labelResult.getText() + "2");
        }
    }
    @FXML private void buttonThree() {
        if(labelResult.getText()=="0")
        {
            labelResult.setText("3");
        }
        else {
        labelResult.setText(labelResult.getText()+"3");};}
    @FXML private void buttonFour() {
        if(labelResult.getText()=="0")
        {
            labelResult.setText("4");
        }
        else{
        labelResult.setText(labelResult.getText()+"4");};}
    @FXML private void buttonFive() {
        if(labelResult.getText()=="0")
        {
            labelResult.setText("5");
        }
        else{labelResult.setText(labelResult.getText()+"5");};
    }
    @FXML private void buttonSix() {  if(labelResult.getText()=="0")
    {
        labelResult.setText("6");
    }else {labelResult.setText(labelResult.getText()+"6");};}
    @FXML private void buttonSeven() {
        if(labelResult.getText()=="0")
        {
            labelResult.setText("7");
        }
        else{
            labelResult.setText(labelResult.getText()+"7");
        }};
    @FXML private void buttonEight() {
        if(labelResult.getText()=="0")
        {
            labelResult.setText("8");
        }
        else{
            labelResult.setText(labelResult.getText()+"8");
        }};
    @FXML private void buttonNine() {
        if(labelResult.getText()=="0")
        {
            labelResult.setText("9");
        }
        else{
            labelResult.setText(labelResult.getText()+"9");
        }};
    @FXML private void buttonZero() {
        if(labelResult.getText()!="0")
        {
            labelResult.setText(labelResult.getText()+"0");};
        }
    @FXML private void buttonComma() {
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
    };
    @FXML private void reset() {
        try{
            labelResult.setText("0");
            stack.clear();
            stackAllValues.clear();
        }
        catch (Exception e)
        {
            System.out.print(e);
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
            System.out.print(e);
        }
    }
    public void percent(ActionEvent actionEvent) {
        try
        {
            stack.addFirst("%");
            stack.addLast(labelResult.getText());
            labelResult.setText("0");
            mathematicalAction.setText("percent");
            result();
        }
        catch (Exception e)
        {
            System.out.print(e);
        }
    }
    public void division(ActionEvent actionEvent) {
        try{
            stack.addFirst("/");
            stack.addLast(labelResult.getText());
            labelResult.setText("0");
            mathematicalAction.setText("division");
        }
        catch (Exception e)
        {
            System.out.print(e);
        }
    }

    public void multiplication(ActionEvent actionEvent) {
        try{
            stack.addFirst("*");
            stack.addLast(labelResult.getText());
            labelResult.setText("0");
            mathematicalAction.setText("multiplication");
        }
        catch (Exception e)
        {
            System.out.print(e);
        }
    }

    public void subtraction(ActionEvent actionEvent) {
        try{
            stack.addFirst("-");
            stack.addLast(labelResult.getText());
            labelResult.setText("0");
            mathematicalAction.setText("subtraction");
        }
        catch (Exception e)
        {
            System.out.print(e);
        }
    }

    public void addition(ActionEvent actionEvent) {
        try{
            stack.addFirst("+");
            stack.addLast(labelResult.getText());
            labelResult.setText("0");
            mathematicalAction.setText("addition");
        }
        catch (Exception e)
        {
            System.out.print(e);
        }
    }

    public void result() {
        try{
            stack.addLast(labelResult.getText());
            mathematicalAction.setText("result");
            if(stack.peek()=="+")
            {
                stack.pop();
                labelResult.setText(String.valueOf((Double.parseDouble(stack.pop())
                        + Double.parseDouble(stack.pop()))));
            }
            if(stack.peek()=="-")
            {
                stack.pop();
                labelResult.setText(String.valueOf((Double.parseDouble(stack.pop())
                        - Double.parseDouble(stack.pop()))));
            }
            if(stack.peek()=="*")
            {
                stack.pop();
                labelResult.setText(String.valueOf((Double.parseDouble(stack.pop())
                        * Double.parseDouble(stack.pop()))));
            }
            if(stack.peek()=="/")
            {
                stack.pop();
                labelResult.setText(String.valueOf((Double.parseDouble(stack.pop())
                        / Double.parseDouble(stack.pop()))));
            }
            if(stack.peek()=="%")
            {
                stack.pop();
                labelResult.setText(String.valueOf((Double.parseDouble(stack.pop()) * 0.01)));
                stack.clear();
            }
            if(!stack.isEmpty())
            {
                stack.clear();
                stack.addLast(labelResult.getText());
            }
            stackAllValues.add(labelResult.getText());
        }
        catch (ArithmeticException e)
        {
            labelResult.setText("division not null");
            System.out.print(e);
        }
        catch (Exception e)
        {
            labelResult.setText("error");
            System.out.print(e);
        }
    }
    @FXML protected void close()
    {
        Platform.exit();
    }
    @FXML protected void delete() {
        labelResult.setText(labelResult.getText().substring(0,labelResult.getText().length()-1));
    }
    @FXML protected void paste() {
        labelResult.setText(copyPaste);
    }
    @FXML protected void copy(ActionEvent actionEvent) {
        copyPaste = labelResult.getText();
    }
    @FXML protected void revert(ActionEvent actionEvent) {
        labelResult.setText(stackAllValues.pop());
    }
    @FXML protected void about(ActionEvent actionEvent) {
        DialogInfoCalculator CalculatorInfoDialog = new DialogInfoCalculator(new Stage());
        CalculatorInfoDialog.setInformation("Information","Aplication development Pawel Gaborek", "Aplication development Pawel Gaborek");
        CalculatorInfoDialog.dialogShow();
    }
}