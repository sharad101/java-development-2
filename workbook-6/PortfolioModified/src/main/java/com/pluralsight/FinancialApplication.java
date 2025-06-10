package com.pluralsight;

import com.pluralsight.finance.*;

import java.util.Scanner;


public class FinancialApplication {
    private static Scanner scanner = new Scanner(System.in);
    private static Portfolio userPortfolio;

    /**
     * Main method to run the Portfolio application
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Financial Portfolio Application");
        System.out.println("-------------------------------");

        initializePortfolio();

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    addAsset();
                    break;
                case 2:
                    displayPortfolioSummary();
                    break;
                case 3:
                    displayAllAssets();
                    break;
                case 4:
                    displayMostAndLeastValuable();
                    break;
                case 5:
                    running = false;
                    System.out.println("Thank you for using the Portfolio Application!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }


    private static void initializePortfolio() {
        System.out.println("\nLet's set up your portfolio:");
        String name = getStringInput("Enter portfolio name: ");
        String owner = getStringInput("Enter your name (owner): ");

        userPortfolio = new Portfolio(name, owner);
        System.out.println("Portfolio created successfully!");
    }


    private static void displayMenu() {
        System.out.println("\nMenu Options:");
        System.out.println("1. Add a new asset");
        System.out.println("2. View portfolio summary");
        System.out.println("3. List all assets");
        System.out.println("4. View most and least valuable assets");
        System.out.println("5. Exit");
    }


    private static void addAsset() {
        System.out.println("\nAdd New Asset:");
        System.out.println("1. Jewelry");
        System.out.println("2. Gold");
        System.out.println("3. House");
        System.out.println("4. Bank Account");
        System.out.println("5. Credit Card");

        int choice = getIntInput("Select asset type: ");

        switch (choice) {
            case 1:
                addJewelry();
                break;
            case 2:
                addGold();
                break;
            case 3:
                addHouse();
                break;
            case 4:
                addBankAccount();
                break;
            case 5:
                addCreditCard();
                break;
            default:
                System.out.println("Invalid asset type selection.");
        }
    }


    private static void addJewelry() {
        String name = getStringInput("Enter jewelry name/description: ");
        double karat = getDoubleInput("Enter karat value: ");

        Jewelry jewelry = new Jewelry(name, karat);
        userPortfolio.add(jewelry);

        System.out.printf("Added %s (%.1f karat) with value $%.2f\n",
                name, karat, jewelry.getValue());
    }


    private static void addGold() {
        double weight = getDoubleInput("Enter gold weight in ounces: ");

        Gold gold = new Gold(weight);
        userPortfolio.add(gold);

        System.out.printf("Added Gold (%.1f oz) with value $%.2f\n",
                weight, gold.getValue());
    }


    private static void addHouse() {
        int year = getIntInput("Enter year built: ");
        int squareFeet = getIntInput("Enter square footage: ");
        int bedrooms = getIntInput("Enter number of bedrooms: ");

        House house = new House(year, squareFeet, bedrooms);
        userPortfolio.add(house);

        System.out.printf("Added House (%d sq ft, %d bedrooms, built %d) with value $%.2f\n",
                squareFeet, bedrooms, year, house.getValue());
    }


    private static void addBankAccount() {
        String name = getStringInput("Enter account name: ");
        String accountNumber = getStringInput("Enter account number: ");
        double balance = getDoubleInput("Enter current balance: ");

        BankAccount account = new BankAccount(name, accountNumber, balance);
        userPortfolio.add(account);

        System.out.printf("Added %s account with balance $%.2f\n",
                name, account.getValue());
    }


    private static void addCreditCard() {
        String name = getStringInput("Enter credit card name: ");
        String accountNumber = getStringInput("Enter card number: ");
        double balance = getDoubleInput("Enter current balance/debt: ");

        CreditCard card = new CreditCard(name, accountNumber, balance);
        userPortfolio.add(card);

        System.out.printf("Added %s credit card with balance $%.2f (value: $%.2f)\n",
                name, balance, card.getValue());
    }


    private static void displayPortfolioSummary() {
        System.out.println("\nPortfolio Summary:");
        System.out.println("------------------");
        System.out.println("Name: " + userPortfolio.getName());
        System.out.println("Owner: " + userPortfolio.getOwner());
        System.out.println("Number of assets: " + userPortfolio.getAssets().size());
        System.out.printf("Total net worth: $%,.2f\n", userPortfolio.getValue());
    }


    private static void displayAllAssets() {
        System.out.println("\nAll Assets:");
        System.out.println("-----------");

        if (userPortfolio.getAssets().isEmpty()) {
            System.out.println("No assets in portfolio.");
            return;
        }

        int count = 1;
        for (Valuable asset : userPortfolio.getAssets()) {
            System.out.printf("%d. ", count++);
            displayAssetInfo(asset);
        }
    }


    private static void displayMostAndLeastValuable() {
        if (userPortfolio.getAssets().isEmpty()) {
            System.out.println("No assets in portfolio.");
            return;
        }

        System.out.println("\nMost Valuable Asset:");
        System.out.println("--------------------");
        displayAssetInfo(userPortfolio.getMostValuable());

        System.out.println("\nLeast Valuable Asset:");
        System.out.println("--------------------");
        displayAssetInfo(userPortfolio.getLeastValuable());
    }


    private static void displayAssetInfo(Valuable asset) {
        if (asset instanceof Jewelry) {
            Jewelry jewelry = (Jewelry) asset;
            System.out.printf("Jewelry: %s (%.1f karat) - Value: $%,.2f\n",
                    jewelry.getName(), jewelry.getKarat(), jewelry.getValue());
        } else if (asset instanceof Gold) {
            Gold gold = (Gold) asset;
            System.out.printf("Gold: %.1f oz - Value: $%,.2f\n",
                    gold.getWeight(), gold.getValue());
        } else if (asset instanceof House) {
            House house = (House) asset;
            System.out.printf("House: %d sq ft, %d bedrooms, built %d - Value: $%,.2f\n",
                    house.getSquareFeet(), house.getBedrooms(), house.getYearBuilt(), house.getValue());
        } else if (asset instanceof BankAccount) {
            BankAccount account = (BankAccount) asset;
            System.out.printf("Bank Account: %s (#%s) - Balance: $%,.2f\n",
                    account.getName(), account.getAccountNumber(), account.getValue());
        } else if (asset instanceof CreditCard) {
            CreditCard card = (CreditCard) asset;
            System.out.printf("Credit Card: %s (#%s) - Balance: $%,.2f, Value: $%,.2f\n",
                    card.getName(), card.getAccountNumber(), card.getBalance(), card.getValue());
        } else {
            System.out.printf("Unknown asset type - Value: $%,.2f\n", asset.getValue());
        }
    }


    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }


    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}
