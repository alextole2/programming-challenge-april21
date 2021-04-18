package com.movies.api.movies.repository;

import com.movies.api.movies.domain.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface MoviesRepository extends JpaRepository<Movies, Long> {
    @Query(value = "SELECT * FROM movies WHERE title LIKE %:year% AND genres LIKE %:genre%",
            nativeQuery = true)
    List<Movies> getMoviesByYearAndGenre(@Param("year") String year,
                                         @Param("genre") String genre);
}