package com.pluralsight;

public class House extends Asset {
    private String address;
    private int squareFeet;
    private int lotSize;

    public House(String description, int yearAcquired, int originalCost, String address, int squareFeet, int lotSize) {
        super(description, yearAcquired, originalCost);
        this.address = address;
        this.squareFeet = squareFeet;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    public int getLotSize() {
        return lotSize;
    }

    public int getSquareFeet() {
        return squareFeet;
    }

    @Override
    public double getValue() {
        return (180 * squareFeet) + (.25 * lotSize);
    }

    @Override
    public void drive(){
        super.drive();
        System.out.println(" test potato");
    }
}







