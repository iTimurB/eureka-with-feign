package com.example.clientservice.feign.fallback;

import com.example.clientservice.feign.BookServiceClient;
import com.example.clientservice.model.Book;

import java.util.Collections;
import java.util.List;

public record BookServiceClientFallback(String reason) implements BookServiceClient {

    @Override
    public List<Book> getAllBooks() {
        System.out.println("some troubles with book-service " + reason);
        return Collections.emptyList();
    }
}
