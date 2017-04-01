package com.seavus.bookstore.recommendation.api;

import java.util.List;

public interface RecommendationService {

    List<Product> recommendSimilarProducts(String uuid);
}
