package com.pluralsight.db;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataManager {
    private DataSource dataSource;

    public DataManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void InsertIntoDirect(String country){
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT into country (country) values (?)")){

//            preparedStatement.executeUpdate();

            int rows = preparedStatement.executeUpdate();
            System.out.println("Rows inserted" + rows);


        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public void InsertIntoWithGeneratedKeys(String country){
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT into country (country) values (?)", PreparedStatement.RETURN_GENERATED_KEYS)){

//            preparedStatement.executeUpdate();

            int rows = preparedStatement.executeUpdate();
            System.out.println("Rows inserted" + rows);

            try(ResultSet keys = preparedStatement.getGeneratedKeys()){

                while(keys.next()){
                    System.out.println("ne key was added: " + keys.getInt(1));
                }

            }


        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public void updateRecord(String newDescription, int filmdId){
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE film SET description = ? WHERE film_id = ?")){

            preparedStatement.setString(1, newDescription);
            preparedStatement.setInt(2, filmdId);

            int rows = preparedStatement.executeUpdate();
            System.out.println("Rows inserted" + rows);

        } catch (Exception ex){
            ex.printStackTrace();
        }


    }

    public void deleteRecord(String countryName){
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM country WHERE country = ?")){

            preparedStatement.setString(1, countryName);

            int rows = preparedStatement.executeUpdate();
            System.out.println("Rows Deleted" + rows);

        } catch (Exception ex){
            ex.printStackTrace();
        }


    }


}
