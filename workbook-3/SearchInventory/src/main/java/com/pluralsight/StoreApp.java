package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StoreApp {
    public static void main(String[] args) {

        List<Product> inventory = getInventory("inventory.csv");

        listAllProducts(inventory);

        // Sort by product name
        Collections.sort(inventory, Product.sortByName());


        System.out.println("We carry the following inventory: ");
        for (Product product : inventory) {
            System.out.println(product);
            
        }
    }

    public static List<Product> getInventory(String filename){
        List<Product> inventory = new ArrayList<>();
        //put code here
//        inventory.add(new Product(1,"Shirt", 19.99));
//        inventory.add(new Product(2,"Hat", 12.99));
//        inventory.add(new Product(3,"Shoes", 13.99));
//        inventory.add(new Product(4,"Pant", 14.99));
//        inventory.add(new Product(5,"Socks", 15.99));

        //Bonus1
        try (BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    inventory.add(new Product(id, name, price));
                }
            }
        } catch (Exception e){
        System.err.println("An error has occurred");
    }

        return inventory;
    }

    public static void ListAllProducts(List<Product> productList){
        System.out.println("We carry the following inventory: ");
        for (Product product : productList) {
            System.out.println(product);

        }

    }
}
