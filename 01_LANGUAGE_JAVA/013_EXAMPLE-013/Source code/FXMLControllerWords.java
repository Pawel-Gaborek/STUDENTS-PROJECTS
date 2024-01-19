package com.example.aufgabe_111;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLControllerWords {
    @FXML private Button deleteWord;
    @FXML private ComboBox<String> choiceWord;
    @FXML private TextField labelWord;
    @FXML private TextArea textWords;
    private Stage stage;
    private WordsEditFile wordsEditFile;
    @FXML void initialize() {
        wordsEditFile = new WordsEditFile();
        textWords.setEditable(false);
        textWords.setWrapText(true);
        setComboBox();
        this.showWords();
    }
    @FXML private void close()
    {
        stage.close();
    }
    @FXML private void addWord(ActionEvent actionEvent) {
        if(!labelWord.getText().isEmpty()) {
            textWords.setText(wordsEditFile.addWord(labelWord.getText()));
            labelWord.clear();
        }
    }
    @FXML private void deleteWord(ActionEvent actionEvent) {
        wordsEditFile.deleteWord(this.choiceWord.getValue());
        wordsEditFile.saveFile();
        this.setComboBox();
        this.showWords();
    }
    public void setStage(Stage meineStage) {
        this.stage = meineStage;
        this.stage.setResizable(false);
    }
    private void setComboBox() {
        this.choiceWord.getItems().setAll(wordsEditFile.setComboBox());
    }

    private void showWords()
    {
        textWords.setText(wordsEditFile.showWords());
    }

    public String[] getWords()
    {
        return wordsEditFile.setComboBox();
    }
}
