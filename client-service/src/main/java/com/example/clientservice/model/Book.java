package com.example.clientservice.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Book {
    private Long id;
    private String title;
    private String description;
    private String imageLink;
}
