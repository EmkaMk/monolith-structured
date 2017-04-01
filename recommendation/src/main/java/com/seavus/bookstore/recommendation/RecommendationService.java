package com.seavus.bookstore.recommendation;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class RecommendationService {

    private final ProductRepository productRepository;

    public List<Product> recommendSimilarProducts(String uuid) {
        Product subject = productRepository.findByUuid(uuid);
        return productRepository.findAll()
                .stream()
                .filter(candidateIsNotSubject(subject))
                .filter(candidateHasRating())
                .filter(candidateIsOfSameCategoryAsSubject(subject))
                .sorted((candidate1, candidate2) -> candidate2.getRating() - candidate1.getRating())
                .collect(Collectors.toList());
    }

    private Predicate<Product> candidateIsNotSubject(Product subject) {
        return candidate -> !candidate.getId().equals(subject.getId());
    }

    private Predicate<Product> candidateHasRating() {
        return candidate -> candidate.getRating() != null;
    }

    private Predicate<Product> candidateIsOfSameCategoryAsSubject(Product subject) {
        return candidate -> candidate.getCategory().equals(subject.getCategory());
    }
}
