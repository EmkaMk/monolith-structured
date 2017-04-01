package com.seavus.bookstore.bookmanagement.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
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
}
