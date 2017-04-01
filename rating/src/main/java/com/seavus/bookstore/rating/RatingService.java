package com.seavus.bookstore.rating;

import com.seavus.karaka.messaging.MessagePublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class RatingService {

    private final ProductRepository productRepository;

    private final MessagePublisher messagePublisher;

    public void rateProduct(String uuid, Integer rating) {
        Product product = productRepository.findByUuid(uuid);
        product.setRating(rating);
        productRepository.save(product);
        messagePublisher.publish(new ProductRatedEvent(product.getUuid(), product.getRating()));
    }

    public Integer getProductRating(String uuid) {
        return productRepository.findByUuid(uuid).getRating();
    }
}
