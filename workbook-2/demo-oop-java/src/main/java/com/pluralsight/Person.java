package com.pluralsight;

public class Person {
    private String name;
    private int age;
    private int energy;


    //Constructor
    public Person(String name, int age){
        this.name = name;
        this.age = age;
        this.energy = 100;
    }

    //Getter and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //Actions
    public void work(int hours){
        this.energy -= (hours * 10);

    }

    public void sleep(int hours) {
        this.energy += (hours * 10);
    }

    public void eat(int hours) {
        this.energy += (hours * 10);

    }

    public int getEnergy() {
        return energy;
    }
}
