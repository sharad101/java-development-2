package com.pluralsight;

public class House extends Asset {
    private String address;
    private int condition; // 1-excellent, 2-good, 3-fair, 4-poor
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, double originalCost, String address, int lotSize, int squareFoot, int condition) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.lotSize = lotSize;
        this.squareFoot = squareFoot;
        this.condition = condition;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    // Override getValue method
    @Override
    public double getValue() {
        double pricePerSquareFoot = 0.0;

        // Determine price per square foot based on condition
        switch (condition) {
            case 1: // Excellent
                pricePerSquareFoot = 180.0;
                break;
            case 2: // Good
                pricePerSquareFoot = 130.0;
                break;
            case 3: // Fair
                pricePerSquareFoot = 90.0;
                break;
            case 4: // Poor
                pricePerSquareFoot = 80.0;
                break;
            default:
                pricePerSquareFoot = 90.0; // Default to fair if invalid condition
        }

        // Calculate house value: price per square foot + lot value
        double houseValue = (squareFoot * pricePerSquareFoot) + (lotSize * 0.25);

        return houseValue;
        }
}
