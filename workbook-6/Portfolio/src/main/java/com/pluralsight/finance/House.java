package com.pluralsight.finance;

public class House extends FixedAsset {
    private int yearBuilt;
    private int squareFeet;
    private int bedrooms;

    public House(int year, int squareFeet, int bedrooms) {
        super("House", calculateValue(year, squareFeet, bedrooms));
        this.yearBuilt = year;
        this.squareFeet = squareFeet;
        this.bedrooms = bedrooms;
    }


    public int getYearBuilt() {
        return yearBuilt;
    }

    public int getSquareFeet() {
        return squareFeet;
    }

    public int getBedrooms() {
        return bedrooms;
    }


    private static double calculateValue(int year, int squareFeet, int bedrooms) {
        double baseValue = squareFeet * 200;
        int age = 2025 - year;
        double ageFactor = Math.max(0.5, 1 - (age * 0.01));
        double bedroomBonus = bedrooms * 10000;

        return (baseValue * ageFactor) + bedroomBonus;
    }

    @Override
    public double getValue() {
        return marketValue;
    }

}
