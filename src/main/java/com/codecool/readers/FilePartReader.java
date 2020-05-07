package com.codecool.readers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//

public class FilePartReader {

    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader() {

    }

    public void setFromLine (int fromLine) throws IllegalArgumentException {
        if(fromLine > this.toLine) {
            throw new IllegalArgumentException();
        }
        this.fromLine = fromLine;
    }

    public void setToLine (int toLine) throws IllegalArgumentException{
        if(toLine < this.fromLine) {
            throw new IllegalArgumentException();
        }
        this.toLine = toLine;
    }

    public int getFromLine() {
        return this.fromLine;
    }

    public int getToLine() {
        return this.toLine;
    }


    public void setup(String filePath, int fromLine, int toLine) throws IllegalArgumentException {

        if (fromLine > toLine || fromLine < 1) {
            throw new IllegalArgumentException();
        }

        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        List<String> fileContents = new ArrayList<>();
        String returnString = "";

        try {
            Path filePathFromString = Paths.get(this.filePath);
            Files.lines(filePathFromString).forEach(fileContents::add);
        } catch (Exception e) {
            throw new IOException();
        }

        for (String line : fileContents) {
            returnString = returnString.concat(line + '\n');
        }
        return returnString;
    }

    public String readLines() throws IOException, IndexOutOfBoundsException {

        List<String> returnFromRead;
        returnFromRead = Arrays.asList(this.read().split("\\r?\\n"));
        int fileLines = returnFromRead.size();
        StringBuilder returnString = new StringBuilder();

        if(this.fromLine > fileLines){
            System.out.println("The Starting Line (get it?) is out of bounds");
            throw new IndexOutOfBoundsException();
        } else if (this.toLine > fileLines) {
            for(int i = fromLine - 1; i < fileLines; i++ ) {
                returnString.append(returnFromRead.get(i) + "\n");
            }
        } else {
            for(int i = this.fromLine - 1; i < this.toLine; i++ ) {
                returnString.append(returnFromRead.get(i) + "\n");
            }
        }
        return returnString.toString();
    }
}
