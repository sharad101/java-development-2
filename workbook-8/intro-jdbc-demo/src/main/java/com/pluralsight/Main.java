package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // load the MySQL Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 1. open a connection to the database
        // use the database URL to point to the correct database
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/world",
                "root",
                "yearup24"

        );

        // create statement
        // the statement is tied to the open connection
        Statement statement = connection.createStatement();

        String query = """
                SELECT Name
                FROM City
                WHERE CountryCode = 'USA'
                """;

        // 2. Execute your query
        ResultSet results = statement.executeQuery(query);

        while (results.next()){
            String city = results.getString("Name");
            System.out.println(city);
        }

        // 3. Close the connection
        connection.close();






    }
}
