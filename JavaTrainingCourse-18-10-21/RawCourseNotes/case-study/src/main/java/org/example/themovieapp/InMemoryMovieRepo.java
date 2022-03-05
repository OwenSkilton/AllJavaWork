package org.example.themovieapp;

import java.util.ArrayList;

// An instance of this class is resp. for persisting Movie instances
public class InMemoryMovieRepo implements MovieRepo {

    private ArrayList<Movie> movies;

    private static InMemoryMovieRepo repo;

    private InMemoryMovieRepo() {
        movies = new ArrayList<>();
    }

    public static InMemoryMovieRepo getInstance() {
        if (repo == null) {
            repo = new InMemoryMovieRepo();
        }
        return repo;
    }

    @Override
    public void add(Movie movie) {
        movies.add(movie);
    }

    @Override
    public ArrayList<Movie> findAll() {
        return movies;
    }
}
