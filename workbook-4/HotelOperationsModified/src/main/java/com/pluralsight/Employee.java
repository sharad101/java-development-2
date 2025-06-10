package com.pluralsight;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double lastPunchInTime; // Added to track punch-in time

    // Constructor for Employee
    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.lastPunchInTime = 0; // Initialize with 0
    }

    // Getter for employeeId
    public int getEmployeeId() {
        return employeeId;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for department
    public String getDepartment() {
        return department;
    }

    // Getter for payRate
    public double getPayRate() {
        return payRate;
    }

    // Getter for hoursWorked
    public double getHoursWorked() {
        return hoursWorked;
    }

    // Getter for getTotalPay
    public double getTotalPay() {
        double regularPay;
        double overtimePay = 0;
        if (hoursWorked > 40) {
            regularPay = 40 * payRate;
            overtimePay = (hoursWorked - 40) * payRate * 1.5;
        } else {
            regularPay = hoursWorked * payRate;
        }
        return regularPay + overtimePay;
    }

    // Getter for getRegularHours
    public double getRegularHours() {
        return Math.min(hoursWorked, 40);
    }

    // Getter for getOvertimeHours
    public double getOvertimeHours() {
        return Math.max(0, hoursWorked - 40);
    }

    // Method to punch in
    public void punchIn(double time) {
        this.lastPunchInTime = time;
        System.out.println("Employee " + name + " punched in at " + time);
    }

    // Method to punch out
    public void punchOut(double time) {
        if (lastPunchInTime != 0) {
            double hoursWorked = time - lastPunchInTime;
            this.hoursWorked += hoursWorked;
            System.out.println("Employee " + name + " punched out at " + time + ". Hours worked: " + hoursWorked);
            this.lastPunchInTime = 0; // Reset
        } else {
            System.out.println("Employee " + name + " cannot punch out without punching in first.");
        }
    }

    //BONUS Below is the modified punchTimeCard method
    public void punchTimeCard(double time, boolean isPunchIn) {
        if (isPunchIn) {
            this.lastPunchInTime = time;
            System.out.println("Employee " + name + " punched in at " + time);
        } else {
            if (lastPunchInTime != 0) {
                double hoursWorked = time - lastPunchInTime;
                this.hoursWorked += hoursWorked;
                System.out.println("Employee " + name + " punched out at " + time + ". Hours worked: " + hoursWorked);
                this.lastPunchInTime = 0; // Reset
            } else {
                System.out.println("Employee " + name + " cannot punch out without punching in first.");
            }
        }
    }
}
