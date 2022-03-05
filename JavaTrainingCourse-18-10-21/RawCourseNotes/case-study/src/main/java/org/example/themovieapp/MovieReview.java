package org.example.themovieapp;

import java.time.LocalDate;

public class MovieReview {

    private Movie movie;
    private String reviewer;
    private LocalDate date;
    private String text;
    private Rating rating;

    // The assoc. between MovieReview and Movie is an aggregate
    // That is, a Movie can exist without the MovieReview
    // The relationship is uni-directional
    // That is, the MovieReview knows about the Movie but not vice-versa
    public MovieReview(Movie movie, String reviewer, String text, Rating rating) {
        this.movie = movie;
        this.reviewer = reviewer;
        this.date = LocalDate.now();
        this.text = text;
        this.rating = rating;
    }

    public Movie getMovie() {
        return movie;
    }

    public MovieReview setMovie(Movie movie) {
        this.movie = movie;
        return this;
    }

    public String getReviewer() {
        return reviewer;
    }

    public MovieReview setReviewer(String reviewer) {
        this.reviewer = reviewer;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public MovieReview setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public String getText() {
        return text;
    }

    public MovieReview setText(String text) {
        this.text = text;
        return this;
    }

    public Rating getRating() {
        return rating;
    }

    public MovieReview setRating(Rating rating) {
        this.rating = rating;
        return this;
    }
}
