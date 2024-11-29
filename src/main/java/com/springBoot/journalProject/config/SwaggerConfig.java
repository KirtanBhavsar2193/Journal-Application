package com.springBoot.journalProject.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class SwaggerConfig
{
    @Bean
    public OpenAPI myCustom()
    {
        return new OpenAPI()
                .info(
                new Info().title("Journal App APIs")
                        .description("Hyy ! Kimy ")
                )
                .servers(Arrays.asList(new Server().url("http://localhost:8080").description("local"),
                        new Server().url("http://localhost:2144").description("Live")));
    }
}
