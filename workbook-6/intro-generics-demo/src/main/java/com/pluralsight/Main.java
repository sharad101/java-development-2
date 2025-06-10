package com.pluralsight;

public class Main {
    public static void main(String[] args) {

        Pair<Integer> twoNums = new Pair<>(63, 67);
        System.out.println(twoNums.getLeftThing());
        twoNums.swap();
        System.out.println(twoNums.getLeftThing());

        System.out.println("===========================");

        Pair<String> twoWords = new Pair<>("me", "you");
        System.out.println(twoWords.getLeftThing());
        twoWords.swap();
        System.out.println(twoWords.getLeftThing());

        System.out.println("===========================");

        displayWithLabel("Name", "Raymond");
        displayWithLabel("Age", 55);

        System.out.println("===========================");

        Pair<Muscian> duets = new Pair<>(new Cellist("ray","cello"), new Violinst("drew", "violion"));

    }

//    private static void displayWithLabel(String label, String value){
//        System.out.println(label + ": " + value);
//
//    }
//
//    private static void displayWithLabel(String label, int value){
//        System.out.println(label + ": " + value);
//
//    }

    private static <T> void displayWithLabel(String label, T value){
        System.out.println(label + ": " + value);

    }

    //If you want to return T
//    private static <T>  displayWithLabel(String label, T value){
//        return value;
//
//    }
}
