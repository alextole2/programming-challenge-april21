package com.movies.api.ratings.domain;

import java.math.BigDecimal;

public class RatedMovies {
    private String title;
    private BigDecimal rated;

    public RatedMovies() {
    }

    public RatedMovies(String title,
                       BigDecimal rated) {
        this.title = title;
        this.rated = rated;
    }

    public RatedMovies(Object[] values) {
        this.title = (String) values[0];
        this.rated = (BigDecimal) values[1];
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getRated() {
        return rated;
    }

    public void setRated(BigDecimal rated) {
        this.rated = rated;
    }
}
