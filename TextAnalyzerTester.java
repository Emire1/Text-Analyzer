package lab2;

import java.util.*;
import java.io.*;

public class TextAnalyzerTester {
    public static void main(String[] args) {

        TextAnalyzer textAnalyzer = new TextAnalyzer();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the file: ");
        String filename = sc.next();

        textAnalyzer.analyzeText(filename);

        System.out.println("Number of Lines: " + textAnalyzer.getLineCount());
        System.out.println("Number of Words: " + textAnalyzer.getWordCount());
        System.out.println("Letter Counts");
        int[] frequencies = textAnalyzer.getFrequencies();
        for (int k = 0; k < frequencies.length; k++)
            System.out.println("Frequency of " + (char)('A'+ k) +
                    ": "+frequencies[k] + " ");
        System.out.println();
    }

}
