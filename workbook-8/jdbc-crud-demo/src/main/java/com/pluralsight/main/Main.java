package com.pluralsight.main;

import com.pluralsight.db.DataManager;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if(args.length != 2){
            System.err.println("User adn password are needed");
            System.exit(1);
        }

        String username = args[0];
        String password = args[1];

        BasicDataSource sakilaDataSource=  new BasicDataSource();
        sakilaDataSource.setUrl("jdbc:mysql://loclahost3306/sakila");
        sakilaDataSource.setUsername(username);
        sakilaDataSource.setPassword(password);


        DataManager dataManager = new DataManager(sakilaDataSource);

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Menu");
            System.out.println("1. Insert Direct");
            System.out.println("2. Insert with generated keys");
            System.out.println("3. Update Record");
            System.out.println("4. Delete Record");
            System.out.println("5. Exit");
            System.out.println("Choose an option");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1 -> {
                    System.out.println("Enter a country: ");
                    String countryName = scanner.nextLine();
                    dataManager.InsertIntoDirect(countryName);
                }
                case 2 -> {
                    System.out.println("Enter a country: ");
                    String countryNameWithKey = scanner.nextLine();
                    dataManager.InsertIntoWithGeneratedKeys(countryNameWithKey);
                }

                case 3 -> {
                    System.out.println("Enter a new description: ");
                    String newDescription = scanner.nextLine();

                    System.out.println("Enter the ID of the film to update ");
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
                default -> System.out.println("Invalid choice, try again");




            }

        }


    }
}
