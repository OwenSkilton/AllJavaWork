package org.example.themovieapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class RatingTest {

    @Test
    public void testRatingIntValue() {
        var rating = Rating.FIVE_STARS;
        assertEquals(5, rating.getIntValue().get());
    }

    @Test
    public void testNonExistentRatingIntValue() {
        var rating = Rating.NOT_RATED;
        if (rating.getIntValue().isPresent()) {
            fail("NOT_RATED should not have an intValue");
        }
    }
}
