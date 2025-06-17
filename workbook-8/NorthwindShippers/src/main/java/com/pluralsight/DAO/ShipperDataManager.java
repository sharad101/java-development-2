package com.pluralsight.db;

import com.pluralsight.model.Shipper;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShipperDataManager {
    private DataSource dataSource;

    public ShipperDataManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int insertShipper(Shipper shipper) {
        String sql = "INSERT INTO shippers (company_name, phone) VALUES (?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, shipper.getName());
            stmt.setString(2, shipper.getPhone());

            stmt.executeUpdate();

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getInt(1);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public List<Shipper> getAllShippers() {
        List<Shipper> shippers = new ArrayList<>();
        String sql = "SELECT shipper_id, company_name, phone FROM shippers";

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Shipper shipper = new Shipper(
                        rs.getInt("shipper_id"),
                        rs.getString("company_name"),
                        rs.getString("phone")
                );
                shippers.add(shipper);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return shippers;
    }

    public void updatePhoneNumber(int id, String newPhone) {
        String sql = "UPDATE shippers SET phone = ? WHERE shipper_id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newPhone);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteShipper(int id) {
        String sql = "DELETE FROM shippers WHERE shipper_id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
