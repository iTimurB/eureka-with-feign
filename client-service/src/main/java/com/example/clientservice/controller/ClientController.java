package com.example.clientservice.controller;

import com.example.clientservice.feign.BookServiceClient;
import com.example.clientservice.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final BookServiceClient bookServiceClient;

    public ClientController(BookServiceClient bookServiceClient) {
        this.bookServiceClient = bookServiceClient;
    }

    @GetMapping
    public List<Book> getAllBooksFromBooksService() {
        return bookServiceClient.getAllBooks();
    }
}
