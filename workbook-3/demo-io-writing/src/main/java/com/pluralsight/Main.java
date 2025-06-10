package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            FileWriter writer = new FileWriter("skills.txt");

            writer.write("Hello Everyone\n");
            writer.write("potato\n");
            writer.write("welcome to the bootcamp");

            writer.close();

        } catch (Exception e) {
            System.err.println("An error has occurred");
        }
    }
}
