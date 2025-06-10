package com.pluralsight;

public class Reservation {
    private String roomType;
    private int numberOfNights;
    private boolean isWeekend;

    // Constructor for Reservation
    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    // Getter for roomType
    public String getRoomType() {
        return roomType;
    }

    // Setter for roomType
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    // Getter for getPrice
    public double getPrice() {
        double pricePerNight;
        if (roomType.equalsIgnoreCase("king")) {
            pricePerNight = 139.00;
        } else if (roomType.equalsIgnoreCase("double")) {
            pricePerNight = 124.00;
        } else {
            return 0.0; // Invalid room type
        }

        if (isWeekend) {
            pricePerNight *= 1.10; // Increase by 10%
        }
        return pricePerNight;
    }

    // Getter for numberOfNights
    public int getNumberOfNights() {
        return numberOfNights;
    }

    // Setter for numberOfNights
    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    // Getter for isWeekend
    public boolean isWeekend() {
        return isWeekend;
    }

    // Setter for isWeekend
    public void setIsWeekend(boolean weekend) {
        isWeekend = weekend;
    }

    // Getter for getReservationTotal
    public double getReservationTotal() {
        return getPrice() * numberOfNights;
    }
}
