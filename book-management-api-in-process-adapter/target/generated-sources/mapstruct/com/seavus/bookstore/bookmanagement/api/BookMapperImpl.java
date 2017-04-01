package com.seavus.bookstore.bookmanagement.api;

import com.seavus.bookstore.bookmanagement.Book;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2017-03-13T15:58:41+0100",
    comments = "version: 1.0.0.Final, compiler: javac, environment: Java 1.8.0_73 (Oracle Corporation)"
)
public class BookMapperImpl implements BookMapper {

    @Override
    public com.seavus.bookstore.bookmanagement.api.Book from(Book book) {
        if ( book == null ) {
            return null;
        }

        com.seavus.bookstore.bookmanagement.api.Book book_ = new com.seavus.bookstore.bookmanagement.api.Book();

        book_.setUuid( book.getUuid() );
        book_.setTitle( book.getTitle() );
        book_.setAuthor( book.getAuthor() );
        if ( book.getGenre() != null ) {
            book_.setGenre( book.getGenre().name() );
        }

        return book_;
    }
}
