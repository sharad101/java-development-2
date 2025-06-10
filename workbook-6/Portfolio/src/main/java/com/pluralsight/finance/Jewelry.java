package com.pluralsight.finance;

public class Jewelry extends FixedAsset {
    private double karat;


    public Jewelry(String name, double karat) {
        super(name, 0);
        this.karat = karat;
    }

    public double getKarat() {
        return karat;
    }

    private static double calculateValue(double karat) {
        // Simple calculation: higher karat = higher value
        return karat * 1000;
    }


    @Override
    public double getValue() {
        return marketValue;
    }
}
