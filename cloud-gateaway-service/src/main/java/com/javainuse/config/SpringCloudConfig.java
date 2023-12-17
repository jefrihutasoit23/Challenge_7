package com.javainuse.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

//    referensi https://spring.io/projects/spring-cloud-gateway
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/**")
                        .uri("http://localhost:8080/")
                        .id("binarfudModule"))
                .route(r -> r.path("/socketio/**")
                        .uri("http://localhost:8877/")
                        .id("socketioModule"))
                .route(r -> r.path("/transaksi/**")//localhost:8083/transaksi
                        .uri("http://localhost:8083/")
                        .id("transaksiModule"))
                .build();
    }

}