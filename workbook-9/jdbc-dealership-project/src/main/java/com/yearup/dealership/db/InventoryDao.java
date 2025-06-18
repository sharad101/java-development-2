package com.yearup.dealership.db;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InventoryDao {
    private DataSource dataSource;

    public InventoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicleToInventory(String vin, int dealershipId) {
        String InsertVehicleInventorySql = "INSERT INTO Inventory (vin, dealership_id) VALUES (?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(InsertVehicleInventorySql)) {

            statement.setString(1, vin);
            statement.setInt(2, dealershipId);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging in production
        }
    }

    public void removeVehicleFromInventory(String vin) {
        String deleteVehicleSql = "DELETE FROM Inventory WHERE vin = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(deleteVehicleSql)) {

            statement.setString(1, vin);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
