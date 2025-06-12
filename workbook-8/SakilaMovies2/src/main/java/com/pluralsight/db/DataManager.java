package com.pluralsight.db;

import com.pluralsight.model.Actor;
import com.pluralsight.model.Film;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private DataSource dataSource;

    public DataManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Actor> getActorsByLastName(String lastName) {
        List<Actor> actors = new ArrayList<>();
        String query = "SELECT actor_id, first_name, last_name FROM actor WHERE last_name = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setString(1, lastName);
            try (ResultSet results = preparedStatement.executeQuery()) {
                if (results.next()) {
                    do {
                        actors.add(new Actor(
                                results.getInt("actor_id"),
                                results .getString("first_name"),
                                results.getString("last_name")
                        ));
                    } while (results.next());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return actors;
    }

    public List<Film> getFilmsByActorId(int actorId) {
        List<Film> films = new ArrayList<>();
        String query = "SELECT f.film_id, f.title, f.description, f.release_year, f.length FROM film f " +
                "JOIN film_actor fa ON f.film_id = fa.film_id WHERE fa.actor_id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setInt(1, actorId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    do {
                        films.add(new Film(
                                resultSet.getInt("film_id"),
                                resultSet.getString("title"),
                                resultSet.getString("description"),
                                resultSet.getInt("release_year"),
                                resultSet.getInt("length")
                        ));
                    } while (resultSet.next());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return films;
    }
}