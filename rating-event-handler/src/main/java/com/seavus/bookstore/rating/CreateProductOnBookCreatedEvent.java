package com.seavus.bookstore.rating;

import com.seavus.bookstore.bookmanagement.BookCreatedEvent;
import com.seavus.karaka.messaging.MessageSubscriber;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("rating.CreateProductOnBookCreatedEvent")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class CreateProductOnBookCreatedEvent implements MessageSubscriber<BookCreatedEvent> {

    private final ProductService productService;

    @Override
    public void notify(BookCreatedEvent bookCreatedEvent) {
        productService.createProduct(bookCreatedEvent.getUuid());
    }
}
