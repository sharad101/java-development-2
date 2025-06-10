package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter num1 ");
            int num1 = scanner.nextInt();

            System.out.println("Enter num2 ");
            int num2 = scanner.nextInt();

            int result = num1 / num2;

            System.out.println("Result is" + result);

        } catch (Exception ex){
            System.out.println("Sorry potato");
        }
    }
}
