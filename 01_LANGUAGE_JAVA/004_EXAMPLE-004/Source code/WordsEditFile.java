package com.example.aufgabe_111;

import javafx.scene.control.ComboBox;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Vector;
public class WordsEditFile {
    private Vector<String> words;
    private ComboBox<String>  ComboBox;
    private String[] table;
    private String fileLocate = "words.dat";
    public WordsEditFile()
    {
        try {
            words = new Vector<>();
            ComboBox = new ComboBox();
            File File = new File(getClass().getResource(fileLocate).getFile());
            if (File.exists()) {
                openData();
            }
        }
        catch (Exception e) {
            System.out.println("error: " + e);
        }
    }
    public void openData() {
        int indexNumber;
        try (RandomAccessFile file = new RandomAccessFile(getClass().getResource(fileLocate).getFile(),"r")){
            indexNumber=file.readInt();
            for (int index = 1; index < indexNumber; index++) {
                words.add(file.readUTF());
            }
        }
        catch (IOException e) {
            System.out.println("error: " + e);
        }
    }
    public String addWord(String word)
    {
        words.add(word);
        this.saveFile();
        return words.toString();
    }
    public void saveFile() {
        try (RandomAccessFile file = new RandomAccessFile(getClass().getResource(fileLocate).getFile(),"rw")){
            file.writeInt(words.size()+1);
            for (int index = 1; index < words.size()+1; index++) {
                file.writeUTF(words.get(index-1));
            }
        }
        catch (IOException e) {
            System.out.println("error: " + e);
        }
    }
    public String[] setComboBox() {
        table = null;
        table = new String[words.size()];
        try {
            for (int index = 1; index < words.size(); index++) {
                ComboBox.getItems().add(words.get(index));
                table[index]=words.get(index).toString();
            }
            return table;
        }
        catch (Exception e) {
            System.out.println("error: " + e);
        }
        return table;
    }
    public String showWords() {
        return words.toString();
    }

    public void deleteWord(String word) {
        try
        {
            for(int index=0 ; index<words.size() ; index++)
            {
                if(words.get(index)==word)
                {
                    words.remove(index);
                }
            }
        }
        catch(Exception e)
        {
            System.out.print("error: " + e);
        }
    }
    public String[] returnWordsForNewGame2()
    {
        String[] table;
        this.openData();
        if(!words.isEmpty())
        {
            table = new String[words.size()];
            for (int index = 0 ; index<words.size() ; index++)
            {
                 table[index]=words.get(index);
            }
            return table;
        }
        return null;
    }
}
