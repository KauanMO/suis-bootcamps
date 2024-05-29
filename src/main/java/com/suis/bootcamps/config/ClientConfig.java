package com.suis.bootcamps.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {
    @Value("${client.url}")
    private String clientUrl;

    public String getUrl() {
        return clientUrl;
    }
}
