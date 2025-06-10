package com.pluralsight;

public class Cat extends Pet {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println(getName() + "chase laser pointer");
    }

    @Override
    public void makeSound() {
        System.out.println("Meow");

    }
}
