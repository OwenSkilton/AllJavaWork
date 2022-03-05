package org.example.themovieapp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// An instance of this class is resp. for implementing business logic
public class MovieService {

    private MovieRepo repo;

    private static MovieService service;

    private MovieService(MovieRepo repo) {
        this.repo = repo;
    }

    public static MovieService getInstance(MovieRepo repo) {
        if (service == null) {
            service = new MovieService(repo);
        }
        return service;
    }

    public void add(Movie movie) throws DuplicateMovieException {
        if (repo.findAll().contains(movie)) {
            throw new DuplicateMovieException();
        }
        repo.add(movie);
    }

    private List<Movie> findBy(Predicate<Movie> predicate) {
        return repo.findAll().stream().filter(predicate).collect(Collectors.toList());
    }

    public List<Movie> findByPartialTitle(String partialTitle) {
        return findBy(m -> m.getTitle().toLowerCase().contains(partialTitle.toLowerCase()));
    }

    public List<Movie> findByGenre(String genre) {
        return findBy(m -> m.getGenre() == MovieGenre.valueOf(genre));
    }

    public List<Movie> findByReleaseYearInRange(int fromYearIncl, int toYearExcl) {
        return findBy(m -> m.getReleaseYear() >= fromYearIncl && m.getReleaseYear() < toYearExcl);
    }

    public List<Movie> findByClassification(String classification) {
        return findBy(m -> m.getClassification().equalsIgnoreCase(classification));
    }

    public List<Movie> search(String query) {
        // the query might look like this: s=genre:eq:comedy;title:lk:blue;releaseYear:gt:2000
        // we would need to parse the query string and build Predicates dynamically
        return null;
    }
}
