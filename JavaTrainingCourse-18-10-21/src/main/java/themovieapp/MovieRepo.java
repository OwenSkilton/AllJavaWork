package themovieapp;

import java.util.ArrayList;

// An instance of this class is responsible for persisting Move instances
// Class represents the encapsulation of functionality
public interface MovieRepo {

    void addMovie(Movie movie) throws DuplicateMovieException;

    ArrayList<Movie> returnMovies();
}
