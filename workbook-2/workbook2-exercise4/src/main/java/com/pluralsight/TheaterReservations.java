package com.pluralsight;

import java.util.Scanner;
import java.time.LocalDate;

public class TheaterReservations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user's full name
        System.out.print("Please enter your name: ");
        String fullName = scanner.nextLine().trim();

        // Get date input
        System.out.print("What date will you be coming (MM/dd/yyyy): ");
        String[] dateParts = scanner.nextLine().split("/");

        // Convert to LocalDate
        int month = Integer.parseInt(dateParts[0]);
        int day = Integer.parseInt(dateParts[1]);
        int year = Integer.parseInt(dateParts[2]);
        LocalDate date = LocalDate.of(year, month, day);

        // Get number of tickets
        System.out.print("How many tickets would you like? ");
        int tickets = scanner.nextInt();

        // Print confirmation
        String ticketText = tickets == 1 ? "ticket" : "tickets";
        System.out.println(tickets + " " + ticketText + " reserved for " + date + " under " + lastName + ", " + firstName);

        scanner.close();
    }
}
