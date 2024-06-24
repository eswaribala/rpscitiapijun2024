package com.siemens.customerapi.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.jdbc.DataSourceHealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
@Endpoint(id="siemenshoodhealth")
public class SiemensHoodHealthIndicator {

    @ReadOperation
    @Bean
    public String message(){
        return "Message from Hood";
    }

    /*
    @Value("${datasource_validationquery}")
    private String validationQuery;

    @ReadOperation
    @Bean("SmartHoodDBHealthIndicator")
    public HealthIndicator smartDBHealthIndicatior(@Qualifier("smartdb") @Autowired DataSource ds){

        return new DataSourceHealthIndicator(ds,validationQuery);
    }

     */
}
