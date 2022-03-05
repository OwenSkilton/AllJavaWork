package org.example.themovieapp;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MovieUtils {

    // TODO: ultimately this method should return a Movie object, not a String
    public static String fetchMovie(String imdbID) {
        try {
            var request = HttpRequest.newBuilder()
                    .uri(URI.create("https://www.omdbapi.com/?apikey=fa9f0d49&i=" + imdbID))
                    .GET()
                    .build();
            var response = HttpClient.newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
