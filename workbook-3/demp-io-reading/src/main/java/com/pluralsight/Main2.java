package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main2 {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("poem.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);


//            BufferedReader bufReader = new BufferedReader(new FileReader("poem.txt"));

            String line;

            while ((line = bufferedReader.readLine()) != null){

                System.out.println(line);

            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong");
        }
    }
}
