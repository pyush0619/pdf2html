package com.example.pdf2html.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi conversionAPI(){
        String[] paths = new String[]{"/conversions/**"};
        return GroupedOpenApi.builder().group("conversions").pathsToMatch(paths).build();
    }

}
