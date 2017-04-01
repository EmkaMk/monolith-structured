package com.seavus.bookstore.rating.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class RatingServiceInProcessAdapter implements RatingService {

    private final com.seavus.bookstore.rating.RatingService ratingService;

    @Override
    public void rateProduct(String uuid, Integer rating) {
        ratingService.rateProduct(uuid, rating);
    }

    @Override
    public Integer getProductRating(String uuid) {
        return ratingService.getProductRating(uuid);
    }
}
