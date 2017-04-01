package com.seavus.bookstore.api;

import com.seavus.bookstore.bookmanagement.api.BookService;
import com.seavus.bookstore.rating.api.RatingService;
import com.seavus.karaka.restapi.RestController;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class BookRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookRestController.class);

    private final BookService bookService;

    private final RatingService ratingService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> findBooks() {
        List<Book> books = bookService.findBooks()
                .stream()
                .map(BookMapper.INSTANCE::from)
                .peek(setRating())
                .collect(Collectors.toList());
        return books;
    }

    private Consumer<Book> setRating() {
        return book -> {
            try {
                book.setRating(ratingService.getProductRating(book.getId()));
            } catch (RuntimeException e) {
                LOGGER.error("Unable to get rating for book {}", book.getId());
            }
        };
    }
}
