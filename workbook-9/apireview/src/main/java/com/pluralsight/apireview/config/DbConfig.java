package com.pluralsight.apireview.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    private DataSource basicDataSource;

    @Bean
    public DataSource dataSource() {
        return basicDataSource;
    }

    public DbConfig(@Value("${datasource.url}") String url,
                    @Value("${datasource.username}") String username,
                    @Value("${datasource.password}") String password) {
        basicDataSource = new BasicDataSource(); // Instantiating BasicDataSource object.
       basicDataSource.setUrl(url); // Setting the database URL.
        basicDataSource.setUsername(username); // Setting the database username.
        basicDataSource.setPassword(password); // Setting the database password.


    }
}
