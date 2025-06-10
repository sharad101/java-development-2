package com.pluralsight;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet results = null;


        try {
            if (args.length != 2) {
                System.out.println("This application needs a Username and a Password to run");
                System.exit(1);
            }

            String username = args[0];
            String password = args[1];

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nWhat do you want to do?");
                System.out.println("1) Display all products");
                System.out.println("2) Display all customers");
                System.out.println("0) Exit");
                System.out.print("Select an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                if (choice == 0) {
                    System.out.println("Exit");
                    break;

                    Class.forName("com.mysql.cj.jdbc.Driver");

                    connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/northwind",
                            username,
                            password
                    );

                    switch (choice) {
                        case 1:
                            String productQuery = """
                                    SELECT ProductName, QuantityPerUnit, UnitPrice, UnitsInStock
                                    FROM Products
                                    ORDER BY ProductName;
                                    """;
                            preparedStatement = connection.prepareStatement(productQuery);
                            results = preparedStatement.executeQuery();

                            while (results.next()) {
                                String productName = results.getString("ProductName");
                                String quantityPerUnit = results.getString("QuantityPerUnit");
                                double unitPrice = results.getDouble("UnitPrice");
                                int unitsInStock = results.getInt("UnitsInStock");

                                System.out.println("\nProduct Name: " + productName);
                                System.out.println("Quantity Per Unit: " + quantityPerUnit);
                                System.out.println("Unit Price: $" + unitPrice);
                                System.out.println("Units In Stock: " + unitsInStock);
                                System.out.println("--------------------------------------------------");
                            }
                            break;

                        case 2:
                            String query = """
                                        SELECT  CustomerID, ContactName
                                        FROM Customers
                                    """;
                            preparedStatement = connection.prepareStatement(query);
                            results = preparedStatement.executeQuery();

                            while (results.next()) {
                                String contactName = results.getString("ContactName");
                                String companyName = results.getString("CompanyName");
                                String city = results.getString("City");
                                String country = results.getString("Country");
                                String phone = results.getString("Phone");

                                System.out.println("\nContact Name: " + contactName);
                                System.out.println("Company Name: " + companyName);
                                System.out.println("City: " + city);
                                System.out.println("Country: " + country);
                                System.out.println("Phone: " + phone);
                                System.out.println("--------------------------------------------------");
                            }
                            break;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }

                }
            }

        } catch (Exception ex) {
            System.out.println("An error has occured");
            ex.printStackTrace();
        } finally {

            if (results != null) {
                try {
                    results.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    }