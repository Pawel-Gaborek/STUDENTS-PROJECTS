package com.example.project5_v2;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Vector;

public class Project5WordsEditFile {
    private Vector<String> words;
    private String fileLocate = "words.dat";
    boolean fileIsLoaded = false;
    String[] arrayWhenFileNotLoaded = { "zur", "Unterstützung", "der", "Anwendung", "habe", "ich", "Anwendungsdateien", "und", "Controller", "Dateien", "erstellen"};

    public Project5WordsEditFile() {
        words = new Vector<>();
        File File = new File(getClass().getResource(fileLocate).getFile());

        try {
            if (!File.exists()) {
                words = new Vector<>(Arrays.asList(arrayWhenFileNotLoaded));
                File.createNewFile();
            }
            else
            {
                fileIsLoaded=true;
                openData();
            }
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    private void openData() {
        int indexNumber;
        try (RandomAccessFile file = new RandomAccessFile(getClass().getResource(fileLocate).getFile(),"r")){
            indexNumber=file.readInt();
            for (int index = 1; index < indexNumber; index++) {
                words.add(file.readUTF());
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
    public void addWord(String word)
    {
        words.add(word);
        if(fileIsLoaded)
        {
            this.saveFile();
        }
    }
    private void saveFile() {
        try (RandomAccessFile file = new RandomAccessFile(getClass().getResource(fileLocate).getFile(),"rw")){
            file.writeInt(words.size()+1);
            for (int index = 1; index < words.size()+1; index++) {
                file.writeUTF(words.get(index-1));
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public Vector<String> getWords() {return words;}

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
            if(fileIsLoaded)
            {
                this.saveFile();
            }
        }
        catch(Exception e)
        {
            System.out.print("Error: " + e);
        }
    }
}
