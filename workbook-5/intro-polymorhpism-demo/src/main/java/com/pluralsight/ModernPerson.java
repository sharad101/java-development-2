package com.pluralsight;

public class ModernPerson extends Human{
    private int tiktokUsage;
    private int stressLevel;

    public ModernPerson(String name, int age, int tiktokUsage, int stressLevel) {
        super(name, age);
        this.tiktokUsage = tiktokUsage;
        this.stressLevel = stressLevel;
    }

    public int getTiktokUsage() {
        return tiktokUsage;
    }

    public void setTiktokUsage(int tiktokUsage) {
        this.tiktokUsage = tiktokUsage;
    }

    public int getStressLevel() {
        return stressLevel;
    }

    public void setStressLevel(int stressLevel) {
        this.stressLevel = stressLevel;
    }

    @Override
    public void eat() {
        System.out.println("I want chipotle");
    }

    public void drive(){
        System.out.println("I drive car");
    }
}
