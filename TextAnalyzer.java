package lab2;

import java.util.*;
import java.io.*;


/**
 * This program takes in a text file as an input
 * and count the number of lines,
 * the total number of words,
 * the total amount of how many times an alphabet appears in the file
 *
 * @author Emmanuel Mireku, Tegan Stoddart
 * @version 2/12/2019
 */

public class TextAnalyzer
{

    // integer instance variable to count the lines in the text file
    private int lineCount = 0;

//--------------------------------------------------------------------------------------

    // integer instance variable to count the words in a string per line
    private int wordCount = 0;

//---------------------------------------------------------------------------------------

    // integer instance variable to count how many times a character appears in a string per line
    private int[] frequencies = new int[26];

//----------------------------------------------------------------------------------------

    // a get method to return lineCount
    public int getLineCount()
    {
        return lineCount;
    }

//-----------------------------------------------------------------------------------------

    // a get method to return wordCount
    public int getWordCount()
    {
        return wordCount;
    }

//------------------------------------------------------------------------------------------

    // a get method to return the frequencies
    public int[] getFrequencies()
    {
        return frequencies;
    }

//-------------------------------------------------------------------------------------------

    /**
     * This opens the specified file
     * reads the data in the file line by line
     * Update the lineCount
     * split the line into words
     * Counts the words and update the wordCount
     * Scans the line character by character and update the frequencies of each character
     * All non-alphabets are ignored
     * @param fileName: A string object
     */
    public void analyzeText(String fileName)
    {

        // a string variable that stores the whole string line
        String currentLine;

        // a loop to set the value at every index to 0
        for (int x = 0; x < frequencies.length; x++) frequencies[x] = 0;

        // set the myFileIn to null, which means to open the file
        Scanner myFileIn = null;


        try
        {
            // pass in myFileIn into scanner for reading
            myFileIn = new Scanner(new File(fileName));

        } catch (FileNotFoundException e)
        {
            System.out.println("File: "+fileName+" is not found.");
        }


        while (myFileIn.hasNextLine())
        {

            // set the whole strings in each line into currentLine
            currentLine = myFileIn.nextLine();

            // increment lineCount by one
            lineCount++;

            // remove all spaces in current line currentLine and store them in string words array
            String[] words = currentLine.split(" ");

            // set the wordCount to the length of words array plus the previous wordCount
            wordCount += words.length;

            // go through the currentLine and count the characters in them
            for (int j=0; j < currentLine.length(); j++)
            {

                // convert every character into a capital letter
                char ch = Character.toUpperCase(currentLine.charAt(j));

                // check if the character is between z and a
                if (ch <= 'Z' && ch >= 'A')
                {

                    // set the current character to a temporary variable and subtract it by A
                    int temp = ch - 'A';

                    // increment the the frequency at the temp value by 1
                    frequencies[temp] ++;
                }
                else ;//do nothing
            }

        }
    }
    
}
