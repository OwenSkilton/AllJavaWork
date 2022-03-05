package org.example.themovieapp;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MovieUtilsTest {

    private List<String> imdbIDs = List.of(
            "tt1245526",
            "tt0289765",
            "tt0099810",
            "tt0120863",
            "tt2873282",
            "tt1821694",
            "tt0421239",
            "tt1486185",
            "tt1234719",
            "tt0095963",
            "tt2334873",
            "tt1120985",
            "tt0090756",
            "tt0149261",
            "tt0181316",
            "tt0378109",
            "tt2359024",
            "tt0080453",
            "tt1344204",
            "tt0296310",
            "tt0120689",
            "tt6966692",
            "tt1133985",
            "tt0990407",
            "tt0947810",
            "tt4062536",
            "tt0101921",
            "tt0070723",
            "tt9243804",
            "tt1462769"
    );

    @Test
    public void testFetch30MoviesNoThreads() {
        var start = Instant.now();
        imdbIDs.stream().map(imdbID -> MovieUtils.fetchMovie(imdbID)).forEach(movie -> System.out.println(movie));
        var end = Instant.now();
        System.out.println(Duration.between(start, end));
    }

    @Test
    public void testFetch30MoviesWithThreads() {
        var start = Instant.now();
        var executor = Executors.newFixedThreadPool(10);
        var futures = new ArrayList<Future<String>>();
        imdbIDs.stream().forEach(imdbID -> futures.add(executor.submit(() -> MovieUtils.fetchMovie(imdbID))));
        futures.stream().forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        executor.shutdown();
        var end = Instant.now();
        System.out.println(Duration.between(start, end));
    }
}
