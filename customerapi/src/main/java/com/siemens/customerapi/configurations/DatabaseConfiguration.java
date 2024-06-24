package com.siemens.customerapi.configurations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration

public class DatabaseConfiguration {

    @Value("${datasource_url}")
    private String dbUrl;
    @Value("${datasource_driver}")
    private String driver;
    @Value("${datasource_username}")
    private String userName;
    @Value("${datasource_password}")
    private String password;

    private DataSourceBuilder dataSourceBuilder;


    @Bean("smartdb")

    public DataSource getDataSource()
    {

        dataSourceBuilder=DataSourceBuilder.create();
        dataSourceBuilder.url(dbUrl);
        dataSourceBuilder.username(userName);
        dataSourceBuilder.password(password);
        dataSourceBuilder.driverClassName(driver);
        return dataSourceBuilder.build();

    }



}
