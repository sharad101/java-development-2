package com.pluralsight;

import java.util.Scanner;

public class SandwichShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double basePrice = getSandwichBasePrice(scanner);
        double discount = calculateDiscount(scanner);
        double finalPrice = calculateFinalPrice(basePrice, discount);

        displayOrderSummary(basePrice, discount, finalPrice);

        scanner.close();
    }

    // Method to get the base price of the sandwich from the user
    public static double getSandwichBasePrice(Scanner scanner) {
        double basePrice = 0.0;
        System.out.println("Select the size of the sandwich (1 or 2):");
        System.out.println("1: Regular - base price $5.45");
        System.out.println("2: Large - base price $8.95");
        System.out.print("Enter your choice (1 or 2): ");
        int sizeChoice = scanner.nextInt();
        scanner.nextLine();

        if (sizeChoice == 1) {
            basePrice = 5.45;
        } else if (sizeChoice == 2) {
            basePrice = 8.95;
        } else {
            System.out.println("Invalid size choice. Defaulting to Regular ($5.45).");
            basePrice = 5.45;
        }
        return basePrice;
    }

    // Method to calculate the discount based on the user's age
    public static double calculateDiscount(Scanner scanner) {
        double discount = 0.0;
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        if (age <= 17) {
            System.out.println("Student discount (10%) applied.");
            discount = 0.10;
        } else if (age >= 65) {
            System.out.println("Senior discount (20%) applied.");
            discount = 0.20;
        }
        return discount;
    }

    // Method to calculate the final price after applying the discount
    public static double calculateFinalPrice(double basePrice, double discount) {
        return basePrice * (1 - discount);
    }

    // Method to display the order summary
    public static void displayOrderSummary(double basePrice, double discount, double finalPrice) {
        System.out.println("\n--- Order Summary ---");
        System.out.println("Base Price: $" + String.format("%.2f", basePrice));
        if (discount > 0) {
            System.out.println("Discount Applied: " + (int) (discount * 100) + "%");
        }
        System.out.println("Total Cost: $" + String.format("%.2f", finalPrice));
    }

}
