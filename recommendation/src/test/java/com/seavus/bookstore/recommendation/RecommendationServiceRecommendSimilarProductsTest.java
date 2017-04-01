package com.seavus.bookstore.recommendation;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class RecommendationServiceRecommendSimilarProductsTest {

    private static final String GENRE_HORROR = "HORROR";

    private static final String GENRE_SF = "SF";

    private RecommendationService recommendationService;

    private ProductRepository productRepository;

    private Product subject;

    @Before
    public void setUp() throws Exception {
        subject = createProduct(1L, GENRE_HORROR, Integer.MIN_VALUE);

        productRepository = Mockito.mock(ProductRepository.class);
        given(productRepository.findByUuid(subject.getUuid())).willReturn(subject);

        recommendationService = new RecommendationService(productRepository);
    }

    @Test
    public void subjectIsExcluded() throws Exception {
        Product similar = createProduct(2L, GENRE_HORROR, Integer.MIN_VALUE);
        given(productRepository.findAll()).willReturn(ImmutableList.of(subject, similar));

        List<Product> recommendedSimilar = recommendationService.recommendSimilarProducts("1");

        assertThat(recommendedSimilar).extracting("id").containsExactly(2L);
    }

    @Test
    public void onlyCandidatesOfSameGenreAreConsidered() throws Exception {
        Product similar = createProduct(2L, GENRE_HORROR, Integer.MIN_VALUE);
        Product ofDifferentGenre = createProduct(3L, GENRE_SF, Integer.MIN_VALUE);
        given(productRepository.findAll()).willReturn(ImmutableList.of(subject, similar, ofDifferentGenre));

        List<Product> recommendedSimilar = recommendationService.recommendSimilarProducts("1");

        assertThat(recommendedSimilar).extracting("id").containsExactly(2L);
    }

    @Test
    public void recommendedSimilarAreOrderedByRating() throws Exception {
        Product similarWithLowerRating = createProduct(2L, GENRE_HORROR, 1);
        Product similarWithHigherRating = createProduct(3L, GENRE_HORROR, 2);
        given(productRepository.findAll()).willReturn(ImmutableList.of(subject,
                similarWithLowerRating,
                similarWithHigherRating));

        List<Product> recommendedSimilar = recommendationService.recommendSimilarProducts("1");

        assertThat(recommendedSimilar).extracting("id").containsExactly(3L, 2L);
    }

    @Test
    public void notRatedAreExcluded() throws Exception {
        Product notRated = createProduct(2L, GENRE_HORROR, null);
        given(productRepository.findAll()).willReturn(ImmutableList.of(subject, notRated));

        List<Product> recommendedSimilar = recommendationService.recommendSimilarProducts("1");

        assertThat(recommendedSimilar).isEmpty();
    }

    private Product createProduct(Long id, String genre, Integer rating) {
        Product product = new Product(String.valueOf(id), genre);
        product.setId(id);
        product.setRating(rating);
        return product;
    }
}