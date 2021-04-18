package com.movies.api.ratings.service;

import com.movies.api.ratings.domain.RatedMovies;
import com.movies.api.ratings.domain.Ratings;
import com.movies.api.ratings.repository.RatingsRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Service("ratingsService")
public class RatingsService {
    @Inject
    private RatingsRepository ratingsRepository;

    public List<RatedMovies> getTopRatedMovies(final int limit) {
        return ratingsRepository.getTopRatedMovies(limit)
                .stream()
                .map(RatedMovies::new)
                .collect(Collectors.toList());
    }

    public Ratings save(final Ratings ratings) {
        return ratingsRepository.save(ratings);
    }

    public List<Ratings> saveAll(final List<Ratings> ratings) {
        return ratingsRepository.saveAll(ratings);
    }

}
