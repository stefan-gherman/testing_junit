package com.codecool.readers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
*FilePartReader class that handles reading from text files
 */
public class FilePartReader {

    /**
    *File path as a string
     */
    private String filePath;

    /**
    *The line from which the reader should perform its action
    */
    private int fromLine;

    /**
   *The line at which the reader should stop.
    */
    private int toLine;

    public FilePartReader() {

    }

    /**
    <p>Public setter for the starting line </p>
    @param fromLine the line at which the reader should start
     @exception IllegalArgumentException when fromLine is greater than toLine
     */
    public void setFromLine(int fromLine) throws IllegalArgumentException {
        if (fromLine > this.toLine || fromLine < 1) {
            throw new IllegalArgumentException();
        }
        this.fromLine = fromLine;
    }

    /**
    <p>Public setter for the ending line </p>
    @param toLine the line at which the reader should stop
    @exception IllegalArgumentException when fromLine is greater than toLine
     */
    public void setToLine(int toLine) throws IllegalArgumentException {
        if (toLine < this.fromLine) {
            throw new IllegalArgumentException();
        }
        this.toLine = toLine;
    }

    /**
  <p>Public setter for the file path </p>
  @param filePath actual path of the file.
   */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
    <p> Getter for fromLine
    @return int fromLine
     */
    public int getFromLine() {
        return this.fromLine;
    }

    /**
  <p> Getter for fromLine
  @return int fromLine
   */
    public int getToLine() {
        return this.toLine;
    }

    /**
    <p> Getter for the filePath
    @return filePath String the file path of the file
     */
    public String getFilePath() {
        return this.filePath;
    }
    /**
    <p> The setup method assigns values to the class variables
    @param filePath the path of the file
    @param fromLine the starting line for the reader
    @param toLine the ending line for the reader
    @exception IllegalArgumentException when fromLine is smaller than 1 or greater tha toLIne
     */
    public void setup(String filePath, int fromLine, int toLine) throws IllegalArgumentException {

        if (fromLine > toLine || fromLine < 1) {
            throw new IllegalArgumentException();
        }

        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    /**
    <p> The read method reads all the contents from a file</p>
    @return returnString String the result as a string representation
    @exception IOException when file is not found
     */

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
        return returnString.stripTrailing();
    }

    /**
    <p>This method reads only the line between fromLine to toLine (both included)</p>
    @return returnString String the result as a string representation
    @exception  IOException on file not found
    @exception IndexOutOfBoundsException  when fromLine is greater than the total number of lines the file has
     */

    public String readLines() throws IOException, IndexOutOfBoundsException {

        List<String> returnFromRead;
        returnFromRead = Arrays.asList(this.read().split("\\r?\\n"));
        int fileLines = returnFromRead.size();
        StringBuilder returnString = new StringBuilder();

        if (this.fromLine > fileLines) {
            System.out.println("The Starting Line (get it?) is out of bounds");
            throw new IndexOutOfBoundsException();
        } else if (this.toLine > fileLines) {
            for (int i = fromLine - 1; i < fileLines; i++) {
                returnString.append(returnFromRead.get(i) + "\n");
            }
        } else {
            for (int i = this.fromLine - 1; i < this.toLine; i++) {
                returnString.append(returnFromRead.get(i) + "\n");
            }
        }
        return returnString.toString().stripTrailing();
    }
}
