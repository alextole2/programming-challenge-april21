package com.movies.api.ratings.repository;

import com.movies.api.ratings.domain.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface RatingsRepository extends JpaRepository<Ratings, Long> {

    @Query(value = "SELECT title, avg(rating) AS rated FROM ratings, movies WHERE ratings.movie_id = movies.movie_id GROUP BY title ORDER BY avg(rating) desc limit :limit",
            nativeQuery = true)
    List<Object[]> getTopRatedMovies(@Param("limit") int limit);
}