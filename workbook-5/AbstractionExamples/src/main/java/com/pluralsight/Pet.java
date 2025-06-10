package com.pluralsight;

public abstract class Pet extends Animal {
    private String name;

    public Pet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void play();

    public abstract void makeSound();
}
