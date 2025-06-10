package com.pluralsight;

import java.util.Scanner;
import java.util.Random;

public class MyApplication {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Declare variables
        String name;
        int userAge;

        // Get input for user's name
        System.out.print("Enter your name: ");
        name = scanner.nextLine();

        // Get input for user's age
        System.out.print("Enter your age: ");
        userAge = scanner.nextInt();

        // Print out the user's name and age
        System.out.println("\n--- User Information ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + userAge);

        // Check if the user is old enough to vote
        if (userAge >= 18) {
            System.out.println("\nYou are old enough to vote.");
        } else {
            System.out.println("\nYou are not old enough to vote.");
        }

        // Ternary operator to check for "Eve"
        String eveMessage = name.equals("Eve") ? "Eve, you are not welcome." : "Welcome!";
        System.out.println("\n--- Eve Check ---");
        System.out.println(eveMessage);

        scanner.close(); // Close the scanner to release resources
    }

    // Method to print personalized message
//    public static void printMessage(String name, int age) {
//        System.out.println("\n--- Personalized Message ---");
//        System.out.println("Hello, " + name + "! You are " + age + " years old.");
//    }

    // Modified method to print a welcome message based on the name
    public static void printWelcomeMessage(String name) {
        System.out.println("\n--- Welcome Message ---");
        switch (name) {
            case "Alice":
                System.out.println("Welcome, Alice!");
                break;
            case "Bob":
                System.out.println("Hey Bob, want to grab a drink?");
                break;
            default:
                System.out.println("Welcome!");
                break;
        }
    }


    // Method to check and print voting eligibility
    public static void checkVotingEligibility(int age) {
        if (age >= 18) {
            System.out.println("You are old enough to vote.");
        } else {
            System.out.println("You are not old enough to vote.");
        }
    }

    // New method to welcome Alice
    public static void welcomeAlice(String name) {
        if (name.equals("Alice")) {
            System.out.println("\nWelcome, Alice!");
        } else {
            System.out.println("\nWelcome!");
        }
    }

    // New method to check drinking eligibility for Bob
    public static void checkDrinkingEligibility(String name, int age) {
        if (name.equals("Bob") && age >= 21) {
            System.out.println("\nHello Bob, you are old enough to drink.");
        } else {
            System.out.println("\nYou are not old enough to drink.");
        }

    }

    // New method to calculate and return the square root of a number
    public static double squareRoot(double number) {
        return Math.sqrt(number);
    }

    // New method to check if the first integer is greater than the second
    public static boolean isFirstGreaterThanSecond(int num1, int num2) {
        return num1 > num2;
    }

    // New method to check for "Eve" and print the welcome message
    public static void printEveCheckMessage(String name) {
        System.out.println("\n--- Eve Check ---");
        String eveMessage = name.equals("Eve") ? "Eve, you are not welcome." : "Welcome!";
        System.out.println(eveMessage);
    }

    // New method to find and return the larger of two integers
    public static int findLargerInt(int num1, int num2) {
        return Math.max(num1, num2);
    }

    public static int generateRandomNumber() {
        Random random = new Random();
        // nextInt(bound) generates a random number between 0 (inclusive) and bound (exclusive)
        // To get a number between 1 and 10, we set the bound to 10 and add 1 to the result.
        return random.nextInt(10) + 1;
    }

    // New method to find and return the smaller of two numbers
    public static double findSmallerNumber(double num1, double num2) {
        return Math.min(num1, num2);
    }

}


