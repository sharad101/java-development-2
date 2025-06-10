package com.pluralsight;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Prompt for input file
        System.out.print("Enter the name of the employee file to process: ");
        String inputFile = scanner.nextLine();

        // Prompt for output file
        System.out.print("Enter the name of the payroll file to create: ");
        String outputFile = scanner.nextLine();

        List<Employee> employees = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("employees.csv"));

            String line; // Declare the 'line' variable here

            // Read each line from the file
            while ((line = bufferedReader.readLine()) != null) {

                // Split the line by the pipe character '|'
                String[] tokens = line.split("\\|");

                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                // Create an Employee object
                Employee employee = new Employee(id, name, hoursWorked, payRate);

                // Print the employee's details
                System.out.printf("Employee Id: %d | Name: %s | Gross Pay: $%.2f%n",
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
            }

            bufferedReader.close();

        } catch (Exception e) {
            System.out.println("File not found");
        }
    }
}
