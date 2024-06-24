package com.siemens.customerapi.configurations;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component

public class CustomHealthIndicatior extends AbstractHealthIndicator {
    private int guess;
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        this.guess=new Random().nextInt(10);

        if(this.guess<5){
            builder.up().build();

        }else {
            builder.down().withDetail("Health Error","Application not runnning").build();
        }

    }
}
