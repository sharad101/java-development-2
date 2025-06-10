package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main2 {
    public static void main(String[] args) {
        
        try {

            FileWriter fileWriter = new FileWriter("potato.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String numText;

            for (int i = 1; i <= 10; i++) {

                numText = String.format("Counting %d\n", i);

//                numText = "Counting" + i + "\n";

                bufferedWriter.write(numText);
            }

            bufferedWriter.close();



        } catch (Exception e) {
            System.err.println("An error occurred");
        }

    }


}
