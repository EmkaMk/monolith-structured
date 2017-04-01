package com.seavus.bookstore.api;

import com.seavus.bookstore.rating.api.RatingService;
import com.seavus.karaka.restapi.JsonArg;
import com.seavus.karaka.restapi.RestController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class RatingRestController {

    private final RatingService ratingService;

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void rateBook(@PathVariable("id") String id, @JsonArg Integer rating) {
        ratingService.rateProduct(id, rating);
    }
}
