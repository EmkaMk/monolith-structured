package com.seavus.bookstore.rating;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("rating.ProductRepository")
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByUuid(String uuid);
}
