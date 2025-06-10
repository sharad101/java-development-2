package com.pluralsight;

public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    //    public Animal() {
//        System.out.println("Im in the Animal constructor");
//    }

    // Use protected to have direct access within the Dog class
   // protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
