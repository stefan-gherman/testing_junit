package com.codecool;

import com.codecool.analyzers.FileWordAnalyzer;
import com.codecool.readers.FilePartReader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FilePartReader reader = new FilePartReader();
        reader.setup("/mnt/7d45c543-fc06-4310-b70a-2a9aa2e43a54/Projects/codecool/java/testing_junit/.idea/files/text_file.txt", 1, 13);

//        System.out.println(reader.read());
//        System.out.println("??");
        //System.out.println(reader.readLines());

//        reader.setToLine(2);
//        reader.setFromLine(12);
//
//        System.out.println(reader.readLines());

//        reader.setToLine(1);
//        reader.setFromLine(1);
//
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
//        System.out.println(reader.readLines());
//        System.out.println(analyzer.getWordsOrderedAlphabetically());
//
//        reader.setFilePath("/mnt/7d45c543-fc06-4310-b70a-2a9aa2e43a54/Projects/codecool/java/testing_junit/.idea/files/for_test.txt");
//        reader.setFromLine(1);
//        reader.setToLine(2);
//
//        System.out.println(analyzer.getWordsOrderedAlphabetically());
//        System.out.println(analyzer.getWordsContainingSubstring("roads"));


        reader.setFilePath("/mnt/7d45c543-fc06-4310-b70a-2a9aa2e43a54/Projects/codecool/java/testing_junit/.idea/files/palindromes.txt");
        reader.setFromLine(1);
        reader.setToLine(2);

        System.out.println(analyzer.getStringsWhichPalindromes());

    }
}
