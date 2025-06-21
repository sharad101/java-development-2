package com.pluralsight.apireview.dao.impl;

import com.pluralsight.apireview.dao.interfaces.IBookDAO;
import com.pluralsight.apireview.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBookDAO implements IBookDAO {


    private DataSource dataSource;

    @Autowired
    public JdbcBookDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Book> getAllBooks(String title, String author, Integer publicationYear) {
        List<Book> books = new ArrayList<>();

        String sql = "SELECT * FROM Books" +
                     "WHERE (title = ? OR ? = '')" +
                     "WHERE (author = ? OR ? = '')" +
                     "WHERE (publication_year = ? OR ? = -1)";

        title = title == null ? "" : title;
        author = author == null ? "" : author;
        publicationYear = publicationYear == null ? -1 : publicationYear;

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, title);
            preparedStatement.setString(2, title);
            preparedStatement.setString(3, author);
            preparedStatement.setString(4, author);
            preparedStatement.setInt(5, publicationYear);
            preparedStatement.setInt(6, publicationYear);

            try(){

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Book getBookBYId(int id) {
        String query = "SELECT * FROM Books WHERE id = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()){
                if (resultSet.next()){
                    int idFromDb = resultSet.getInt("id");
                    String titleFromDb = resultSet.getString("title");
                    String authorFromDb = resultSet.getString("author");
                    int yearFromDb = resultSet.getInt("publication_year");

                    Book book = new Book(idFromDb, titleFromDb, authorFromDb, yearFromDb);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book insertBook(Book book) {
        String query = "INSERT INTO Books (title, author, publication_year VALUES (?, ?, ?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)){

            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setInt(3, book.getPublication_year());

            int rows = preparedStatement.executeUpdate();

            if (rows == 0){
                throw new SQLException("Creating transaction failed, no rows affected.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void updateBook(int id, Book book) {
        // This method updates an existing transaction in the database.
        String updateQuery = "UPDATE Books SET title = ?, author = ?, publication_year = ? WHERE transaction_id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
            // Setting parameters for the update query.
            updateStatement.setDouble(1, transaction.getAmount());
            updateStatement.setString(2, transaction.getVendor());
            updateStatement.setInt(3, transactionId);
            updateStatement.executeUpdate(); // Execute the update query.
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the SQL exception.
        }


    }

    @Override
    public void deleteBook(int id) {


    }
}
