package com.pluralsight;

import com.pluralsight.db.DataManager;
import com.pluralsight.model.Actor;
import com.pluralsight.model.Film;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("User and Password are needed to connect to the database!");
            System.exit(1);
        }

        String username = args[0];
        String password = args[1];

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        DataManager dataManager = new DataManager(dataSource);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the last name of an actor: ");
        String lastName = scanner.nextLine();

        List<Actor> matchingActors = dataManager.getActorsByLastName(lastName);

        if (matchingActors.isEmpty()) {
            System.out.println("No matches!");
            return;
        }

        System.out.println("Your matches are:");
        matchingActors.forEach(System.out::println);

        System.out.print("\nEnter the actor ID to see their movies: ");
        int actorId = scanner.nextInt();
        scanner.nextLine(); // clear newline

        List<Film> films = dataManager.getFilmsByActorId(actorId);

        if (films.isEmpty()) {
            System.out.println("No films found for the selected actor.");
        } else {
            System.out.println("\nFilms the actor has been in:");
            films.forEach(System.out::println);
        }
    }
}
