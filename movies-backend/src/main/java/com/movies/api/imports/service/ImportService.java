package com.movies.api.imports.service;

import com.movies.api.core.enums.ErrorType;
import com.movies.api.core.exception.ServiceException;
import com.movies.api.imports.MimeTypes;
import com.movies.api.movies.domain.Movies;
import com.movies.api.movies.service.MoviesService;
import com.movies.api.ratings.domain.Ratings;
import com.movies.api.ratings.service.RatingsService;
import com.opencsv.CSVReader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;

@Service("importService")
public class ImportService {

    @Inject
    private MoviesService moviesService;

    @Inject
    private RatingsService ratingsService;

    final static String[] MOVIES_HEADER = new String[]{"movieId", "title", "genres"};
    final static String[] RATING_HEADER = new String[]{"userId", "movieId", "rating", "timestamp"};

    public void fillDataBaseFrom(final MultipartFile file) {

        CSVReader reader = null;
        final char SEPARATOR = ',';

        try {

            if (MimeTypes.isCsvMultipartFile(file)) {

                final InputStreamReader inputStreamReader = new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8);
                reader = new CSVReader(inputStreamReader, SEPARATOR);
                boolean isRatingsTable = Boolean.FALSE;
                boolean isMoviesTable = Boolean.FALSE;
                int recordNumber = 0;
                String[] next;
                while ((next = reader.readNext()) != null) {

                    if (recordNumber == 0) {
                        //Header data
                        isMoviesTable = Arrays.equals(next, MOVIES_HEADER);
                        isRatingsTable = Arrays.equals(next, RATING_HEADER);
                    } else {
                        //Movies data
                        if (isMoviesTable) {
                            moviesService.save(new Movies(next));
                        }
                        //Ratings data
                        if (isRatingsTable) {
                            ratingsService.save(new Ratings(next));
                        }
                    }

                    recordNumber++;
                }

            } else {
                throwServiceException();
            }

        } catch (Exception e) {
            throw new ServiceException(e.hashCode(), e.getMessage());
        } finally {
            finalizingCSVReader(reader);
        }
    }

    public static void throwServiceException() {
        throw new ServiceException(ErrorType.FILE_UPLOADED_IS_NOT_AVAILABLE_FILE);
    }

    static void finalizingCSVReader(CSVReader reader) {
        try {
            if (Objects.nonNull(reader)) {
                reader.close();
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}