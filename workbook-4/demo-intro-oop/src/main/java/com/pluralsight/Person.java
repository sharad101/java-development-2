package com.pluralsight;

public class Person {
    //Attributes
    private String firstName;
    private String lastName;
    private int age;

    //Constructor


    //Getters and Setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //Derived Getter
    public String getFullName(){
        return firstName + " " + lastName;
    }
}
