package com.siemens.customerapi.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.jdbc.DataSourceHealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class HealthIndicatiorConfig {


    @Value("${datasource_validationquery}")
    private String validationQuery;


    @Bean("SmartDBHealthIndicator")
    public HealthIndicator smartDBHealthIndicatior(@Qualifier("smartdb") @Autowired DataSource ds){

        return new DataSourceHealthIndicator(ds,validationQuery);
    }
}
