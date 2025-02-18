// Generated by delombok at Mon Mar 13 15:58:36 CET 2017
package com.seavus.bookstore.recommendation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("recommendation.ProductService")
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

    @java.beans.ConstructorProperties({"productRepository"})
    @Autowired
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
