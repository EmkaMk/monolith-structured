// Generated by delombok at Mon Mar 13 15:58:32 CET 2017
package com.seavus.bookstore.bookmanagement;

import com.seavus.karaka.messaging.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final MessagePublisher messagePublisher;

    public Book createBook(String title, String author, Genre genre) {
        Book book = bookRepository.save(new Book(title, author, genre));
        messagePublisher.publish(new BookCreatedEvent(book.getUuid(), book.getTitle(), book.getAuthor(), book.getGenre().toString()));
        return book;
    }

    public Book findBookByUuid(String uuid) {
        return bookRepository.findByUuid(uuid);
    }

    public List<Book> findBooks() {
        return bookRepository.findAll();
    }

    @java.beans.ConstructorProperties({"bookRepository", "messagePublisher"})
    @Autowired
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public BookService(final BookRepository bookRepository, final MessagePublisher messagePublisher) {
        this.bookRepository = bookRepository;
        this.messagePublisher = messagePublisher;
    }
}
