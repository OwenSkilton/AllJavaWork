package org.example.themovieapp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {

    @Test
    public void testMovieTransformation() {
        // Movie instances are immutable
        // But we added methods to create new Movies from existing ones, e.g. withNewTitle
        var m1 = new Movie("Some Movie", MovieGenre.DRAMA, 2021, "MA");
        var m2 = m1.withNewTitle("Some Other Movie");
        assertEquals("Some Movie", m1.getTitle());
        assertEquals("Some Other Movie", m2.getTitle());
    }

    @Test
    public void testMovieSortOrder() {
        var movies = new Movie[] {
                new Movie("Movie 1", MovieGenre.COMEDY, 2021, "MA"),
                new Movie("Movie 2", MovieGenre.ACTION, 2021, "MA"),
                new Movie("Movie 3", MovieGenre.COMEDY, 2019, "MA"),
        };
        Arrays.sort(movies);
        assertEquals("Movie 2", movies[0].getTitle());
        assertEquals("Movie 3", movies[1].getTitle());
        assertEquals("Movie 1", movies[2].getTitle());
    }
}
