package com.pluralsight;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        try {

            if (args.length != 2) {
                System.out.println(
                        "Application needs two arguments to run: " +
                                "java com.pluralsight.UsingDriverManager <username> <password>");
                System.exit(1);
            }
            // get the user name and password from the command line args
            String username = args[0];
            String password = args[1];

            // uses eager loading to load the driver into memory
            // if the dependency has not been added the application
            // will fail here


            Scanner scanner = new Scanner(System.in);

            System.out.println("Please enter a last name to search");
            String lastNameToSearch = scanner.nextLine();

            Class.forName("com.mysql.cj.jdbc.Driver");

            String query = """
                    SELECT first_name, last_name
                    FROM customer
                    WHERE last_name LIKE ?
                    ORDER BY first_name
                    """;

            try(
                    // use the driver to create a connection
                    Connection connection = DriverManager. getConnection(
                        "jdbc:mysql://localhost:3306/sakila", "root", "yearup24");
                ){


               PreparedStatement preparedStatement = connection.prepareStatement(query);

                preparedStatement.setString(1, lastNameToSearch);

                try( ResultSet results = preparedStatement.executeQuery();){

                    while(results.next()){

                        //String firstName = results.getString(1);
                        // String lastName = results.getString(2);

                        String firstName = results.getString("first_name");
                        String lastName = results.getString("last_name");


                        System.out.println("First name: " + firstName );
                        System.out.println("Last name: " + lastName);
                        System.out.println("==============================");

                    }

                }

            }

        } catch (Exception ex) {
            System.out.println("An error has occured");
            ex.printStackTrace();
        }

    }
}


