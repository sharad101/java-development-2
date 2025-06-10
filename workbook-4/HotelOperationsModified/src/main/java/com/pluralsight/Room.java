package com.pluralsight;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;

    // Constructor for Room
    public Room(int numberOfBeds, double price) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isOccupied = false;
        this.isDirty = false;
    }

    // Getter for numberOfBeds
    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    // Getter for isOccupied
    public boolean isOccupied() {
        return isOccupied;
    }

    // Getter for isDirty
    public boolean isDirty() {
        return isDirty;
    }

    // Getter for isAvailable
    public boolean isAvailable() {
        return !isOccupied && !isDirty;
    }

    // Method to set room occupancy status
    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    // Method to set room dirty status
    public void setDirty(boolean dirty) {
        isDirty = dirty;
    }

    // Method to check in a guest
    public void checkIn() {
        if (isAvailable()) {
            isOccupied = true;
            isDirty = true; // Room becomes dirty after check-in
            System.out.println("Room " + numberOfBeds + " is checked in.");
        } else {
            System.out.println("Room " + numberOfBeds + " is not available for check-in.");
        }
    }

    // Method to check out a guest
    public void checkOut() {
        if (isOccupied) {
            isOccupied = false;
            System.out.println("Room " + numberOfBeds + " is checked out.");
        } else {
            System.out.println("Room " + numberOfBeds + " is not occupied.");
        }
    }

    // Method to clean the room
    public void cleanRoom() {
        if (isDirty) {
            isDirty = false;
            System.out.println("Room " + numberOfBeds + " is cleaned.");
        } else {
            System.out.println("Room " + numberOfBeds + " is already clean.");
        }
    }
}
