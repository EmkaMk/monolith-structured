package com.seavus.bookstore.bookmanagement.api;

import java.util.List;

public interface BookService {

    Book findBookByUuid(String bookUuid);

    List<Book> findBooks();
}
