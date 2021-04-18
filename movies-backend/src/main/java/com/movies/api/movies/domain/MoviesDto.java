package com.movies.api.movies.domain;

public class MoviesDto {
    private Long movieId;
    private String title;
    private String genres;

    public MoviesDto(final Movies movies) {
        this.movieId = movies.getMovieId();
        this.title = movies.getTitle();
        this.genres = movies.getGenres();
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
