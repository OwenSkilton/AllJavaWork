package org.example.themovieapp;

import org.h2.Driver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JdbcMovieRepoTest {

    private JdbcMovieRepo repo;

    @BeforeEach
    public void setUp() throws SQLException {
        DriverManager.registerDriver(new Driver());
        var connection = DriverManager.getConnection("jdbc:h2:./moviesdb");
        var statement = connection.createStatement();
        statement.execute("drop table if exists movies");
        statement.execute("create table movies (" +
                "title varchar(255), " +
                "genre varchar(255), " +
                "release_year int, " +
                "classification varchar(255))");
        repo = JdbcMovieRepo.getInstance();
        repo.add(new Movie("Wayne's World", MovieGenre.COMEDY, 1992, "MA"));
        repo.add(new Movie("The Shawshank Redemption", MovieGenre.DRAMA, 1994, "MA"));
    }

    @Test
    public void testFindAll() {
        var movies = repo.findAll();
        assertEquals(2, movies.size());
        assertEquals("Wayne's World", movies.get(0).getTitle());
        assertEquals("The Shawshank Redemption", movies.get(1).getTitle());
    }

    @Test
    public void testAdd() {
        repo.add(new Movie("American History X", MovieGenre.DRAMA, 1999, "R"));
        assertEquals(3, repo.findAll().size());
    }
}
