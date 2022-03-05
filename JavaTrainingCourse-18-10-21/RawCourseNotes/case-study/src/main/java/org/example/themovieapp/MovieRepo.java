package org.example.themovieapp;

import java.util.ArrayList;

public interface MovieRepo {

    void add(Movie movie);

    ArrayList<Movie> findAll();
}
