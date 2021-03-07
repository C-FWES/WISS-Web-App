package com.jdbc;


import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

//@Configuration
//@ComponentScan("com.jdbc")
public class SpringJdbcConfig {
    //    @Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://ec2-54-157-149-88.compute-1.amazonaws.com:5432/dnbqjhbummd09?sslmode=require");
        dataSource.setUsername("jgifcdbhywpvqu");
        dataSource.setPassword("d2ee373f66e512912cbe5f5da05874e8e79576cf9c92cc8615896695c6f642f5");
        return dataSource;
    }
}



