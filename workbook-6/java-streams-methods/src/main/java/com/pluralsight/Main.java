package com.pluralsight;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // filter
        System.out.println("Filter Method");
        System.out.println();

        List<String> titles = Arrays.asList(
                "Halloween", "Ghost", "Halloween 2",
                "Friday the 13th", "Twister", "Halloween 3");

//        List<String> matching = titles
//                .stream().filter(title -> title.toLowerCase().contains("halloween"))
//                .collect(Collectors.toList());
//
//        matching.forEach(matchingTitle -> System.out.println(matchingTitle));

        titles
                .stream().filter(title -> title.toLowerCase().contains("halloween"))
                .collect(Collectors.toList())
                .forEach(matchingTitle -> System.out.println(matchingTitle));


        System.out.println("===============================================");

        // count
        System.out.println("Count Method");
        System.out.println();


        List<String> titles2 = Arrays.asList(
                "Halloween", "Ghost", "Halloween 2",
                "Friday the 13th", "Twister", "Halloween 3");

        long count = titles2
                .stream().filter(title -> title.toLowerCase().contains("halloween"))
                .count();

        System.out.println("count is " + count);

        System.out.println("===============================================");

        //forEach() method

        System.out.println("forEach Method");
        System.out.println();


        List<String> titles3 = Arrays.asList(
                "Halloween", "Ghost", "Halloween 2",
                "Friday the 13th", "Twister", "Halloween 3");

        titles3
                .stream().filter(title -> title.toLowerCase().contains("halloween"))
                .toList()
                .forEach(System.out::println);



        System.out.println("===============================================");

        //sorted method

        System.out.println("sorted Method");
        System.out.println();


        List<String> titles4 = Arrays.asList(
                "Halloween", "Ghost", "Halloween 2",
                "Friday the 13th", "Twister", "Halloween 3");

        titles4
                .stream().filter(title -> title.toLowerCase().contains("halloween"))
                .sorted()
                //.sorted(Comparator.reverseOrder()) if you want reverse order
                .forEach(System.out::println);

        System.out.println("===============================================");

        //map method

        System.out.println("map Method");
        System.out.println();

        List<Integer> numbers = Arrays.asList(3, 2, 3, 4 ,5, 6);

//        List<Integer> squares = new ArrayList<>();
//
//        for (Integer number : numbers) {
//            squares.add(number * number);
//
//        }

        System.out.println(numbers);
//        System.out.println(squares);

        List<Integer> squares =
                numbers.stream()
                        .map(num -> num * num)
                        .toList();



        System.out.println(numbers);
        System.out.println(squares);

        System.out.println("===============================================");

        List<String> names = Arrays.asList("alice", "bob", "david");

        List<String> upperCaseNames =
                names.stream()
                        .map(name -> name.toUpperCase())
                        .toList();

        System.out.println("original list: " + names);
        System.out.println("uppercase list" + upperCaseNames);

        System.out.println("===============================================");

        //reduce method

        System.out.println("reduce Method");
        System.out.println();

        List<Integer> numbers2 = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        int sum =
                numbers2.stream()
                        .reduce(0, // intial value of temp (temp = 0)
                                (temp, num) -> temp + num);


        System.out.println("sum is " + sum);

        System.out.println("===============================================");

        List<Integer> numbers3 = Arrays.asList(1, 2, 3,4);

        int product = numbers3.stream()
                .reduce(1,
                        ( temp, num) -> temp * num);

        System.out.println("product is" + product);

        System.out.println("===============================================");

        List<String> words = Arrays.asList("Potatos", "are", "awesome");

        String sentence = words.stream()
                .reduce("",
                        (acc, word)-> acc + word + " ");

        System.out.println("the original words: " + words);
        System.out.println("Combined sentence: " + sentence.trim());





    }

}
