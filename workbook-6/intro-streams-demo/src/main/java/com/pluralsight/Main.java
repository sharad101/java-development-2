package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Order> allOrders = new ArrayList<>();

        Order order1 = new Order(123, "Ray");
        order1.addItem(new LineItem(11, 2, 12, "Apples"));
        order1.addItem(new LineItem(12, 4, 15, "Oranges"));
        allOrders.add(order1);

        Order order2 = new Order(126, "Raymond");
        order2.addItem(new LineItem(13, 6, 10, "Fries"));
        order2.addItem(new LineItem(17, 8, 9, "Cake"));
        allOrders.add(order2);

        Order order3 = new Order(332, "Potato Sensei");
        order3.addItem(new LineItem(23, 11, 20, "Water"));
        order3.addItem(new LineItem(24, 14, 25, "Butter"));
        allOrders.add(order3);

        List<Order> impulseOrders = new ArrayList<>();

        for (Order order : allOrders) {
            if(order.getTotal() < 25){
                impulseOrders.add(order);
            }
        }

        for (Order impulseOrder : impulseOrders) {
            System.out.println(impulseOrder);
            
        }

        double salesAllTotalAllOrder = 0;

        for (Order order : allOrders) {
            salesAllTotalAllOrder += order.getTotal();
            
        }
        System.out.println("Total: $" + salesAllTotalAllOrder);
    }
}
