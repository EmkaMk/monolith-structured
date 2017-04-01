package com.seavus.bookstore.rating;

import com.seavus.karaka.domain.entity.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;

@javax.persistence.Entity(name = "RatingProduct")
@Table(name = "rating_product")
@NoArgsConstructor
@Getter
public class Product extends Entity {

    private String uuid;

    @Setter(AccessLevel.PACKAGE)
    private Integer rating;

    public Product(String uuid) {
        this.uuid = uuid;
    }
}
