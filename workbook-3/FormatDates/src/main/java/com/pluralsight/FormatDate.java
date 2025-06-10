package com.pluralsight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDate {
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();

        // Format: 09/05/2021
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = now.format(format1);
        System.out.println("1. " + date1);

        //Format: 2021-09-05
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date2 = now.format(format2);
        System.out.println("2. " + date2);

        //Format: September 5, 2021
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        String date3 = now.format(format3);
        System.out.println("3. " + date3);

        //Format: Sunday, Sep 5, 2021 10:02 (GMT Time)
        ZonedDateTime gmtNow = ZonedDateTime.now(ZoneId.of("GMT"));
        DateTimeFormatter format4 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm");
        String date4 = gmtNow.format(format4);
        System.out.println("4. " + date4 + " GMT");

        //5:02 on 05-Sep-2021 (Local Time)
        DateTimeFormatter format5 = DateTimeFormatter.ofPattern("H:mm 'on' dd-MMM-yyyy");
        String date5 = now.format(format5);
        System.out.println("5. " + date5);


    }
}
