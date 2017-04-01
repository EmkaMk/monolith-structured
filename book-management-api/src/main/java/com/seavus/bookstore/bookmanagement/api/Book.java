package com.seavus.bookstore.bookmanagement.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {

    private String uuid;

    private String title;

    private String author;

    private String genre;
}
