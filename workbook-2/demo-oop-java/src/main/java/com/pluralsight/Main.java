package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Person firstPerson = new Person("Ray", 55);
        Person secondPerson = new Person("Raymond", 15);

        System.out.println(firstPerson.getName());

//        firstPerson.setName("RayPotato");
//
//        System.out.println(firstPerson.getName());

        System.out.println(firstPerson.getEnergy());

        firstPerson.work( 5);

        System.out.println(firstPerson.getEnergy());

        firstPerson.eat(3);

        System.out.println(firstPerson.getEnergy());



    }
}
