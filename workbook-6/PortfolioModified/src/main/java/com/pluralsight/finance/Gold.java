package com.pluralsight.finance;

public class Gold extends FixedAsset {
    private double weight;

    public Gold(double weight) {
        super("Gold", 0);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }


    private static double calculateValue(double weight) {
        double goldPricePerOunce = 1800.0; // Example price
        return weight * goldPricePerOunce;
    }


    @Override
    public double getValue() {
        return marketValue;
    }
}
