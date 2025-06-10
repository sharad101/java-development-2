package com.pluralsight;

import java.util.Arrays;
import java.util.Collections;

public class Main2 {
    public static void main(String[] args) {
        String[] namelist = { "Nat", "Zach", "Matthew", "Ian", "Erza", "Elisha"};

        for (int i = 0; i < namelist.length; i++) {
            System.out.println(namelist[i]);
            
        }

        System.out.println("===================");


        for(String name: namelist){
            System.out.println(name);
        }

        System.out.println("===================");

        Arrays.sort(namelist);

        for (String name : namelist) {
            System.out.println(name);
        }

        System.out.println("===================");

        Arrays.sort(namelist, Collections.reverseOrder());

        for (String name : namelist) {
            System.out.println(name);
        }



    }
}
