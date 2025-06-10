package com.pluralsight;

public class Dog extends Pet{

    public Dog(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println(getName() + "fetches ball");

    }

    @Override
    public void makeSound() {
        System.out.println("woof");

    }
}
