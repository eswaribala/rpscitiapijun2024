package com.siemens.customerapisaml.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@ConfigurationProperties(prefix = "server.servlet.session.cookie")
@Configuration("cookieProperties")
@Getter
@Setter
public class CookieConfiguration {

    private String comment;
    private String domain;
    private boolean httpOnly;
    private Duration maxAge;
    private String name;
    private String path;
    private boolean secure;

}