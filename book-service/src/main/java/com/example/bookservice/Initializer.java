package com.example.bookservice;

import com.example.bookservice.model.Book;
import com.example.bookservice.repository.BookRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements ApplicationRunner {

    private final BookRepository bookRepository;

    public Initializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 0; i < 5; i++) {
            Book book = new Book();
            book.setId((long) i);
            book.setDescription("description" + i);
            book.setTitle("title" + i);
            book.setImageLink("link" + i);
            bookRepository.save(book);
        }
    }
}
