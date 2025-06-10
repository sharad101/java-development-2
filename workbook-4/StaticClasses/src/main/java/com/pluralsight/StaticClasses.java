package com.pluralsight;

public class StaticClasses {
    public static void main(String[] args) {

        // Using the format method with first and last name
        System.out.println(NameFormatter.format("Mel", "Johnson"));
        // Output: Johnson, Mel

        // Using the full method with prefix, first, middle, last, and suffix
        System.out.println(NameFormatter.format("Dr.", "Mel", "B", "Johnson", "PhD"));
        // Output: Johnson, Dr. Mel B, PhD

        // Using the method that parses a full formatted name string
        System.out.println(NameFormatter.format("Dr. Mel B Johnson, PhD"));
        // Output: Johnson, Dr. Mel B, PhD

        // Another example with missing middle name and suffix
        System.out.println(NameFormatter.format("Mel Johnson"));
        // Output: Johnson, Mel

    }
}
