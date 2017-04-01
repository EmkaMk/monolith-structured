package com.seavus.bookstore.application;

import com.seavus.bookstore.bookmanagement.BookService;
import com.seavus.bookstore.bookmanagement.Genre;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

//@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        BookService bookService = event.getApplicationContext().getBean(BookService.class);

        bookService.createBook("It", "Stephen King", Genre.HORROR);
        bookService.createBook("The Shining", "Stephen King", Genre.HORROR);
        bookService.createBook("Misery", "Stephen King", Genre.HORROR);
        bookService.createBook("Dune", "Frank Herbert", Genre.SF);
        bookService.createBook("Solaris", "Stanislaw Lem", Genre.SF);
        bookService.createBook("Foundation", "Isaac Asimov", Genre.SF);
    }
}
