package com.seavus.bookstore.api;

import com.seavus.bookstore.bookmanagement.api.Book;
import com.seavus.bookstore.recommendation.api.Product;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2017-03-13T15:58:29+0100",
    comments = "version: 1.0.0.Final, compiler: javac, environment: Java 1.8.0_73 (Oracle Corporation)"
)
public class BookMapperImpl implements BookMapper {

    @Override
    public com.seavus.bookstore.api.Book from(Book book) {
        if ( book == null ) {
            return null;
        }

        com.seavus.bookstore.api.Book book_ = new com.seavus.bookstore.api.Book();

        book_.setId( book.getUuid() );
        book_.setTitle( book.getTitle() );
        book_.setAuthor( book.getAuthor() );
        book_.setGenre( book.getGenre() );

        return book_;
    }

    @Override
    public com.seavus.bookstore.api.Book from(Product product) {
        if ( product == null ) {
            return null;
        }

        com.seavus.bookstore.api.Book book = new com.seavus.bookstore.api.Book();

        book.setId( product.getUuid() );

        return book;
    }
}
