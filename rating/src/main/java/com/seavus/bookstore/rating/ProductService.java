package com.seavus.bookstore.rating;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("rating.ProductService")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class ProductService {

    private final ProductRepository productRepository;

    public Product createProduct(String uuid) {
        return productRepository.save(new Product(uuid));
    }
}
