package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String userInput = "2002-10-7";

        LocalDate birthDay = LocalDate.parse(userInput);

        System.out.println("===============================");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date you want (MM/dd/yyyy):");
        String dateInputFromUser = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        LocalDate userDate = LocalDate.parse(dateInputFromUser, formatter);

        System.out.println(birthDay);

    }
}
