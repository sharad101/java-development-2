package com.pluralsight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Emily", "Carter", 25),
                new Person("James", "Smith", 32),
                new Person("Olivia", "Johnson", 21),
                new Person("Michael", "Williams", 45),
                new Person("Sophia", "Brown", 29),
                new Person("William", "Jones", 60),
                new Person("Isabella", "Garcia", 33),
                new Person("Benjamin", "Miller", 27),
                new Person("Ava", "Davis", 52),
                new Person("Alexander", "Wilson", 19)
        );

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a first or last name to search: ");
        String searchName = scanner.nextLine().trim();

        List<Person> matchedPeople = searchByName(people, searchName);

        System.out.println("\n--- Search Results ---");
        if (matchedPeople.isEmpty()) {
            System.out.println("No matches found for: " + searchName);
        } else {
            for (Person p : matchedPeople) {
                System.out.println(p);
            }
        }

        System.out.println("\n--- Age Statistics ---");
        System.out.printf("Average Age: %.2f\n", calculateAverageAge(people));
        System.out.println("Oldest Person: " + findOldest(people));
        System.out.println("Youngest Person: " + findYoungest(people));

        scanner.close();
    }

    public static List<Person> searchByName(List<Person> people, String name) {
        List<Person> result = new ArrayList<>();
        for (Person p : people) {
            if (p.getFirstName().equalsIgnoreCase(name) || p.getLastName().equalsIgnoreCase(name)) {
                result.add(p);
            }
        }
        return result;
    }

    public static double calculateAverageAge(List<Person> people) {
        int total = 0;
        for (Person p : people) {
            total += p.getAge();
        }
        return (double) total / people.size();
    }

    public static Person findOldest(List<Person> people) {
        Person oldest = people.get(0);
        for (Person p : people) {
            if (p.getAge() > oldest.getAge()) {
                oldest = p;
            }
        }
        return oldest;
    }

    public static Person findYoungest(List<Person> people) {
        Person youngest = people.get(0);
        for (Person p : people) {
            if (p.getAge() < youngest.getAge()) {
                youngest = p;
            }
        }
        return youngest;
    }
}

