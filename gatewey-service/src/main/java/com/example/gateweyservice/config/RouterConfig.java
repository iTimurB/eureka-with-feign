package com.example.gateweyservice.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouterConfig {

    private final HeaderFilter headerFilter;


    public RouterConfig(HeaderFilter headerFilter) {
        this.headerFilter = headerFilter;
    }


    @Bean
    public RouteLocator commonRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("client-service", r -> r.path("/api/client")
                        .filters(f -> f.filter(headerFilter))
                        .uri("lb://client-service/"))
                .build();
    }
}
