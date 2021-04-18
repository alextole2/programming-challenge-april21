package com.movies.api.movies.service;

import com.movies.api.movies.domain.Movies;
import com.movies.api.movies.domain.MoviesDto;
import com.movies.api.movies.repository.MoviesRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Service("moviesService")
public class MoviesService {

    @Inject
    private MoviesRepository moviesRepository;

    private String toEnclosedYearStr(final int year) {
        return "(" + year + ")";
    }

    private List<MoviesDto> toMoviesDto(final List<Movies> movies) {
        return movies.stream()
                .map(MoviesDto::new)
                .collect(Collectors.toList());
    }

    public List<MoviesDto> getMoviesByYearAndGenre(final int year,
                                                   final String genre) {
        return toMoviesDto(moviesRepository.getMoviesByYearAndGenre(toEnclosedYearStr(year), genre));
    }

    public Movies save(final Movies movies) {
        return moviesRepository.save(movies);
    }

    public List<Movies> saveAll(final List<Movies> movies) {
        return moviesRepository.saveAll(movies);
    }
}
