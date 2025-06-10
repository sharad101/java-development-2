package com.pluralsight;

public class Hotel {
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    // Constructor with only number of suites and rooms
    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }

    // Constructor with all parameters
    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for getAvailableSuites
    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }

    // Getter for getAvailableRooms
    public int getAvailableRooms() {
        return numberOfRooms - bookedBasicRooms;
    }

    // Method to book rooms
    public boolean bookRoom(int numberOfRooms, boolean isSuite) {
        if (isSuite) {
            if (getAvailableSuites() >= numberOfRooms) {
                bookedSuites += numberOfRooms;
                System.out.println(numberOfRooms + " suites booked.");
                return true;
            } else {
                System.out.println("Not enough suites available. Available suites: " + getAvailableSuites());
                return false;
            }
        } else {
            if (getAvailableRooms() >= numberOfRooms) {
                bookedBasicRooms += numberOfRooms;
                System.out.println(numberOfRooms + " basic rooms booked.");
                return true;
            } else {
                System.out.println("Not enough basic rooms available. Available basic rooms: " + getAvailableRooms());
                return false;
            }
        }
    }
}
