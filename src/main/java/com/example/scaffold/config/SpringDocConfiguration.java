package com.example.scaffold.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.*;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
            .group("Scaffold api")
            .pathsToMatch("/**")
            .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI().info(new Info()
            .title("Title")
            .description("Description.")
            .version("v1.0.0")
        );
    }

}
