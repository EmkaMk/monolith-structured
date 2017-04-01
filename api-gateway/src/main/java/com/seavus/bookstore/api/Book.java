package com.seavus.bookstore.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {

    private String id;

    private String title;

    private String author;

    private String genre;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer rating;
}
