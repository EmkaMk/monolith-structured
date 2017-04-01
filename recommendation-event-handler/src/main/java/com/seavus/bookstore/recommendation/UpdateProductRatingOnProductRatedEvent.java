package com.seavus.bookstore.recommendation;

import com.seavus.bookstore.rating.ProductRatedEvent;
import com.seavus.karaka.messaging.MessageSubscriber;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class UpdateProductRatingOnProductRatedEvent implements MessageSubscriber<ProductRatedEvent> {

    private final ProductService productService;

    @Override
    public void notify(ProductRatedEvent productRatedEvent) {
        productService.updateProductRating(productRatedEvent.getUuid(), productRatedEvent.getRating());
    }
}
