package com.example.gateweyservice.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Component
public class HeaderFilter implements GatewayFilter {

    private final static String REQUIRED_HEADER = "spring-cloud-course";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders headers = exchange.getRequest().getHeaders();
        if (headers.containsKey(REQUIRED_HEADER)) {
            HttpHeaders newHeaders = new HttpHeaders();
            headers.entrySet().stream()
                    .filter(entry -> !entry.getKey().equalsIgnoreCase("spring-cloud-course"))
                    .forEach(entry -> newHeaders.put(entry.getKey(), entry.getValue()));

            // Создание нового ServerHttpRequest с обновленными заголовками
            ServerHttpRequest newRequest = exchange.getRequest().mutate()
                    .headers(httpHeaders -> httpHeaders.addAll(newHeaders))
                    .build();

            // Продолжение цепочки фильтров с новым запросом
            return chain.filter(exchange.mutate().request(newRequest).build());
        } else {
            // Возвращение 403 статуса при отсутствии заголовка
            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
            return exchange.getResponse().setComplete();
        }
    }
}
