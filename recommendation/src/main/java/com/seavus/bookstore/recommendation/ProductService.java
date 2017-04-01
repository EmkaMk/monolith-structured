package com.seavus.bookstore.recommendation;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("recommendation.ProductService")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class ProductService {

    private final ProductRepository productRepository;

    public Product createProduct(String uuid, String category) {
        return productRepository.save(new Product(uuid, category));
    }

    public void updateProductRating(String uuid, Integer rating) {
        Product product = productRepository.findByUuid(uuid);
        product.setRating(rating);
        productRepository.save(product);
    }
}
