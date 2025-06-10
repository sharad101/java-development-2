package com.pluralsight;

public class Main {
    public static void main(String[] args) {
     /*   String welcome = "Big Tex \nsays 'Howdy' ";
        System.out.println(welcome);


      */


        String fullName = "Raymond Maroun";
        int length = fullName.length();
        System.out.println(length);

        System.out.println("=======================");

        String username = "   danaw";
        System.out.println(username);

        String trimmedUsername = username.trim();
        System.out.println(trimmedUsername);

        System.out.println("=======================");

        String name = "raymond";
        String Upername = name.toUpperCase();
        System.out.println(Upername);

        System.out.println("=======================");

        String instructor  = "    raymond     ";
        System.out.println(instructor.trim().toUpperCase());

        System.out.println("=======================");

        String secondName = "Raymond";
        if (secondName.startsWith("Ray")) {
            System.out.println("Print true");
        }

        System.out.println("=======================");

        String code = " SAVE-50";
        if (secondName.endsWith("-50")) {
            System.out.println("Print true");
        }


        System.out.println("=======================");

        String product = " chips";

        char letter = product.charAt(1);
        System.out.println(letter);


        System.out.println("=======================");

        String productCode = " ACME-123221";

        int dashPosition = productCode.indexOf("-");
        System.out.println(dashPosition);

        System.out.println("=======================");

        String teacherName = "Raymond";

        String substring = teacherName.substring(0, 3);

        System.out.println(substring);


    }
}
