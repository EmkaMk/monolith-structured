// Generated by delombok at Mon Mar 13 15:58:40 CET 2017
package com.seavus.bookstore.bookmanagement.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceInProcessAdapter implements BookService {
    private final com.seavus.bookstore.bookmanagement.BookService bookService;

    @Override
    public Book findBookByUuid(String uuid) {
        return BookMapper.INSTANCE.from(bookService.findBookByUuid(uuid));
    }

    @Override
    public List<Book> findBooks() {
        return bookService.findBooks().stream().map(BookMapper.INSTANCE::from).collect(Collectors.toList());
    }

    @java.beans.ConstructorProperties({"bookService"})
    @Autowired
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public BookServiceInProcessAdapter(final com.seavus.bookstore.bookmanagement.BookService bookService) {
        this.bookService = bookService;
    }
}
