package com.zavoloka.PetClinic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); // Adjust this based on your database
        dataSource.setUrl("jdbc:mysql://localhost:3308/animals_rescue"); // Change the URL accordingly
        dataSource.setUsername("root");
        dataSource.setPassword("Z@v010ka");
        return dataSource;
    }
}
