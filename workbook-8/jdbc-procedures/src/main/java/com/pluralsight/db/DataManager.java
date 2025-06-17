package com.pluralsight.db;

import com.pluralsight.models.CustomerOderHistory;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private BasicDataSource datasource;

    public DataManager(String url, String username, String password){
        this.datasource = new BasicDataSource();
        datasource.setUrl(url);
        datasource.setUsername(username);
        datasource.setPassword(password);

    }


    public List<CustomerOrderHistory> searchCustomerOrderHistory(String customerId){
        List<CustomerOderHistory> orderHistoryList = new ArrayList<>();

        try(Connection connection = datasource.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{CALL CustOrderHist(?)}")){
            callableStatement.setString(1, customerId);

            try(ResultSet resultSet = callableStatement.executeQuery()){
                while (resultSet.next()){
                    String productName = resultSet.getString("ProductName");
                    int totalQuantity = resultSet.getInt("Total");

                    CustomerOderHistory orderHistory = new CustomerOderHistory(productName, totalQuantity);
                    orderHistoryList.add(orderHistory);

                }

            } catch (Exception ex){
                ex.printStackTrace();
            }


        }
    }
}
