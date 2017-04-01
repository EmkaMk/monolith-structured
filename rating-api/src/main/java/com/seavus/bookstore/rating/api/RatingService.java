package com.seavus.bookstore.rating.api;

public interface RatingService {

    void rateProduct(String uuid, Integer rating);

    Integer getProductRating(String uuid);
}
