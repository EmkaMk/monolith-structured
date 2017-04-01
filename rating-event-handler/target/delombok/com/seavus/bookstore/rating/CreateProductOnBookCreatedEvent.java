// Generated by delombok at Mon Mar 13 15:58:35 CET 2017
package com.seavus.bookstore.rating;

import com.seavus.bookstore.bookmanagement.BookCreatedEvent;
import com.seavus.karaka.messaging.MessageSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("rating.CreateProductOnBookCreatedEvent")
public class CreateProductOnBookCreatedEvent implements MessageSubscriber<BookCreatedEvent> {
    private final ProductService productService;

    @Override
    public void notify(BookCreatedEvent bookCreatedEvent) {
        productService.createProduct(bookCreatedEvent.getUuid());
    }

    @java.beans.ConstructorProperties({"productService"})
    @Autowired
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public CreateProductOnBookCreatedEvent(final ProductService productService) {
        this.productService = productService;
    }
}
