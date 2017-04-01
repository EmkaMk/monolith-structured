package com.seavus.bookstore.bookmanagement;

import com.seavus.karaka.domain.entity.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.UUID;

@javax.persistence.Entity
@Table(name = "book_management_book")
@NoArgsConstructor
@Getter
public class Book extends Entity {

    private String uuid = UUID.randomUUID().toString();

    private String title;

    private String author;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    public Book(String title, String author, Genre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }
}
