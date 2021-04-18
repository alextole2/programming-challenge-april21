package com.movies.api.movies.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "movies")
@Entity
public class Movies implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "movie_id", insertable = false, nullable = false)
    private Long movieId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "genres", nullable = false)
    private String genres;

    public Movies() {
    }

    public Movies(String[] values) {
        this.movieId = Long.valueOf(values[0]);
        this.title = values[1];
        this.genres = values[2];
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}