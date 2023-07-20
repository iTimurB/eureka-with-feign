package com.example.clientservice.feign;

import com.example.clientservice.feign.fallback.BookServiceClientFallbackFactory;
import com.example.clientservice.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "book-service", fallbackFactory = BookServiceClientFallbackFactory.class)
public interface BookServiceClient{

    @GetMapping("/api/books/all")
    List<Book> getAllBooks();
}
