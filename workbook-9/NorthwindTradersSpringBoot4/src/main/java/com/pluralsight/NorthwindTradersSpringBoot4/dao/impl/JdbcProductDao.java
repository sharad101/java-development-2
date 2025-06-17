package com.pluralsight.NorthwindTradersSpringBoot4.dao.impl;

import com.pluralsight.NorthwindTradersSpringBoot4.dao.interfaces.IProductDao;
import com.pluralsight.NorthwindTradersSpringBoot4.models.Product;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDao  implements IProductDao {

    private DataSource dataSource;

    @Autowired
    public JdbcProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
        //initialize(); // Initialize database tables and data on startup.
    }


    @Override
    public Product insert(Product product) {
        String insertQuery = "INSERT INTO Products (ProductName, CategoryId, UnitPrice) VALUES (?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement insertStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {

            insertStatement.setString(1, product.getProductName());
            insertStatement.setInt(2, product.getCategoryId());
            insertStatement.setDouble(3, product.getUnitPrice());


            int affectedRows = insertStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating product failed, no rows affected.");
            }

            try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    product.setProductId(generatedId);
                } else {
                    throw new SQLException("Creating product failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String getAllQuery = "SELECT ProductId, ProductName, CategoryId, UnitPrice FROM Products";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(getAllQuery);
             ResultSet resultSet = selectStatement.executeQuery()) {

            while (resultSet.next()) {
                int productId = resultSet.getInt("ProductId");

                String productName = resultSet.getString("ProductName");

                int categoryId = resultSet.getInt("CategoryId");

                double unitPrice = resultSet.getDouble("UnitPrice");

                products.add(new Product(productId, productName, categoryId, unitPrice));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getById(int productId) {
        Product product = null;
        String getByIdQuery = "SELECT ProductId, ProductName, CategoryId, UnitPrice FROM Products WHERE ProductId = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(getByIdQuery)) {

            selectStatement.setInt(1, productId);
            try (ResultSet resultSet = selectStatement.executeQuery()) {

                if (resultSet.next()) {
                    int id = resultSet.getInt("ProductId");

                    String productName = resultSet.getString("ProductName");

                    int categoryId = resultSet.getInt("CategoryId");

                    double unitPrice = resultSet.getDouble("UnitPrice");

                    product = new Product(id, productName, categoryId, unitPrice);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void update(int productId, Product product) {
        String updateQuery = "UPDATE Products SET ProductName = ?, CategoryId = ?, UnitPrice = ? WHERE ProductId = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {

            updateStatement.setString(1, product.getProductName());
            updateStatement.setInt(2, product.getCategoryId());
            updateStatement.setDouble(3, product.getUnitPrice());
            updateStatement.setInt(4, productId);

            updateStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int productId) {
        String deleteQuery = "DELETE FROM Products WHERE ProductId = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {

            deleteStatement.setInt(1, productId);
            deleteStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
