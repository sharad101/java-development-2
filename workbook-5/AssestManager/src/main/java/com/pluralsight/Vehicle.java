package com.pluralsight;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    // Constructor
    public Vehicle(String description, String dateAcquired, double originalCost,
                   String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    // Getters and Setters
    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    // Override getValue method
    @Override
    public double getValue() {
        // Calculate current year (statically set for academic example)
        int currentYear = 2025;
        int age = currentYear - year;
        double value = getOriginalCost();

        // Determine depreciation based on age
        if (age <= 3) {
            // 0-3 years old - 3% reduced value of cost per year
            value = value * Math.pow(0.97, age);
        } else if (age <= 6) {
            // 4-6 years old - 6% reduced value of cost per year
            value = value * Math.pow(0.94, age);
        } else if (age <= 10) {
            // 7-10 years old - 8% reduced value of cost per year
            value = value * Math.pow(0.92, age);
        } else {
            // over 10 years old - $1000.00
            value = 1000.00;
        }

        // MINUS reduce final value by 25% if over 100,000 miles
        // unless makeModel contains word Honda or Toyota
        if (odometer > 100000 &&
                !makeModel.toLowerCase().contains("honda") &&
                !makeModel.toLowerCase().contains("toyota")) {
            value = value * 0.75;
        }

        return value;
    }

}
