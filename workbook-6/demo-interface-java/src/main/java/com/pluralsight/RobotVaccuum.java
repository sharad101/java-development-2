package com.pluralsight;

import java.awt.*;

public class RobotVaccuum implements IMovable, ICleaner {
    private String name;
    private Point currentlocation;
    private int power;

    public RobotVaccuum(String name) {
        this.name = name;
        this.currentlocation = new Point(0, 0);
        this.power= 100;
    }

    public String getName() {
        return name;
    }

    public Point getCurrentlocation() {
        return currentlocation;
    }

    public int getPower() {
        return power;
    }

    public Point move(int xUnits, int yUnits){
        int biggestUnit = Math.max(xUnits, yUnits);

        if (power >= biggestUnit){
            currentlocation = new Point(currentlocation.x + xUnits, currentlocation.y + yUnits);
            power  -= biggestUnit;

        } else{
            System.out.println("Not enough power to move");
        }

        return currentlocation;


    }



    @Override
    public void goHome() {
        this.currentlocation = new Point(0, 0);
        System.out.println("Robo vaccum returning home");

    }

    @Override
    public void print() {
        IMovable.super.print();
        ICleaner.super.print();

    }

    @Override
    public void clean(){
        System.out.println("Robo vaccum is cleaning");
    }
}
