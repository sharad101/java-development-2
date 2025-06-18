package com.yearup.dealership.db;

import com.yearup.dealership.models.LeaseContract;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LeaseDao {
    private DataSource dataSource;

    public LeaseDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addLeaseContract(LeaseContract leaseContract) {
        String addLeaseContractSql = "INSERT INTO LeaseContracts (vin, lease_start, lease_end, monthly_payment) VALUES (?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(addLeaseContractSql)) {

            statement.setString(1, leaseContract.getVin());
            statement.setDate(2, java.sql.Date.valueOf(leaseContract.getLeaseStart()));
            statement.setDate(3, java.sql.Date.valueOf(leaseContract.getLeaseEnd()));
            statement.setDouble(4, leaseContract.getMonthlyPayment());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
