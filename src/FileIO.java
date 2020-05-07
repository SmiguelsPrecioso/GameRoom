/* FileIO.Java
* William Deeds (Wayne Cook)
* 5/7/2020
* This is the fileIO class to help users save their data.
*/


import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class FileIO {
    private String fileName = "Games.Played";
    private File file;
    private Scanner inputFile;
    private FileWriter outputFile;
    private boolean fileExists = false;                     // Flag for whether file exists or not.

    // Constructor - must include the fileName or an empty string to use the default name.
    protected FileIO(String fileName) {
        if (fileName.length() > 0) {
            this.fileName = fileName;                    // Initialize the file name.
        }
        file = new File(this.fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println("file: " + file + " cannot be created.");
            }
        }
        // The file exists, so open it for writing
        try {
            outputFile = new FileWriter(file, true);  // Incase we want to add to the file later.
        } catch (FileNotFoundException ex) {
            System.out.println("file: " + file + " dies not exist.");
        } catch (IOException ex) {
            System.out.println("file: " + file + " cannot be opened.");
        }
        // Set up file for reading, done in readFile()
    }

    // Write the file from scratch.
    protected boolean writeFile(ArrayList<String> lines, boolean appendFlag) {
        boolean retVal = true;
        // First set up the file to write to it. Erases file at first.
        try {
            outputFile.close(); // Close it before restarting it.
            outputFile = new FileWriter(file, appendFlag);  // Incase we want to add to the file later.
        } catch (FileNotFoundException ex) {
            System.out.println("file: " + file + " dies not exist.");
        } catch (IOException ex) {
            System.out.println("file: " + file + " cannot be opened.");
        }
        // Now do the writing of the file.
        int numLines = lines.size();
        //outputFile.println( numLines );
        for (int i = 0; i < numLines; i++) {
            try {
                outputFile.write(lines.get(i));
            } catch (IOException ex) {
                System.out.println("Failure to write to the file");
            }
        }
        try {
            outputFile.flush();   // Force the actula write
        } catch (IOException ex) {
            System.out.println("Failure to write to the file");
        }
        return retVal;
    }

    // Append to an existing file
    public boolean appendLine(String line) {
        boolean retVal = true;
        try {
            outputFile.append("\n" + line);
            outputFile.flush();         // Flush the buffer.
        } catch (IOException e) {
            retVal = false;
        }
        return retVal;
    }

    public void splitLine(ArrayList<String> splitArray, String inString, char delim) {
        int len = inString.length();
        int j = 0, k = 0;
        splitArray.clear();
        for (int i = 0; i < len; i++) {
            if (inString.charAt(i) == ',') {
                String elem = inString.substring(j, i);
                //System.out.println("Element " + k++ + " is " + elem);
                splitArray.add(elem);
                j = i + 1;
            }
            if (i == len - 1) {
                String elem = inString.substring(j);
                //System.out.println("Element " + k++ + " is " + elem);
                splitArray.add(elem);
            }
        }

        protected ArrayList<String> readFile () {
            String tempLine;

            ArrayList<String> params = new ArrayList<>();
            // Set up the file.
            try {
                inputFile = new Scanner(file);
                fileExists = true;
            } catch (FileNotFoundException ex) {
                System.out.println("file: " + file + " cannot be opened.");
                fileExists = false;
            }
            String inputLine;
            if (fileExists) {
                while (inputFile.hasNextLine()) {
                    inputLine = inputFile.nextLine();
                    params.add(inputLine);
                }
            }
            // Now return what you have, if no file then return array shoulc be NULL length.
            return (params);                            // Return the array list of Strings, Null if could not open file.
        }
    }
}

