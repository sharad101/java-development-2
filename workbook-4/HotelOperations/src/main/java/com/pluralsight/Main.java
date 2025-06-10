package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        // Test Room class
        Room room1 = new Room(2, 120.00);
        System.out.println("Room 1 Number of Beds: " + room1.getNumberOfBeds());
        System.out.println("Room 1 Price: $" + room1.getPrice());
        System.out.println("Room 1 is Occupied: " + room1.isOccupied());
        System.out.println("Room 1 is Dirty: " + room1.isDirty());
        System.out.println("Room 1 is Available: " + room1.isAvailable());

        room1.setOccupied(true);
        room1.setDirty(true);
        System.out.println("\nAfter setting room 1 to occupied and dirty:");
        System.out.println("Room 1 is Occupied: " + room1.isOccupied());
        System.out.println("Room 1 is Dirty: " + room1.isDirty());
        System.out.println("Room 1 is Available: " + room1.isAvailable());

        // Test Reservation class
        Reservation reservation1 = new Reservation("king", 3, true);
        System.out.println("\nReservation 1 Room Type: " + reservation1.getRoomType());
        System.out.println("Reservation 1 Price per night: $" + reservation1.getPrice());
        System.out.println("Reservation 1 Number of Nights: " + reservation1.getNumberOfNights());
        System.out.println("Reservation 1 is Weekend: " + reservation1.isWeekend());
        System.out.println("Reservation 1 Total Price: $" + reservation1.getReservationTotal());

        reservation1.setRoomType("double");
        reservation1.setNumberOfNights(2);
        reservation1.setIsWeekend(false);
        System.out.println("\nAfter updating reservation 1:");
        System.out.println("Reservation 1 Room Type: " + reservation1.getRoomType());
        System.out.println("Reservation 1 Price per night: $" + reservation1.getPrice());
        System.out.println("Reservation 1 Number of Nights: " + reservation1.getNumberOfNights());
        System.out.println("Reservation 1 is Weekend: " + reservation1.isWeekend());
        System.out.println("Reservation 1 Total Price: $" + reservation1.getReservationTotal());

        // Test Employee class
        Employee employee1 = new Employee(101, "John Smith", "Sales", 25.00, 45.0);
        System.out.println("\nEmployee 1 ID: " + employee1.getEmployeeId());
        System.out.println("Employee 1 Name: " + employee1.getName());
        System.out.println("Employee 1 Department: " + employee1.getDepartment());
        System.out.println("Employee 1 Pay Rate: $" + employee1.getPayRate());
        System.out.println("Employee 1 Hours Worked: " + employee1.getHoursWorked());
        System.out.println("Employee 1 Total Pay: $" + employee1.getTotalPay());
        System.out.println("Employee 1 Regular Hours: " + employee1.getRegularHours());
        System.out.println("Employee 1 Overtime Hours: " + employee1.getOvertimeHours());

        Employee employee2 = new Employee(102, "Jane Doe", "Marketing", 30.00, 35.0);
        System.out.println("\nEmployee 2 ID: " + employee2.getEmployeeId());
        System.out.println("Employee 2 Name: " + employee2.getName());
        System.out.println("Employee 2 Department: " + employee2.getDepartment());
        System.out.println("Employee 2 Pay Rate: $" + employee2.getPayRate());
        System.out.println("Employee 2 Hours Worked: " + employee2.getHoursWorked());
        System.out.println("Employee 2 Total Pay: $" + employee2.getTotalPay());
        System.out.println("Employee 2 Regular Hours: " + employee2.getRegularHours());
        System.out.println("Employee 2 Overtime Hours: " + employee2.getOvertimeHours());

    }
}
