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

        room1.checkIn();
        System.out.println("Room 1 is Occupied: " + room1.isOccupied());
        System.out.println("Room 1 is Dirty: " + room1.isDirty());

        room1.checkOut();
        System.out.println("Room 1 is Occupied: " + room1.isOccupied());
        System.out.println("Room 1 is Dirty: " + room1.isDirty());

        room1.cleanRoom();
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

        employee1.punchIn(8.0); // Example: John Smith punches in at 8:00 AM
        employee1.punchOut(17.0); // Example: John Smith punches out at 5:00 PM
        System.out.println("Employee 1 Hours Worked: " + employee1.getHoursWorked());
        System.out.println("Employee 1 Total Pay: $" + employee1.getTotalPay());

        employee1.punchIn();
        employee1.punchOut();
        System.out.println("Employee 1 Hours Worked: " + employee1.getHoursWorked());
        System.out.println("Employee 1 Total Pay: $" + employee1.getTotalPay());


        Employee employee2 = new Employee(102, "Jane Doe", "Marketing", 30.00, 35.0);
        System.out.println("\nEmployee 2 ID: " + employee2.getEmployeeId());
        System.out.println("Employee 2 Name: " + employee2.getName());
        System.out.println("Employee 2 Department: " + employee2.getDepartment());
        System.out.println("Employee 2 Pay Rate: $" + employee2.getPayRate());
        System.out.println("Employee 2 Hours Worked: " + employee2.getHoursWorked());
        System.out.println("Employee 2 Total Pay: $" + employee2.getTotalPay());
        System.out.println("Employee 2 Regular Hours: " + employee2.getRegularHours());
        System.out.println("Employee 2 Overtime Hours: " + employee2.getOvertimeHours());

        // Test Hotel class
        Hotel hotel1 = new Hotel("Sunset Hotel", 10, 20);
        System.out.println("\nHotel Name: " + hotel1.getName());
        System.out.println("Available Suites: " + hotel1.getAvailableSuites());
        System.out.println("Available Rooms: " + hotel1.getAvailableRooms());

        boolean bookingResult1 = hotel1.bookRoom(2, true); // Book 2 suites
        System.out.println("Booking Result: " + bookingResult1);
        System.out.println("Available Suites: " + hotel1.getAvailableSuites());
        System.out.println("Available Rooms: " + hotel1.getAvailableRooms());

        boolean bookingResult2 = hotel1.bookRoom(5, false); // Book 5 basic rooms
        System.out.println("Booking Result: " + bookingResult2);
        System.out.println("Available Suites: " + hotel1.getAvailableSuites());
        System.out.println("Available Rooms: " + hotel1.getAvailableRooms());

        boolean bookingResult3 = hotel1.bookRoom(9, true); //try to book more suites than available
        System.out.println("Booking Result: " + bookingResult3);
        System.out.println("Available Suites: " + hotel1.getAvailableSuites());
        System.out.println("Available Rooms: " + hotel1.getAvailableRooms());
    }
}
