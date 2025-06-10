package com.pluralsight;

import java.util.Scanner;

public class VehicleInventory {

    private static Vehicle[] vehicles = new Vehicle[20];

    private static int numOfVehicles = 6;

    public static void main(String[] args) {

        vehicles[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500.00f);
        vehicles[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000.00f);
        vehicles[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700.00f);
        vehicles[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500.00f);
        vehicles[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500.00f);
        vehicles[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000.00f);


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("What do you? ");
            System.out.println(" 1 - List all vehicles");
            System.out.println(" 2 - List all vehicles");
            System.out.println(" 3 - List all vehicles");
            System.out.println(" 4 - List all vehicles");
            System.out.println(" 5 - List all vehicles");
            System.out.println(" 1 - List all vehicles");

            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1:
                    //List all vehicles
                    listAllVehicles();
                    break;
                case 2:
                    //Search by make and model
                    findVehiclesMakeModel(scanner);
                    break;
                case 3:
                    //Search by price range
                    findVehiclesByPrice(scanner);
                    break;
                case 4:
                    //Search by color
                    findVehiclesByColor(scanner);
                    break;
                case 5:
                    //Add a new vehicle to the dealership
                    addVehicle(scanner);
                    break;
                case 6:
                    System.out.println("Goodbye");
                    return;
                default:
                    System.out.println("Invalid command");
                    break;
            }

        }

    }


    public static void addVehicle(Scanner scanner){

        if (numOfVehicles < 20) {


            System.out.println("Enter vehicle Id: ");
            long id = scanner.nextLong();
            scanner.nextLine();

            System.out.println("Enter make and model: ");
            String makeModel = scanner.nextLine();

            System.out.println("Enter color: ");
            String color = scanner.nextLine();


            System.out.println("Enter odometer reading: ");
            int odometerReading = scanner.nextInt();

            System.out.println("Enter price: ");
            float price = scanner.nextFloat();


            Vehicle newVehicle = new Vehicle(id, makeModel, color, odometerReading, price);

            //Add new vehicle at the end
            vehicles[numOfVehicles] = newVehicle;
            numOfVehicles++;

            System.out.println("Vehicle added");
        } else {
            System.out.println("Inventory full");
        }


    }

    private static void listAllVehicles() {
        System.out.println("Vehicle Inventory");

        for (int i = 0; i < numOfVehicles; i++) {
            System.out.println(vehicles[i]);

        }
    }

    private static void findVehiclesMakeModel(Scanner scanner) {
        System.out.println("Enter make and model: ");
        String makeModel = scanner.nextLine();

        boolean found = false;

        for (int i = 0; i < numOfVehicles; i++) {
            if (vehicles[i].getMakeModel().equalsIgnoreCase(makeModel)) {
                System.out.println(vehicles[i]);
                found = true;

            }

        }

        if (!found) {
            System.out.println("No vehicles found");
        }

    }


    private static void findVehiclesByPrice(Scanner scanner) {

        System.out.println("Enter min price: ");
        float minPrice = scanner.nextFloat();

        System.out.println("Enter max price: ");
        float maxPrice = scanner.nextFloat();

        boolean found = false;

        for (int i = 0; i < numOfVehicles; i++) {
            if (vehicles[i].getPrice() >= minPrice && vehicles[i].getPrice() <= maxPrice) {
                System.out.println(vehicles[i]);
                found = true;


            }

        }

        if (!found) {
            System.out.println("No vehicles found");

        }
    }

    private static void findVehiclesByColor(Scanner scanner) {
        System.out.println("Enter color: ");
        String makeModel = scanner.nextLine();

        boolean found = false;

        for (int i = 0; i < numOfVehicles; i++) {
            if (vehicles[i].getMakeModel().equalsIgnoreCase(makeModel)) {
                System.out.println(vehicles[i]);
                found = true;

            }

        }

        if (!found) {
            System.out.println("No vehicles found");
        }

    }
}
