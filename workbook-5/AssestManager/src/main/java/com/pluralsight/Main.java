package com.pluralsight;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create currency formatter
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

        // Create an ArrayList of Asset objects
        ArrayList<Asset> assets = new ArrayList<>();

        // Add at least 2 houses
        assets.add(new House("My Primary Residence", "05/10/2018", 350000.00,
                "123 Main Street, Springfield, IL", 1, 2200, 8500));

        assets.add(new House("Vacation Home", "08/15/2020", 280000.00,
                "456 Lake View Drive, Lake Geneva, WI", 2, 1800, 12000));

        // Add at least 2 vehicles
        assets.add(new Vehicle("My Commuter Car", "03/22/2021", 28000.00,
                "Honda Civic", 2021, 45000));

        assets.add(new Vehicle("Tom's Truck", "11/14/2016", 42000.00,
                "Ford F-150", 2016, 110000));

        assets.add(new Vehicle("Family SUV", "07/05/2018", 38000.00,
                "Toyota RAV4", 2018, 120000));

        // Loop through and display details for each asset
        System.out.println("ASSET PORTFOLIO SUMMARY");
        System.out.println("==============================================");

        for (Asset asset : assets) {
            System.out.println("Description: " + asset.getDescription());
            System.out.println("Date Acquired: " + asset.getDateAcquired());
            System.out.println("Original Cost: " + currencyFormat.format(asset.getOriginalCost()));
            System.out.println("Current Value: " + currencyFormat.format(asset.getValue()));

            // Use instanceof to determine the specific asset type and display additional details
            if (asset instanceof House) {
                House house = (House) asset;  // Downcast to House
                System.out.println("Address: " + house.getAddress());
                System.out.println("Condition: " + getConditionDescription(house.getCondition()));
                System.out.println("Square Footage: " + house.getSquareFoot());
                System.out.println("Lot Size: " + house.getLotSize() + " sq ft");
            } else if (asset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) asset;  // Downcast to Vehicle
                System.out.println("Make/Model: " + vehicle.getMakeModel());
                System.out.println("Year: " + vehicle.getYear());
                System.out.println("Odometer: " + vehicle.getOdometer() + " miles");
            }

            System.out.println("==============================================");
        }
    }

    // Helper method to convert condition code to description
    private static String getConditionDescription(int condition) {
        switch (condition) {
            case 1: return "Excellent";
            case 2: return "Good";
            case 3: return "Fair";
            case 4: return "Poor";
            default: return "Unknown";
        }
    }
}
