package com.pluralsight;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Lambda Expressions

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Matt", "Smith", 30));


        System.out.println("Enter a last name to search: ");
        Scanner scanner = new Scanner(System.in);
        String lastnameToSearch = scanner.nextLine();

//        List<Employee> matchingEmployees = new ArrayList<>();
//
//        for (Employee employee : employees) {
//            if(employee.getLastName().equalsIgnoreCase(lastnameToSearch)){
//                matchingEmployees.add(employee);
//            }
//        }

//        //Using  streams/lambda
//        List<Employee> matchingEmployees =
//                employees       //Source - Data at Rest (Phase 1)
//                        .stream().filter(employee -> employee.getLastName().equalsIgnoreCase(lastnameToSearch)) //Data Transformation - Data is in transit (Phase 2)
//                        .collect(Collectors.toList()); //Destination - Data as Rest (Phase 3)

        //Using  streams/lambda but With ArrayList (receive back with ArrayList)
        ArrayList<Employee> matchingEmployees =
                employees       //Source - Data at Rest (Phase 1)
                        .stream().filter(employee -> employee.getLastName().equalsIgnoreCase(lastnameToSearch)) //Data Transformation - Data is in transit (Phase 2)
                        .collect(Collectors.toCollection(ArrayList::new)); //Destination - Data as Rest (Phase 3)


        System.out.println("the results are");

//        for (Employee mathcingEmployee : matchingEmployees) {
//            System.out.println(mathcingEmployee);
//
//        }

        matchingEmployees.forEach(matchingEmployee -> System.out.println(matchingEmployees));


        employees.forEach( emp -> {
            if (emp.getAge() < 40)
                System.out.println(emp.getFirstName() + "is young");
            else
                System.out.println(emp.getLastName() + "is old");
        });

    }
}
