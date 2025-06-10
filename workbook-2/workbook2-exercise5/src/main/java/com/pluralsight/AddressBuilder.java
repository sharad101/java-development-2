package com.pluralsight;

import java.sql.SQLOutput;
import java.util.Scanner;

public class AddressBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please provide the following information:");


        // Billing address information
        System.out.println("Full name: ");
        String fullName = scanner.nextLine();

        System.out.println("Billing Street: ");
        String billingStreet = scanner.nextLine();

        System.out.println("Billing City: ");
        String billingCity = scanner.nextLine();

        System.out.println("Billing State: ");
        String billingState = scanner.nextLine();

        System.out.println("Billing Zip: ");
        String billingZip = scanner.nextLine();


        //Shipping address Details
        System.out.println("\nShipping Street: ");
        String shippingStreet = scanner.nextLine();

        System.out.println("\nShipping City: ");
        String shippingCity = scanner.nextLine();

        System.out.println("\nShipping State: ");
        String shippingState = scanner.nextLine();

        System.out.println("\nShipping Zip: ");
        String shippingZip = scanner.nextLine();

        StringBuilder addressBuilder = new StringBuilder();

        addressBuilder.append(fullName).append("\n\n");
        addressBuilder.append("Billing Address:").append("\n");
        addressBuilder.append(billingStreet).append("\n");
        addressBuilder.append(billingCity).append(" , ").append(billingState).append(" ").append(billingZip);


        addressBuilder.append("Shipping Address:").append("\n");
        addressBuilder.append(shippingStreet).append("\n");
        addressBuilder.append(shippingCity).append(" , ").append(shippingState).append(" ").append(shippingZip);



        String addressBuilderString = addressBuilder.toString();
        System.out.println(addressBuilderString);









    }

}
