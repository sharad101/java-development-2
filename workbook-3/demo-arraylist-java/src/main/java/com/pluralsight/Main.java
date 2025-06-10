package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        //ArrayList<Integer> num = new ArrayList<>();
        List<Integer> num = new ArrayList<>();

        List<String> kids = new ArrayList<>();

        kids.add("natalie");
        kids.add("zachary");
        kids.add("brittany");

//        for (String kid : kids) {
//            System.out.println(kid);
//
//        }

        for (int i = 0; i < kids.size(); i++) {
            System.out.println(kids.get(i));
            
        }

        System.out.println("===========================");

        kids.set(2, "Bob");

        for (int i = 0; i < kids.size(); i++) {
            System.out.println(kids.get(i));

        }

        System.out.println("===========================");

        Collections.sort(kids);
        for (int i = 0; i < kids.size(); i++) {
            System.out.println(kids.get(i));

        }

        System.out.println("===========================");

        Collections.sort(kids, Collections.reverseOrder());



    }
}
