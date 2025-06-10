package com.pluralsight;

public class main3 {
    public static void main(String[] args) {
        String[] colors ={"red", "blue", "green"};
        String[] copy = new String[3];

//        copy = colors;

        System.arraycopy(colors, 0, copy, 0, 3);

//        System.out.println("Colors:");
//        for (String color : colors) {
//            System.out.println(color);
//        }
//
//        System.out.println("======================");

        colors[1] = "black";

        System.out.println("Copy:");
        for (String copyElement : copy) {
            System.out.println(copyElement);
        }

        System.out.println("======================");
    }
}
