package com.example.project5_v2;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Vector;

public class Project5HighscoreList {
    private Vector<String> elements;
    private String fileLocate = "score.dat";
    boolean fileIsLoaded = false;
    String[] arrayWhenFileNotLoaded = { "Sebi 15 points", "Wojtek  20 points", "Piotr 30 points"};
    public Project5HighscoreList()
    {
        elements = new Vector<>();
        File File = new File(getClass().getResource(fileLocate).getFile());

        try {
            if (!File.exists()) {
                elements = new Vector<>(Arrays.asList(arrayWhenFileNotLoaded));
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
                elements.add(file.readUTF());
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
    public void addResult(String element)
    {
        elements.add(element);
        if(fileIsLoaded)
        {
            this.saveFile();
        }
    }
    private void saveFile() {
        try (RandomAccessFile file = new RandomAccessFile(getClass().getResource(fileLocate).getFile(),"rw")){
            file.writeInt(elements.size()+1);
            for (int index = 1; index < elements.size()+1; index++) {
                file.writeUTF(elements.get(index-1));
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public Vector<String> get() {return elements;}
}
