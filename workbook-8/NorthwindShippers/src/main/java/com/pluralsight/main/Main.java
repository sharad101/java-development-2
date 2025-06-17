package com.pluralsight.main;

import com.pluralsight.db.DataManager;
import com.pluralsight.db.ShipperDataManager;
import com.pluralsight.model.Shipper;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("User and password are needed");
            System.exit(1);
        }

        String username = args[0];
        String password = args[1];

        BasicDataSource sakilaDataSource = new BasicDataSource();
        sakilaDataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        sakilaDataSource.setUsername(username);
        sakilaDataSource.setPassword(password);

        DataManager dataManager = new DataManager(sakilaDataSource);
        ShipperDataManager shipperDataManager = new ShipperDataManager(sakilaDataSource);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu");
            System.out.println("1. Insert Direct");
            System.out.println("2. Insert with generated keys");
            System.out.println("3. Update Record");
            System.out.println("4. Delete Record");
            System.out.println("5. Exit");
            System.out.println("6. Shippers Journey");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter a country: ");
                    String countryName = scanner.nextLine();
                    dataManager.insertIntoDirect(countryName);
                }
                case 2 -> {
                    System.out.println("Enter a country: ");
                    String countryNameWithKey = scanner.nextLine();
                    dataManager.insertIntoWithGeneratedKeys(countryNameWithKey);
                }
                case 3 -> {
                    System.out.println("Enter a new description: ");
                    String newDescription = scanner.nextLine();

                    System.out.println("Enter the ID of the film to update: ");
                    int filmID = scanner.nextInt();
                    scanner.nextLine();
                    dataManager.updateRecord(newDescription, filmID);
                }
                case 4 -> {
                    System.out.println("Enter a country to delete: ");
                    String countryToDelete = scanner.nextLine();
                    dataManager.deleteRecord(countryToDelete);
                }
                case 5 -> {
                    System.out.println("Exiting");
                    System.exit(0);
                }
                case 6 -> {
                    // Step 1: Insert new shipper
                    System.out.println("\n--- Step 1: Insert New Shipper ---");
                    System.out.print("Enter shipper name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();

                    Shipper newShipper = new Shipper(name, phone);
                    int newId = shipperDataManager.insertShipper(newShipper);
                    System.out.println("New shipper inserted with ID: " + newId);

                    // Step 2: Display all shippers
                    System.out.println("\n--- Step 2: All Shippers ---");
                    List<Shipper> allShippers = shipperDataManager.getAllShippers();
                    for (Shipper s : allShippers) {
                        System.out.println(s);
                    }

                    // Step 3: Update shipper phone
                    System.out.println("\n--- Step 3: Update Phone ---");
                    System.out.print("Enter shipper ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String updatedPhone = scanner.nextLine();
                    shipperDataManager.updatePhoneNumber(updateId, updatedPhone);

                    // Step 4: Display all shippers again
                    System.out.println("\n--- Step 4: Shippers After Update ---");
                    allShippers = shipperDataManager.getAllShippers();
                    for (Shipper s : allShippers) {
                        System.out.println(s);
                    }

                    // Step 5: Delete shipper (except IDs 1–3)
                    System.out.println("\n--- Step 5: Delete Shipper ---");
                    System.out.print("Enter shipper ID to delete (not 1–3): ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    if (deleteId > 3) {
                        shipperDataManager.deleteShipper(deleteId);
                        System.out.println("Deleted shipper with ID: " + deleteId);
                    } else {
                        System.out.println("Shipper ID 1–3 cannot be deleted.");
                    }

                    // Step 6: Display all shippers again
                    System.out.println("\n--- Step 6: Shippers After Deletion ---");
                    allShippers = shipperDataManager.getAllShippers();
                    for (Shipper s : allShippers) {
                        System.out.println(s);
                    }
                }
                default -> System.out.println("Invalid choice, try again.");
            }
        }
    }
}
