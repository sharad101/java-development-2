package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Student alice = new Student("alice", 10);
        Student bob = new Student("bob", 9);

        alice.printDetails();
        bob.printDetails();

        System.out.println("=====================");

        alice.printDetails();
        bob.printDetails();

    }
}
