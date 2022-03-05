package streams;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    // IO streams have existed in Java from day 1
    // An IO stream is used to move data from/to a file
    // Think about data flowing from point a to point b

    // Streams (java.util.stream) are used to process data
    // It is more like a production line where the data is manipulated
    // Each operation creates a new stream
    // Streams are NOT used to modify data but rather to transform it
    // We use streams to transform collections
    // The primary benefit is that the code is declarative (WHAT) not imperative (HOW)

    @Test
    public void testBasicStream() {
        var names = List.of("Chris", "Owen", "Nathan", "Carlin", "Harley");
        var initials = names.stream()
                .filter(name -> name.length() > 5) // <!-- result is a new stream containing only those names with 5 or more chars
                .map(name -> name.charAt(0)) // <!-- result is a new stream containing initials
                .collect(Collectors.toList());
        System.out.println(names);
        System.out.println(initials);
    }

    @Test
    public void testStreamCreation() {

        // Streams can be created from any collection
        var s1 = Set.of(1, 2, 3).stream();

        var s2 = Map.of("K1", "V1").values().stream();

        // Streams can be created from nothing
        var s3 = Stream.of(1, 2, 3);

        // By default a Stream contains refs but you can create a primitive stream
        var s4 = DoubleStream.of(1.5, 1.7, 1.9);

        // You can even create an empty stream
        var s5 = Stream.empty();
    }

    @Test
    public void testIntermediateOperations() {

        // As per above filter and map are the most common intermediate operations

        var uniqueNums = List.of(1, 2, 2, 3, 3).stream().distinct().collect(Collectors.toList());

        var first5 = Stream.iterate(1, n -> n + 1).limit(5).collect(Collectors.toList());

        var listOfLists = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        );
        // flatMap flattens the inner stream onto the outer stream
        var allNums = listOfLists.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());

        var sortedNums = List.of(2, 3, 1).stream().sorted().collect(Collectors.toList());

        List.of(1, 2, 3).stream()
                .map(n -> n * n)
                .peek(n -> System.out.println(n))
                .map(n -> "The number is " + n)
                .collect(Collectors.toList());
    }

    @Test
    public void testTerminalOperations() {

        // As per above collect is the most common terminal operation

        // forEach accepts a Consumer whose one method accepts one arg and returns nothing
        List.of("Hello", "How are you?", "Goodbye").stream().forEach(s -> System.out.println(s));

        List.of(1, 2, 3).stream().findAny().ifPresent(n -> System.out.println(n));

        var hasNamesStartingWithS = List.of("Tom", "Dick", "Harry").stream()
                .anyMatch(name -> name.startsWith("S"));

        // Primitive streams have their own set of terminal operations, e.g. sum, avg, min, max etc.
        IntStream.of(1, 2, 3).sum();
        List.of(1, 2, 3).stream().mapToInt(n -> n).average();
    }
}
