package org.example.themovieapp;

import java.util.Optional;

public enum Rating {

    NOT_RATED(Optional.empty()), ZERO_STARS(Optional.of(0)), ONE_STAR(Optional.of(1)),
    TWO_STARS(Optional.of(2)), THREE_STARS(Optional.of(3)), FOUR_STARS(Optional.of(4)),
    FIVE_STARS(Optional.of(5));

    private Optional<Integer> intValue;

    Rating(Optional<Integer> intValue) {
        this.intValue = intValue;
    }

    public Optional<Integer> getIntValue() {
        return intValue;
    }
}
