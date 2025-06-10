package com.pluralsight;

public abstract class Animal {

    public void eat(){
        System.out.println("Eating..");
    }

    public void sleep(){
        System.out.println("Sleeping..");
    }

    public abstract void makeSound();
}
