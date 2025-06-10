package com.pluralsight;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> statesAndCapitals = new HashMap<>();
        statesAndCapitals.put("CT", "Hartford");
        statesAndCapitals.put("CA", "Sacramento");
        statesAndCapitals.put("WA", "Olympia");
        statesAndCapitals.put("TX", "Austin");
        statesAndCapitals.put("FL", "Tallahassee");

        System.out.println(statesAndCapitals);

        System.out.println("the capital of texas is: ");
        System.out.println(statesAndCapitals.get("TX"));

/*        statesAndCapitals.remove("WA");
        System.out.println(statesAndCapitals);

 */
        System.out.println("===============================");

        for (String value : statesAndCapitals.values()){
            System.out.println(value);
        }

        System.out.println("===============================");

        for (String value : statesAndCapitals.keySet()){
            System.out.println(key);
        }


    }
}
