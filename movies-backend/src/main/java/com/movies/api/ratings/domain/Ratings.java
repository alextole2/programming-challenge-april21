package com.movies.api.ratings.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "ratings")
public class Ratings implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, name = "rating_id", nullable = false)
    private BigInteger ratingId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "movie_id", nullable = false)
    private Long movieId;

    @Column(name = "rating", nullable = false)
    private BigDecimal rating;

    @Column(name = "timestamp", nullable = false)
    private Timestamp timestamp;

    public Ratings() {

    }

    public Ratings(String[] values) {
        this.userId = Long.valueOf(values[0]);
        this.movieId = Long.valueOf(values[1]);
        this.rating = BigDecimal
                .valueOf(Double.parseDouble(values[2]))
                .setScale(1, BigDecimal.ROUND_HALF_UP);
        this.timestamp = new Timestamp(Long.parseLong(values[3]));
    }

    public BigInteger getRatingId() {
        return ratingId;
    }

    public void setRatingId(BigInteger ratingId) {
        this.ratingId = ratingId;
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