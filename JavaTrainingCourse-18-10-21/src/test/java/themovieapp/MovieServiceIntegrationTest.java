package themovieapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import themovieapp.Enum.Genre;
import themovieapp.Enum.Rating;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Reason for integration? Testing more than one class (repo and service)
// The tests within verify that the service and repo are able to work together
public class MovieServiceIntegrationTest {
    private MovieService service;

    @BeforeEach
    public void setUp() throws DuplicateMovieException {
        service = MovieService.getInstance(InMemoryMovieRepo.getInstance());
        if (service.returnAllMovies().size() == 0){
            service.add(new Movie("Shawshank", Genre.DRAMA, 1994, "18"));
            service.add(new Movie("Fight Club", Genre.THRILLER, 1999, "18"));
            service.add(new Movie("Breakfast club", Genre.DRAMA, 1988, "15"));
        }
    }

    @Test
    public void addDuplicateMovie() throws DuplicateMovieException {
        service.add(new Movie("Yeet", Genre.DRAMA, 1999, "18"));
        try{
            service.add(new Movie("Yeet", Genre.DRAMA, 1999, "18"));
        } catch (DuplicateMovieException e){
            // Expect expection to be thrown
        }
        assertEquals(4 ,service.findByPartialTitle("").size());
    }

    @Test
    public void testAddAndFindByPartialTitle(){
        var matchingMovies = service.findByPartialTitle("club");
        assertEquals(2, matchingMovies.size());
        System.out.println(matchingMovies.toString());
    }
    @Test
    public void testAddAndFindByGenre(){
        var matchingMovies = service.findByGenre(Genre.DRAMA);
        assertEquals(2, matchingMovies.size());
        System.out.println(matchingMovies.toString());
    }
    @Test
    public void testAddAndFindByReleaseYear(){
        var matchingMovies = service.findByReleaseYear(1999);
        assertEquals(1, matchingMovies.size());
        System.out.println(matchingMovies.toString());
    }
    @Test
    public void testAddAndFindByClassification(){
        var matchingMovies = service.findByClassification("18");
        assertEquals(2, matchingMovies.size());
        System.out.println(matchingMovies.toString());
    }
    @Test
    public void testAddReview(){
        Reviewer reviewer = new Reviewer("Daniel Phillips");
        Reviewer reviewer2 = new Reviewer("Bob Bobson");
        MovieReview review = new MovieReview(service.findByPartialTitle("Shawshank").get(0), reviewer, "Decent", Rating.FIVE_STAR);
        MovieReview review2 = new MovieReview(service.findByPartialTitle("Shawshank").get(0), reviewer2, "Aids", Rating.ONE_STAR);

        assertEquals(service.findByPartialTitle("Shawshank").get(0).getReviews().get(0), review);
        assertEquals(service.findByPartialTitle("Shawshank").get(0).getReviews().get(1), review2);
        System.out.println(service.findByPartialTitle("Shawshank").get(0).getReviews().get(0).getReviewer().getId());
        System.out.println(service.findByPartialTitle("Shawshank").get(0).getReviews().get(1).getReviewer().getId());
    }
}
