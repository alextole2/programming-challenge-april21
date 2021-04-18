package com.movies.api.movies.controller;

import com.movies.api.movies.domain.Movies;
import com.movies.api.movies.domain.MoviesDto;
import com.movies.api.movies.service.MoviesService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    @Inject
    private MoviesService moviesService;

    @RequestMapping(
            value = "yearAndGenre/{year}/{genre}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MoviesDto> getMoviesByYearAndGenre(@PathVariable final int year,
                                                   @PathVariable final String genre) {
        return moviesService.getMoviesByYearAndGenre(year, genre);
    }

    @PostMapping
    public Movies save(@RequestBody final Movies movies) {
        return moviesService.save(movies);
    }
}
