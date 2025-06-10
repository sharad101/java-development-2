package com.pluralsight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the story filename
        System.out.print("Enter the name of a story: ");
        String fileName = scanner.nextLine();

        try {
            scanner = new Scanner(new FileInputStream(fileName));

            String inputLine;
            int lineNumber = 1;

            // Read and print all lines with line numbers
            while (scanner.hasNextLine()) {
                inputLine = scanner.nextLine();
                System.out.println(lineNumber + ". " + inputLine);
                lineNumber++;
            }

            scanner.close(); // Close after done with file

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
