package com.example.pdf2html.routers;

import com.example.pdf2html.handlers.ConversionHandler;
import com.example.pdf2html.services.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
@EnableWebFlux
public class ConversionRouter implements WebFluxConfigurer {

//    @Autowired
  //  private ConversionHandler conversionHandler;

    @Bean
    public RouterFunction<ServerResponse> routerConversion(ConversionHandler conversionHandler) {
        return route()
                .GET("/conversions",
                        accept(MediaType.APPLICATION_JSON),
                        conversionHandler::getConversion,
                        ops -> ops.beanClass(ConversionService.class).beanMethod("getConversion"))
                .build()
                .and(route()
                        .POST("/conversions",
                                accept(MediaType.APPLICATION_JSON),
                                conversionHandler::PostConversion,
                                ops -> ops.beanClass(ConversionService.class).beanMethod("PostConversion"))
                        .build()
                );
    }
}