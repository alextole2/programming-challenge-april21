package com.movies.api.ratings.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class RatingsDto {
    private Long userId;
    private Long movieId;
    private BigDecimal rating;
    private Timestamp timestamp;

    public RatingsDto(final Ratings ratings) {
        this.userId = ratings.getUserId();
        this.movieId = ratings.getMovieId();
        this.rating = ratings.getRating();
        this.timestamp = ratings.getTimestamp();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
