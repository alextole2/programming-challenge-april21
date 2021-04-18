package com.movies.api.ratings.controller;

import com.movies.api.ratings.domain.RatedMovies;
import com.movies.api.ratings.domain.Ratings;
import com.movies.api.ratings.domain.RatingsDto;
import com.movies.api.ratings.service.RatingsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

    @Inject
    private RatingsService ratingsService;

    @RequestMapping(
            value = "byTop/{limit}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RatedMovies> getTopRatedMovies(@PathVariable final int limit) {
        return ratingsService.getTopRatedMovies(limit);
    }

    @PostMapping
    public Ratings save(@RequestBody final Ratings ratings) {
        return ratingsService.save(ratings);
    }
}
