package themovieapp;

import java.util.ArrayList;

public class InMemoryMovieRepo implements MovieRepo {

    private ArrayList<Movie> movies;

    private static InMemoryMovieRepo inMemoryMovieRepo;

    public static InMemoryMovieRepo getInstance(){
        if (inMemoryMovieRepo == null){
            inMemoryMovieRepo = new InMemoryMovieRepo();
        }
        return inMemoryMovieRepo;
    }

    private InMemoryMovieRepo() {
        movies = new ArrayList<>();
    }

    @Override
    public void addMovie(Movie movie) throws DuplicateMovieException{
        if(inMemoryMovieRepo.returnMovies().contains(movie)){
            throw new DuplicateMovieException();
        }
        movies.add(movie);
    }

    @Override
    public ArrayList<Movie> returnMovies(){
        return movies;
    }

}
