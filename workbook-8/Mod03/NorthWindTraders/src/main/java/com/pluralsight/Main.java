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
                SELECT ProductName
                FROM products;
                """;

        // 2. Execute your query
        ResultSet results = statement.executeQuery(query);

        while (results.next()){
            String productName = results.getString("ProductName");
            System.out.println(productName);
        }

        // 3. Close the connection
        connection.close();
    }

}
