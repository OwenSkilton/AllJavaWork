package themovieapp;

import themovieapp.Enum.Rating;

import java.time.LocalDate;

public class MovieReview {
    private Movie movie;
    private Reviewer reviewer;
    final static LocalDate date = LocalDate.now();
    private String text;
    private Rating rating;

    public MovieReview(Movie movie, Reviewer reviewer, String text, Rating rating) {
        this.movie = movie;
        this.reviewer = reviewer;
        this.text = text;
        this.rating = rating;
        movie.setReviews(this);
    }

    public Movie getMovie() {
        return movie;
    }

    public Reviewer getReviewer() {
        return reviewer;
    }

    public static LocalDate getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public Rating getRating() {
        return rating;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
