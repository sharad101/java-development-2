package com.pluralsight;

import java.util.Scanner;

public class QuotesApp {
    public static void main(String[] args) {
        String[] quotes = {
                "Less talk, more do.",
                "Dream big. Start small.",
                "Stay hungry. Stay foolish.",
                "Progress, not perfection.",
                "Do it scared.",
                "Be the energy you want to attract.",
                "Fall seven times, stand up eight.",
                "Work hard in silence, let success make the noise.",
                "You miss 100% of the shots you don’t take.",
                "Discipline is freedom."
        };

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter a number between 1-10 to display quote: ");
            System.out.println("Your choice: ");

            int indexFromUser = scanner.nextInt();

            System.out.println(quotes[indexFromUser - 1]);
        } catch (Exception e) {
            System.out.println("Invalid Input");
        }


    }
}
