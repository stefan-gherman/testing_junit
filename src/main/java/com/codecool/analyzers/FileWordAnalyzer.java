package com.codecool.analyzers;

import com.codecool.readers.FilePartReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
<p>This class deals with the analysis of words
 */
public class FileWordAnalyzer {
    /*
    <p>A FilePartReader is used to read the files upon which the analysis will be performed</p>
     */
    private FilePartReader reader;

    /*
    <p>Public constructor for the class takes a FilePartReader argument</p>
     */
    public FileWordAnalyzer(FilePartReader reader) {
        this.reader = reader;
    }

    /*
    <p>Public getter for the reader</p>
    @return FilePartReader reader
     */
    public FilePartReader getReader() {
        return reader;
    }

    /*
    <p>Public setter for the reader</p>
    @param reader FilePartReader
    @return nothing
     */
    public void setReader(FilePartReader reader) {
        this.reader = reader;
    }

    /*
    <p>This method returns the words from a document ordered alphabetically</p>
    @return orderedWords List<String>
     */
    public List<String> getWordsOrderedAlphabetically() throws IOException {
        List<String> orderedWords;
        orderedWords = Arrays.asList(this.reader.readLines().split("\\s+"));
        orderedWords.sort(String::compareToIgnoreCase);
        return orderedWords;
    }


    public List<String> getWordsContainingSubstring(String subString) throws IOException {
        List<String> allWords;
        List<String> substringWords = new ArrayList<>();
        allWords = Arrays.asList(this.reader.readLines().split("\\s+"));

        allWords.forEach((String word) -> {
            if (word.toLowerCase().contains(subString.toLowerCase())) {
                substringWords.add(word);
            }
        });
        return substringWords;
    }

    public List getStringsWhichPalindromes() throws IOException {
        List<String> allWords;
        List<String> palindromeWords = new ArrayList<>();
        allWords = Arrays.asList(this.reader.readLines().split("\\s+"));
        allWords.forEach((String word) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(word);
            if(word.toLowerCase().equals(sb.reverse().toString().toLowerCase())){
                System.out.println("True");
                palindromeWords.add(word);
            }
        });
        return palindromeWords;
    }

}
