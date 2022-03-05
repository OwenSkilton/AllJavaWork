package themovieapp;

import themovieapp.Enum.Genre;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        var movies = new Movie[] {
                new Movie("Movie 4", Genre.DRAMA, 1999, "18"),
                new Movie("Movie 3", Genre.COMEDY, 2003, "15"),
                new Movie("Movie 2", Genre.COMEDY, 1994, "PG"),
                new Movie("Movie 8", Genre.SCI_FI, 1994, "18"),
                new Movie("Movie 10", Genre.THRILLER, 2011, "12"),
                new Movie("Movie 6", Genre.DRAMA, 2005, "PG-13"),
                new Movie("Movie 9", Genre.THRILLER, 2007, "15"),
                new Movie("Movie 7", Genre.SCI_FI, 1989, "18"),
                new Movie("Movie 1", Genre.COMEDY, 1991, "U"),
                new Movie("Movie 5", Genre.DRAMA, 2000, "12")
        };

        Arrays.sort(movies);

        for (var movie : movies){
            System.out.println(movie.getTitle());
        }

    }
}
