package org.example.themovieapp;

import java.util.Objects;

// Instances of this class represent data in persistent storage
// This type of class is often referred to as a POJO (plain old Java object) class or a model
public class Movie implements Comparable<Movie> {

    private String title;
    private MovieGenre genre;
    private  int releaseYear;
    private String classification;

    public Movie(String title, MovieGenre genre, int releaseYear, String classification) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.classification = classification;
    }

    @Override
    public int compareTo(Movie other) {
        // Enums are sorted by ordinal (index) not by name by default
        var result = this.genre.toString().compareTo(other.genre.toString());
        if (result == 0) {
            result = this.releaseYear - other.releaseYear;
        }
        if (result == 0) {
            result = this.title.compareTo(other.title);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return getReleaseYear() == movie.getReleaseYear() && Objects.equals(getTitle(), movie.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getReleaseYear());
    }

    public String getTitle() {
        return title;
    }

    public Movie withNewTitle(String title) {
        return new Movie(title, genre, releaseYear, classification);
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public Movie withNewGenre(MovieGenre genre) {
        return new Movie(title, genre, releaseYear, classification);
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public Movie withNewReleaseYear(int releaseYear) {
        return new Movie(title, genre, releaseYear, classification);
    }

    public String getClassification() {
        return classification;
    }

    public Movie withNewClassification(String classification) {
        return new Movie(title, genre, releaseYear, classification);
    }
}
