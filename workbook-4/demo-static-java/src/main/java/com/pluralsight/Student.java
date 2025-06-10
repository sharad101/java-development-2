package com.pluralsight;

public class Student {

    private static String schoolName = "Greenwood High";

    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public void printDetails(){
        System.out.println(name + " | grade" + grade + " | " + schoolName);
    }

    public static void changeSchool (String newName){
        schoolName = newName;
    }
}
