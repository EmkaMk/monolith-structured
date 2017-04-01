package com.seavus.bookstore.recommendation;

import com.seavus.karaka.domain.entity.Entity;
import lombok.*;

import javax.persistence.Table;

@javax.persistence.Entity(name = "RecommendationProduct")
@Table(name = "recommendation_product")
@NoArgsConstructor
@Getter
public class Product extends Entity {

    private String uuid;

    private String category;

    @Setter(AccessLevel.PACKAGE)
    private Integer rating;

    public Product(String uuid, String category) {
        this.uuid = uuid;
        this.category = category;
    }
}
