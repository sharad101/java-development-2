package com.pluralsight.ledger4.dao.impl;

import com.pluralsight.ledger4.dao.interfaces.ITransactionDAO;
import com.pluralsight.ledger4.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTransactionDAO implements ITransactionDAO {

    private DataSource dataSource;

    @Autowired
    public JdbcTransactionDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Transaction add(Transaction transaction) {
        String insertDataQuery = "INSERT INTO transactions (amount, vendor) VALUES (?, ?) ";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement insertStatement = connection.prepareStatement(insertDataQuery, PreparedStatement.RETURN_GENERATED_KEYS)){
            insertStatement.setDouble(1, transaction.getAmount());
            insertStatement.setString(2, transaction.getVendor());

            int affectedRows = insertStatement.executeUpdate();

            if (affectedRows == 0){
                throw new SQLException("Creating transaction failed, no rows affected");
            }

            try(ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
                if (generatedKeys.next()){
                    int generatedId = generatedKeys.getInt(1);
                    transaction.setTransactionId(generatedId);
                } else {
                    throw new SQLException("Creating transaction failed, no ID obtained");
                }

            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return transaction;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        String getAllQuery = "SELECT * FROM transactions";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement selectStatement = connection.prepareStatement(getAllQuery);
            ResultSet resultSet = selectStatement.executeQuery()){

            while(resultSet.next()){
                int transactionId = resultSet.getInt("transaction_id");
                double amount = resultSet.getDouble("amount");
                String vendor = resultSet.getString("vendor");

                transactions.add(new Transaction(transactionId, amount, vendor));

            }


        } catch (SQLException e){
            e.printStackTrace();
        }

        return transactions;
    }

    @Override
    public Transaction getTransactionById(int transactionId) {
        Transaction transaction = null;
        String getByIdQuery = "SELECT * FROM WHERE transaction_id = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement selectStatement = connection.prepareStatement(getByIdQuery)) {

            selectStatement.setInt(1, transactionId);

            try (ResultSet resultSet = selectStatement.executeQuery()){
                if (resultSet.next()){
                    int transactionIdFromDb = resultSet.getInt("transaction_id");


                }

            }



        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(int transactionId, Transaction transaction) {
        String updateDataQuery = " UPDATE transactions SET amount = ?, vendor = ? WHERE transaction_id = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement updateStatement = connection.prepareStatement(updateDataQuery)) {
            updateStatement.setDouble(1, transaction.getAmount());
            updateStatement.setString();

        }

    }

    @Override
    public void delete(int transactionId) {

    }
}
