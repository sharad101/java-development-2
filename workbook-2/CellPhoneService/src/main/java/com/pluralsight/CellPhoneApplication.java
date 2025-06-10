package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CellPhone myPhone = new CellPhone();
        

        // Prompt the user for cell phone information
        System.out.print("What is the serial number? ");
        myPhone.setSerialNumber(scanner.nextInt());
        // Consume the newline
        scanner.nextLine();

        System.out.print("What model is the phone? ");
        myPhone.setModel(scanner.nextLine());

        System.out.print("Who is the carrier? ");
        myPhone.setCarrier(scanner.nextLine());

        System.out.print("What is the phone number? ");
        myPhone.setPhoneNumber(scanner.nextLine());

        System.out.print("Who is the owner of the phone? ");
        myPhone.setOwner(scanner.nextLine());


        System.out.println("\nPhone Details:");
        System.out.println("Serial Number: " + myPhone.getSerialNumber());
        System.out.println("Model: " + myPhone.getModel());
        System.out.println("Carrier: " + myPhone.getCarrier());
        System.out.println("Phone Number: " + myPhone.getPhoneNumber());
        System.out.println("Owner: " + myPhone.getOwner());

        scanner.close();



    }
}
