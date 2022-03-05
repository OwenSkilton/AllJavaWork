package org.example.themovieapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// The tests in this class verify that the service and repo work together correctly
public class MovieServiceIntegrationTest {

    private MovieService service;

    @BeforeEach
    public void setUp() {
        service = MovieService.getInstance(InMemoryMovieRepo.getInstance());
    }

    @Test
    public void testAddAndFindByPartialTitle() throws DuplicateMovieException {
        service.add(new Movie("The Blues Brothers", MovieGenre.COMEDY, 1980, "MA"));
        service.add(new Movie("The Shawshank Redemption", MovieGenre.DRAMA, 1994, "MA"));
        service.add(new Movie("Varsity Blues", MovieGenre.DRAMA, 1999, "MA"));
        var matchingMovies = service.findByPartialTitle("blues");
        assertEquals(2, matchingMovies.size());
    }

    @Test
    public void testAddDuplicateMovie() throws DuplicateMovieException {
        service.add(new Movie("The Blues Brothers", MovieGenre.COMEDY, 1980, "MA"));
        try {
            service.add(new Movie("The Blues Brothers", MovieGenre.COMEDY, 1980, "MA"));
            fail("The service did not throw a DuplicateMovieException when a duplicate Movie was added");
        } catch (DuplicateMovieException e) {
            // We expect an exception to be thrown
        }
    }
}
