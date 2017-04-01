// Generated by delombok at Mon Mar 13 15:58:32 CET 2017
package com.seavus.bookstore.bookmanagement;

import com.seavus.karaka.domain.entity.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.UUID;

@javax.persistence.Entity
@Table(name = "book_management_book")
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

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public Book() {
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public String getUuid() {
        return this.uuid;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public String getTitle() {
        return this.title;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public String getAuthor() {
        return this.author;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public Genre getGenre() {
        return this.genre;
    }
}
