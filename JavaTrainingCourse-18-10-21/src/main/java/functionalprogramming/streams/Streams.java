package functionalprogramming.streams;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    // IO streams is used to move data from / to a file
    // Flowing from point a to point b

    // Streams (java.util.streams) are used to process data
    // More like production line where data is manipulated
    // Each operation creates a new stream
    // Streams are NOT used to modify data but rather to transform it
    // We use streams to transform collections
    // Primary benefit is that the code is declarative (WHAT) not imperative (HOW)

    @Test
    public void testBasicStream(){
        var names  = List.of("Chris", "Owen", "Nathan", "Harley");
        var initials = names.stream() // <!-- transform names list into new collection called initials
                .filter(name ->name.length() > 5) // <!-- filter to only return results greater than 5
                .map(name -> name.charAt(0)) // <!-- get characters for each
                .collect(Collectors.toList()); // <!-- can convert to many collections, this case returns to list
        System.out.println(names);
        System.out.println(initials);

    }

    @Test
    public void testStreamCreation() {
        // Streams can be created from any collection
        var s1 = Set.of(1,2,3).stream();

        var s2 = Map.of("K1", "V1", "K2", "V2").values().stream();

        // Streams can be created from nothing
        var s3 = Stream.of(1,2,3);

        // By default a stream contains refs but you can create a primitive stream
        var s4 = DoubleStream.of(1.1,1.2,1.3);

        // Can even create and empty stream
        var s5 = Stream.empty();
    }

    @Test
    public void testIntermediateOperations() {

        // filter and map are the most popular intermediate operations
        var uniqueNums = List.of(1,2,3,2,3,4,5,2,1).stream().distinct().collect(Collectors.toList());
        System.out.println(uniqueNums);

        var first5 = Stream.iterate(1, n -> n +1).limit(5).collect(Collectors.toList());
        System.out.println(first5);

        var listOfLists = List.of(
                List.of(1,2,3),
                List.of(4,5,6),
                List.of(7,8,9)
        );
        // flatMap when ever you have a list of lists or a list of objects containing a list property
        var allNums = listOfLists.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
        System.out.println(allNums);

        var sortedNums = List.of(2,3,1).stream().sorted().collect(Collectors.toList());
        System.out.println(sortedNums);

        // Peak lets you execute some code inbetween operations.
        List.of(1,2,3).stream()
                .map(n -> n^2)
                .peek(n -> System.out.println(n))
                .map(n -> "The number is: " + n)
                .collect(Collectors.toList());

    }

    @Test
    public void  testTerminalOperations(){

        // As per above collect is the most common terminal operation

        // forEach accepts a Consumer whose one method accepts one arg and returns nothing
        List.of("Hello", "Wagwan", "goodbye").stream().forEach(s -> System.out.println(s));

        List.of(1,2,3).stream().findAny().ifPresent(n -> System.out.println(n));

        var hasNamesStartWithH = List.of("Tom", "Dick", "Harry").stream().anyMatch(name -> name.startsWith("H"));
        System.out.println(hasNamesStartWithH);

        // Primitive streams have their own set of terminal operations, e.g. sim, avg, min, max etc
        IntStream.of(1,2,3).sum();
        List.of(1,2,3).stream().mapToInt(n ->n).average();
    }

}
