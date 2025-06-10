package com.pluralsight;

public abstract class Asset {
    private String description;
    private int yearAcquired;
    private int originalCost;

    public Asset(String description, int yearAcquired, int originalCost) {
        this.description = description;
        this.yearAcquired = yearAcquired;
        this.originalCost = originalCost;
    }

    public String getDescription() {
        return description;
    }
    public int getYearAcquired() {
        return yearAcquired;
    }
//    public double getValue() {
//        return originalCost;
//    }

    public abstract double getValue();

    public void drive(){
        System.out.println("potato");
    }

}
