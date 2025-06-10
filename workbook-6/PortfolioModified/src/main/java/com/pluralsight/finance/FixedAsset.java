package com.pluralsight.finance;

public abstract class FixedAsset implements Valuable {
    protected String name;
    protected double marketValue;


    public FixedAsset(String name, double value) {
        this.name = name;
        this.marketValue = value;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public String getName() {
        return name;
    }

    //public abstract double getValue();
}
