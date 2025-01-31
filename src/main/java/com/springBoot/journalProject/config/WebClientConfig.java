package com.springBoot.journalProject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${uni.client.url}")
    private String universitiesAPI;

    @Bean
    public WebClient uniWebClient(final WebClient.Builder webClientBuilder) {
        return webClientBuilder
                .clone()
                .baseUrl(universitiesAPI)
                .build();
    }
}
