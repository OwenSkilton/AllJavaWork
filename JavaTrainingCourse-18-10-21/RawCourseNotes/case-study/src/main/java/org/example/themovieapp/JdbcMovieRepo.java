package org.example.themovieapp;

import org.h2.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class JdbcMovieRepo implements MovieRepo {

    private static JdbcMovieRepo repo;

    private JdbcMovieRepo() {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            // ignore (see below)
        }
    }

    // Making the method synchronized ensures that only one instance will be created in a multi-threaded env.
    public static synchronized JdbcMovieRepo getInstance() {
        if (repo == null) {
            repo = new JdbcMovieRepo();
        }
        return repo;
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:h2:./moviesdb");
        } catch (SQLException e) {
            // ignore (see below)
            return null;
        }
    }

    @Override
    public void add(Movie movie) {
        var insertSql = "insert into movies (title, genre, release_year, classification) values (?, ?, ?, ?)";
        try {
            var statement = getConnection().prepareStatement(insertSql);
            statement.setString(1, movie.getTitle());
            statement.setString(2, movie.getGenre().toString());
            statement.setInt(3, movie.getReleaseYear());
            statement.setString(4, movie.getClassification());
            statement.execute();
        } catch (SQLException e) {
            // re-throw the SQLException as a RuntimeException so that the caller can choose to handle it or not
            throw new RuntimeException("Could not insert movie: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Movie> findAll() {
        var movies = new ArrayList<Movie>();
        try {
            var statement = getConnection().createStatement();
            var resultSet = statement.executeQuery("select * from movies");
            while (resultSet.next()) {
                var title = resultSet.getString("title");
                var genre = MovieGenre.valueOf(resultSet.getString("genre"));
                var releaseYear = resultSet.getInt("release_year");
                var classification = resultSet.getString("classification");
                movies.add(new Movie(title, genre, releaseYear, classification));
            }
            return movies;
        } catch (SQLException e) {
            throw new RuntimeException("Could not fetch movies: " + e.getMessage());
        }
    }
}
