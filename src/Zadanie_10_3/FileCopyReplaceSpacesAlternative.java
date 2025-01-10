package Zadanie_10_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileCopyReplaceSpacesAlternative {
    public static void main(String[] args) {
        String inputFilePath = "src/Zadanie_10_3/ExampleText.txt";
        String outputFilePath = "src/Zadanie_10_3/ReplacedExampleText.txt";

        File inputFile = new File(inputFilePath);
        File outputFile = new File(outputFilePath);

        // Check if the input file exists
        if (!inputFile.exists()) {
            System.err.println("Input file does not exist: " + inputFilePath);
            return;
        }

        // Ensure the output file is created if it doesn't already exist
        try (Scanner scanner = new Scanner(inputFile);
             PrintWriter writer = new PrintWriter(outputFile)) {

            // Process each line of the input file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Replace spaces with hyphens in each line
                String modifiedLine = line.replace(" ", "-");
                // Write the modified line to the output file
                writer.println(modifiedLine);
            }

            System.out.println("File has been successfully copied with spaces replaced.");
        } catch (FileNotFoundException e) {
            System.err.println("An error occurred with the file: " + e.getMessage());
        }
    }
}
