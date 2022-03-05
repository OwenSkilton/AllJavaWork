package concurrency.threads;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadExercise {
    List<String> imdbs = List.of(
            "tt1245526",
            "tt0289765",
            "tt0099810",
            "tt0268978",
            "tt2800344",
            "tt2407482",
            "tt0066026",
            "tt0365830",
            "tt0382625",
            "tt0097142",
            "tt2647548",
            "tt4422448",
            "tt1175491",
            "tt5311514",
            "tt0188404",
            "tt0240200",
            "tt0363390",
            "tt6869604",
            "tt0304120",
            "tt2347569",
            "tt2095684",
            "tt1047490",
            "tt1592873",
            "tt0043766",
            "tt7958736",
            "tt0371746",
            "tt1228705",
            "tt0413300",
            "tt0088763",
            "tt0092099"
    );

   @Test
    public void fetch30MoviesNoThreads(){
        var start = Instant.now();
        imdbs.forEach(movie -> {
            try {
                movieRequest(movie);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        var end = Instant.now();
        System.out.println(Duration.between(start,end));
    }
    @Test
    public void fetch30MoviesWithThreads(){
        var start = Instant.now();

        var executor = Executors.newFixedThreadPool(30);
        var futures = new ArrayList<Future<String>>();
        imdbs.stream().forEach(movie -> futures.add((Future<String>) executor.submit(() -> {
            try {
                movieRequest(movie);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        })));
        futures.stream().forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        executor.shutdown();
        var end = Instant.now();
        System.out.println(Duration.between(start,end));
    }



    public String movieRequest(String imdbID) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://www.omdbapi.com/?apikey=adc61053&i=" + imdbID)).build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }


}
