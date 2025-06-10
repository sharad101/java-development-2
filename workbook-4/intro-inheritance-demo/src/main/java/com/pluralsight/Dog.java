package com.pluralsight;

public class Dog extends Animal {
    private String breed;


//    public Dog(String name, String breed){
//        super(name);
//        this.breed= breed;
//
//    }


    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void bark(){
        System.out.println(" bark bark");
    }


    // One way to access getName from Animal class cz from Animal class the String name is private
//    public void bark(){
//        System.out.println(getName() + " bark bark");
//    }

    // Another way to directly access is when/ or if we use protected for the variable/attribute
    // dont need to call the getter method
//    public void bark(){
//        System.out.println(name + " bark bark");
//    }


}
