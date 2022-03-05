package themovieapp;

import themovieapp.Enum.Genre;

import java.util.ArrayList;

// An instance of this class is responsible for implementing business logic
public class MovieService {

    private MovieRepo repo;

    private static MovieService movieService;

    public static MovieService getInstance(MovieRepo repo){
        if (movieService == null){
            movieService = new MovieService(repo);
        }
        return movieService;
    }
    private MovieService(MovieRepo repo) {
        this.repo = repo;
    }

    public void add(Movie movie) throws DuplicateMovieException {
        if (repo.returnMovies().contains(movie)){
            throw new DuplicateMovieException();
        }
        repo.addMovie(movie);
    }

    public ArrayList<Movie> findByPartialTitle(String partialTitle){
        var matchingMovies = new ArrayList<Movie>();
        for (var movie: repo.returnMovies()){
            if (movie.getTitle().toLowerCase().contains(partialTitle.toLowerCase())){
                matchingMovies.add(movie);
            }
        }
        return matchingMovies;
    }

    public ArrayList<Movie> findByGenre(Genre genre){
        var matchingMovies = new ArrayList<Movie>();
        for (var movie: repo.returnMovies()){
            if (movie.getGenre() == genre){
                matchingMovies.add(movie);
            }
        }
        return matchingMovies;
    }

    public ArrayList<Movie> findByReleaseYear(int releaseYear){
        var matchingMovies = new ArrayList<Movie>();
        for (var movie: repo.returnMovies()){
            if (movie.getReleaseYear() == releaseYear){
                matchingMovies.add(movie);
            }
        }
        return matchingMovies;
    }

    public ArrayList<Movie> findByClassification(String classification){
        var matchingMovies = new ArrayList<Movie>();
        for (var movie: repo.returnMovies()){
            if (movie.getClassification().toLowerCase().contains(classification.toLowerCase())){
                matchingMovies.add(movie);
            }
        }
        return matchingMovies;
    }

    public ArrayList<Movie> returnAllMovies(){
        return repo.returnMovies();
    }
}
