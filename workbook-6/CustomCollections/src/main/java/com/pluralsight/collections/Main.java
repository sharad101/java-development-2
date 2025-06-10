package com.pluralsight.collections;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        FixedList<Integer> numbers = new FixedList<>(3);
        numbers.add(10);
        numbers.add(3);
        numbers.add(92);
        numbers.add(43); // this line should fail
        System.out.println("Size of numbers list: " + numbers.getItems().size());

        System.out.println("\nTesting FixedList<LocalDate>:");
        FixedList<LocalDate> dates = new FixedList<>(2);
        dates.add(LocalDate.now());
        dates.add(LocalDate.now());
        //dates.add(15);
    }

}
