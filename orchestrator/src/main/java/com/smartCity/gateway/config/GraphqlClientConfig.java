package com.smartCity.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class GraphqlClientConfig {

    @Bean
    public WebClient agricultureWebClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8081/smartCity/graphql")
                .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

}
