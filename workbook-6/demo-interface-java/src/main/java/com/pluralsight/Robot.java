package com.pluralsight;

import java.awt.*;

public class Robot implements IMovable {
    private String name;
    private Point currentLocation;
    private int power;

    public Robot(String name) {
        this.name = name;
        this.currentLocation = new Point(0, 0);
        this.power = 100;
    }

    public String getName() {
        return name;
    }

    public Point getCurrentLocation() {
        return currentLocation;
    }

    public int getPower() {
        return power;
    }
}
