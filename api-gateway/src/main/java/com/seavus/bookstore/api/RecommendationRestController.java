package com.seavus.bookstore.api;

import com.seavus.bookstore.bookmanagement.api.BookService;
import com.seavus.bookstore.rating.api.RatingService;
import com.seavus.bookstore.recommendation.api.RecommendationService;
import com.seavus.karaka.restapi.RestController;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class RecommendationRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecommendationRestController.class);

    private final RecommendationService recommendationService;

    private final BookService bookService;

    private final RatingService ratingService;

    @RequestMapping(value = "/{id}/similar", method = RequestMethod.GET)
    public List<Book> recommendSimilarBooks(@PathVariable("id") String id) {
        try {
            return recommendationService.recommendSimilarProducts(id)
                    .stream()
                    .map(BookMapper.INSTANCE::from)
                    .peek(setTitleAuthorAndGenre())
                    .peek(setRating())
                    .collect(Collectors.toList());

        } catch (RuntimeException e) {
            LOGGER.warn("Unable to recommend books similar to {}", id);
            return null;
        }
    }

    private Consumer<Book> setTitleAuthorAndGenre() {
        return book -> {
            com.seavus.bookstore.bookmanagement.api.Book bookManagementBook = bookService.findBookByUuid(book.getId());
            book.setTitle(bookManagementBook.getTitle());
            book.setAuthor(bookManagementBook.getAuthor());
            book.setGenre(bookManagementBook.getGenre());
        };
    }

    private Consumer<Book> setRating() {
        return book -> {
            try {
                book.setRating(ratingService.getProductRating(book.getId()));
            } catch (RuntimeException e) {
                LOGGER.warn("Unable to get rating for book {}", book.getId());
            }
        };
    }
}
