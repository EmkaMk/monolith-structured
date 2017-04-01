package com.seavus.bookstore.recommendation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("recommendation.ProductRepository")
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByUuid(String uuid);
}
