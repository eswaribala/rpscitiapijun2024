package com.siemens.customerapisaml.configurations;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
