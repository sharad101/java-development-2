package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Today's date " + today);
        System.out.println("Day of week " + today.getDayOfWeek());
        System.out.println("Day of month " + today.getDayOfMonth());
        System.out.println("Day of year " + today.getDayOfYear());
        System.out.println("Month Name " + today.getMonth());
        System.out.println("Month Value " + today.getMonthValue());
        System.out.println("Year " + today.getYear());


        System.out.println("=========================");

        LocalTime currentTime = LocalTime.now();
        System.out.println("Time is " + currentTime);
        System.out.println("Hour is " + currentTime.getHour());
        System.out.println("Minute is " + currentTime.getMinute());
        System.out.println("Second is " + currentTime.getSecond());
        System.out.println("Nanosecond is " + currentTime.getNano());


        System.out.println("=========================");

        LocalDateTime rightNow = LocalDateTime.now();
        System.out.println("Date and Time is " + rightNow);

        System.out.println("=========================");

        String userInput = "10/7/2025";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");


        LocalDate newDate = LocalDate.parse(userInput, dateTimeFormatter);
        System.out.println(newDate);

        System.out.println("=========================");

        LocalDateTime currentDate = LocalDateTime.now();
        System.out.println("Today is " + currentDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MM, dd, yyyy HH:mm:ss");
        String formattedDate = currentDate.format(formatter);

        System.out.println("Today is " + formattedDate);










    }
}
