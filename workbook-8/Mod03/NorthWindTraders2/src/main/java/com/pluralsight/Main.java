package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
            // load the MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 1. open a connection to the database
            // use the database URL to point to the correct database
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/northwind",
                    "root",
                    "yearup24"
            );

            // create statement
            // the statement is tied to the open connection
            Statement statement = connection.createStatement();

        String query = """
            SELECT ProductID, ProductName, UnitPrice, UnitsInStock
            FROM products;
            """;

            // 2. Execute your query
            ResultSet results = statement.executeQuery(query);

        // Print table header
        System.out.printf("%-5s %-30s %-10s %-5s%n", "ID", "Name", "Price", "Stock");
        System.out.println("-------------------------------------------------------------");

        // Print each row
        while (results.next()) {
            int id = results.getInt("ProductID");
            String name = results.getString("ProductName");
            double price = results.getDouble("UnitPrice");
            int stock = results.getInt("UnitsInStock");

            System.out.printf("%-5d %-30s $%-9.2f %-5d%n", id, name, price, stock);
        }

            // 3. Close the connection
            connection.close();
        }

    }

