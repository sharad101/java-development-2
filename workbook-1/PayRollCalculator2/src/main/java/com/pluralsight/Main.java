package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for their name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Prompt the user for their hours worked
        System.out.print("Enter the hours worked (e.g., 45.0): ");
        double hoursWorked = scanner.nextDouble();

        // Prompt the user for their pay rate
        System.out.print("Enter your pay rate per hour (e.g., 15.00): ");
        double payRate = scanner.nextDouble();

        double grossPay;
        double overtimeHours = 0;
        double regularPay = 0;
        double overtimePay = 0;

        if (hoursWorked > 40) {
            regularPay = 40 * payRate;
            overtimeHours = hoursWorked - 40;
            overtimePay = overtimeHours * (payRate * 1.5);
            grossPay = regularPay + overtimePay;
        } else {
            grossPay = hoursWorked * payRate;
        }

        // Display the employee's name and their gross pay
        System.out.println("\n--- Payroll Information ---");
        System.out.println("Employee Name: " + name);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Pay Rate: $" + String.format("%.2f", payRate));
        if (overtimeHours > 0) {
            System.out.println("Overtime Hours: " + String.format("%.2f", overtimeHours));
            System.out.println("Regular Pay: $" + String.format("%.2f", regularPay));
            System.out.println("Overtime Pay: $" + String.format("%.2f", overtimePay));
        }
        System.out.println("Gross Pay: $" + String.format("%.2f", grossPay));

        scanner.close();
    }

    public static double calcuateGrossPay(double hoursWorked, double payate){
        double grossPay;
        if (hoursWorked > 40) {
            regularPay = 40 * payRate;
            overtimeHours = hoursWorked - 40;
            overtimePay = overtimeHours * (payRate * 1.5);
            grossPay = regularPay + overtimePay;
        } else {
            grossPay = hoursWorked * payRate;
        }

    }
}
