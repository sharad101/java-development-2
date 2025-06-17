package com.pluralsight;

import com.pluralsight.db.DataManager;
import com.pluralsight.models.CustomerOderHistory;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DataManager dataManager = new DataManager("jdbc:mysql://localhost:3306/northwind", "root", "yearup24");

        System.out.println("Enter customerId: ");
        String customerId = scanner.nextLine();

        List<CustomerOderHistory> orderHistoryList = dataManager.searchCustomerOrderHistory()


    }
}
