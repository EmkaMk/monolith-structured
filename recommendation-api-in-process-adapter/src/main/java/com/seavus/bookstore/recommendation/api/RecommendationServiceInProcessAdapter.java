package com.seavus.bookstore.recommendation.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class RecommendationServiceInProcessAdapter implements RecommendationService {

    private final com.seavus.bookstore.recommendation.RecommendationService recommendationService;

    @Override
    public List<Product> recommendSimilarProducts(String uuid) {
        return recommendationService.recommendSimilarProducts(uuid)
                .stream()
                .map(ProductMapper.INSTANCE::from)
                .collect(Collectors.toList());
    }
}
