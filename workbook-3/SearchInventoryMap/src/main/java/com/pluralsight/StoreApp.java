package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class StoreApp {


    //static HashMap<Integer, Product> inventory = new HashMap<>();

    public static void main(String[] args) {
        HashMap<Integer, Product> inventory = loadInventory();

        Scanner scanner = new Scanner(System.in);

        System.out.println("What item # are you interested in? ");
        int id = scanner.nextInt();

        Product matchedProduct = inventory.get(id);
        if (matchedProduct == null){
            System.out.println("We dont carry the product");
        }else {
            System.out.println("We carry %s and the price is %.2f\n",
                    matchedProduct.getName(), matchedProduct.getPrice());


        }

    }

        public static HashMap<Integer, Product> loadInventory(){
        HashMap<Integer, Product> inventory = new HashMap<>();

        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader("inventory.csv"));
            while((line = br.readLine()) != null){
                String[] parts = line.split("\\|");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                inventory.put(id, new Product(id, name, price));
            }
        }catch ( Exception e){
            e.printStackTrace();
        }

        return inventory;
    }
}
