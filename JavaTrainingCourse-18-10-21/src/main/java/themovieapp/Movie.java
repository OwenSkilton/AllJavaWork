package themovieapp;

import themovieapp.Enum.Genre;

import java.util.ArrayList;
import java.util.Objects;

// Instances represent persistent storage (represents data)
// This type of class is often referred to as a POJO (Plain old java class) class or a model
public class Movie implements Comparable<Movie> {
    final private String title;
    final private Genre genre;
    final private int releaseYear;
    final private String classification;
    final private ArrayList<MovieReview> reviews = new ArrayList<>();

    public Movie(String title, Genre genre, int releaseYear, String classification) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.classification = classification;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getClassification() {
        return classification;
    }

    public ArrayList<MovieReview> getReviews() {
        return reviews;
    }

    public void setReviews(MovieReview review) {
        this.reviews.add(review);
    }

    public Movie withNewTitle(String title){
        return new Movie(title,genre,releaseYear,classification);
    }

    public Movie withNewGenre(Genre genre){
        return new Movie(title,genre,releaseYear,classification);
    }

    public Movie withNewClassification(String classification){
        return new Movie(title,genre,releaseYear,classification);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return releaseYear == movie.releaseYear && title.equals(movie.title) && genre.equals(movie.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genre, releaseYear);
    }

    @Override
    public int compareTo(Movie o) {
        // Because enums are sorted by ordinal (index) not by name need the toString
        var result = this.genre.toString().compareTo(o.genre.toString());
        if (result == 0){
            result = this.releaseYear - o.releaseYear;
        }if (result == 0){
            result = this.title.compareTo(o.title);
        }
        return result;
    }
}
