package com.example.clientservice.feign.fallback;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class BookServiceClientFallbackFactory implements FallbackFactory<BookServiceClientFallback> {

    @Override
    public BookServiceClientFallback create(Throwable cause) {
        return new BookServiceClientFallback(cause.getMessage());
    }
}
